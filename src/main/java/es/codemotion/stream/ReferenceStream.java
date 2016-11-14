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
        return new FilterStream<>(this, condition);
    }

    @Override
    public final <R> Stream<R> map(Function<T, R> mapper)
    {
        throw new UnsupportedOperationException("Not implemented!");
    }

    @Override
    public final Stream<T> distinct()
    {
        return new DistinctStream<>(this);
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
