package es.codemotion.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

final class SortedSink<T> extends ChainedSink<T, T>
{
    private final Comparator<T> comparator;

    private final List<T> elements = new ArrayList<>();

    public SortedSink(Sink<T> next, Comparator<T> comparator)
    {
        super(next);
        this.comparator = comparator;
    }

    @Override
    public void accept(T element)
    {
        elements.add(element);
    }

    @Override
    public void end()
    {
        elements.sort(comparator);

        for (T element : elements)
        {
            if (next.cancellationRequested())
            {
                break;
            }

            next.accept(element);
        }

        next.end();
    }
}
