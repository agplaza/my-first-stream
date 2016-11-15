package es.codemotion.stream;

import java.util.Comparator;

final class SortedStream<T> extends ReferenceStream<T, T>
{
    private final Comparator<T> comparator;

    public SortedStream(AbstractStream<?, T> previous, Comparator<T> comparator)
    {
        super(previous);
        this.comparator = comparator;
    }

    @Override
    protected Sink<T> wrapSink(Sink<T> sink)
    {
        return new SortedSink<>(sink, comparator);
    }
}
