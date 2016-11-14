package es.codemotion.stream;

import java.util.function.Predicate;

final class FilterSink<T> extends ChainedSink<T, T>
{
    private final Predicate<T> condition;

    public FilterSink(Sink<T> next, Predicate<T> condition)
    {
        super(next);
        this.condition = condition;
    }

    @Override
    public void accept(T element)
    {
        if (condition.test(element))
        {
            next.accept(element);
        }
    }
}
