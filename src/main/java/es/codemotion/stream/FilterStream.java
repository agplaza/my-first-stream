package es.codemotion.stream;

import java.util.function.Predicate;

final class FilterStream<T> extends ReferenceStream<T, T>
{
    private final Predicate<T> condition;

    public FilterStream(AbstractStream<?, T> previous, Predicate<T> condition)
    {
        super(previous);
        this.condition = condition;
    }

    @Override
    protected Sink<T> wrapSink(Sink<T> sink)
    {
        return new FilterSink<>(sink, condition);
    }
}
