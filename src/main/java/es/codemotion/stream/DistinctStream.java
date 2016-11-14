package es.codemotion.stream;

final class DistinctStream<T> extends ReferenceStream<T, T>
{
    public DistinctStream(AbstractStream<?, T> previous)
    {
        super(previous);
    }

    @Override
    protected Sink<T> wrapSink(Sink<T> sink)
    {
        return new DistinctSink<>(sink);
    }
}
