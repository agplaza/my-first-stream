package es.codemotion.stream;

final class SourceStream<T> extends ReferenceStream<Void, T>
{
    final Spliterator<?> spliterator;

    public SourceStream(Spliterator<T> spliterator)
    {
        super(null);
        this.source = this;
        this.spliterator = spliterator;
    }

    @Override
    protected Sink<Void> wrapSink(Sink<T> sink)
    {
        throw new IllegalStateException("Source streams don't create sinks!");
    }
}
