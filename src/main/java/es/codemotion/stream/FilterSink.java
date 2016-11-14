package es.codemotion.stream;

import java.util.function.Predicate;

final class FilterSink<T> implements Sink<T>
{
    private final Sink<T> next;

    private final Predicate<T> condition;

    public FilterSink(Sink<T> next, Predicate<T> condition)
    {
        this.next = next;
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
