package es.codemotion.stream;

import java.util.ArrayList;
import java.util.List;

final class ListCollector<T> implements Collector<T, List<T>, List<T>>
{
    @Override
    public List<T> createAccumulator()
    {
        return new ArrayList<>();
    }

    @Override
    public void accumulate(List<T> accumulator, T element)
    {
        accumulator.add(element);
    }

    @Override
    public List<T> finish(List<T> accumulator)
    {
        return accumulator;
    }
}
