package es.codemotion.stream;

import java.util.HashSet;
import java.util.Set;

final class DistinctSink<T> implements Sink<T>
{
    private final Sink<T> next;

    private final Set<T> seen = new HashSet<>();

    public DistinctSink(Sink<T> next)
    {
        this.next = next;
    }

    @Override
    public void accept(T element)
    {
        if (!seen.contains(element))
        {
            seen.add(element);
            next.accept(element);
        }
    }
}
