package es.codemotion.stream;

import java.util.Iterator;

abstract class AbstractStream<P, T> implements Stream<T>
{
    protected SourceStream<?> source;

    private AbstractStream<?, P> previous;

    private boolean used;

    protected AbstractStream(AbstractStream<?, P> previous)
    {
        if (previous != null)
        {
            previous.markUsed();
            this.previous = previous;
            this.source = previous.source;
        }
    }

    protected final <S, R> R evaluate(TerminalSink<T, R> sink)
    {
        Spliterator<S> spliterator = sourceSpliterator();
        Sink<S> wrappedSink = buildWrappedSink(sink);

        do
        {
            // nothing
        }
        while (!wrappedSink.cancellationRequested() && spliterator.tryAdvance(wrappedSink));

        wrappedSink.end();
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

    private <S> Spliterator<S> sourceSpliterator()
    {
        markUsed();
        return Unchecked.cast(source.spliterator);
    }

    private void markUsed()
    {
        if (used)
        {
            throw new IllegalStateException("Stream has already been operated upon or closed");
        }

        used = true;
    }

    @Override
    public final Stream<T> onClose(Runnable closeHandler)
    {
        source.closeHandler = new ComposedRunnable(source.closeHandler, closeHandler);
        return this;
    }

    @Override
    public final void close()
    {
        source.closeHandler.run();
    }

    @Override
    public final Iterator<T> iterator()
    {
        return new SpliteratorIterator<>(spliterator());
    }

    @Override
    public final Spliterator<T> spliterator()
    {
        return new WrappingSpliterator<>(this, sourceSpliterator());
    }
}
