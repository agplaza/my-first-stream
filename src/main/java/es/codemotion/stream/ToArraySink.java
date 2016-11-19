package es.codemotion.stream;

import java.util.ArrayList;
import java.util.Collection;

final class ToArraySink<T> implements TerminalSink<T, Object[]>
{
    private final Collection<T> accumulator = new ArrayList<>();

    @Override
    public void accept(T element)
    {
        accumulator.add(element);
    }

    @Override
    public Object[] getResult()
    {
        return accumulator.toArray();
    }
}
