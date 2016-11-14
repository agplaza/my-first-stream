package es.codemotion.stream;

abstract class AbstractStream<P, T> implements Stream<T>
{
    protected SourceStream<?> source;

    private AbstractStream<?, P> previous;

    protected AbstractStream(AbstractStream<?, P> previous)
    {
        if (previous != null)
        {
            this.previous = previous;
            this.source = previous.source;
        }
    }

    protected final <S, R> R evaluate(TerminalSink<T, R> sink)
    {
        Spliterator<S> spliterator = Unchecked.cast(source.spliterator);
        Sink<S> wrappedSink = buildWrappedSink(sink);

        do
        {
            // nothing
        }
        while (spliterator.tryAdvance(wrappedSink));

        return sink.getResult();
    }

    final <S> Sink<S> buildWrappedSink(Sink<T> sink)
    {
        AbstractStream<?, ?> stream = this;
        Sink<?> wrappedSink = sink;

        while (stream != source)
        {
            wrappedSink = stream.wrapSink(Unchecked.cast(wrappedSink));
            stream = stream.previous;
        }

        return Unchecked.cast(wrappedSink);
    }

    protected abstract Sink<P> wrapSink(Sink<T> sink);
}
