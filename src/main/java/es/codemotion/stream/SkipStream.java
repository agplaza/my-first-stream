package es.codemotion.stream;

final class SkipStream<T> extends ReferenceStream<T, T>
{
    private final long elementsToSkip;

    public SkipStream(AbstractStream<?, T> previous, long elementsToSkip)
    {
        super(previous);
        this.elementsToSkip = elementsToSkip;
    }

    @Override
    protected Sink<T> wrapSink(Sink<T> sink)
    {
        return new SkipSink<>(sink, elementsToSkip);
    }
}
