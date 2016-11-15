package es.codemotion.stream;

final class LimitStream<T> extends ReferenceStream<T, T>
{
    private final long maxSize;

    public LimitStream(AbstractStream<?, T> previous, long maxSize)
    {
        super(previous);
        this.maxSize = maxSize;
    }

    @Override
    protected Sink<T> wrapSink(Sink<T> sink)
    {
        return new LimitSink<>(sink, maxSize);
    }
}
