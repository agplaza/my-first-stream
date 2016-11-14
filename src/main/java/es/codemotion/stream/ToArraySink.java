package es.codemotion.stream;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.IntFunction;

final class ToArraySink<T, A> implements TerminalSink<T, A[]>
{
    private final Collection<T> accumulator = new ArrayList<>();

    private final IntFunction<A[]> generator;

    public ToArraySink(IntFunction<A[]> generator)
    {
        this.generator = generator;
    }

    @Override
    public void accept(T element)
    {
        accumulator.add(element);
    }

    @Override
    public A[] getResult()
    {
        A[] array = generator.apply(accumulator.size());
        accumulator.toArray(array);
        return array;
    }
}
