package es.codemotion.stream;

import java.util.function.Function;
import java.util.function.Predicate;

abstract class ReferenceStream<P, T> extends AbstractStream<P, T>
{
    protected ReferenceStream(AbstractStream<?, P> previous)
    {
        super(previous);
    }

    @Override
    public final Stream<T> filter(Predicate<T> condition)
    {
        return new IntermediateStream<>(this, sink -> new FilterSink<>(sink, condition));
    }

    @Override
    public final <R> Stream<R> map(Function<T, R> mapper)
    {
        return new IntermediateStream<>(this, sink -> new MapSink<>(sink, mapper));
    }

    @Override
    public final Stream<T> distinct()
    {
        return new IntermediateStream<>(this, sink -> new DistinctSink<>(sink));
    }

    @Override
    public final long count()
    {
        return evaluate(new CountSink<>());
    }

    @Override
    public final Object[] toArray()
    {
        return evaluate(new ToArraySink<>());
    }
}
