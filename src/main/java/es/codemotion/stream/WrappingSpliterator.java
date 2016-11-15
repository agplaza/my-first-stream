package es.codemotion.stream;

import java.util.function.Consumer;

final class WrappingSpliterator<S, T> implements Spliterator<T>
{
    private final AbstractStream<?, T> pipeline;

    private final Spliterator<S> spliterator;

    private BufferSink<T> bufferSink;

    private Sink<S> wrappedSink;

    private boolean finished;

    public WrappingSpliterator(AbstractStream<?, T> pipeline, Spliterator<S> spliterator)
    {
        this.pipeline = pipeline;
        this.spliterator = spliterator;
    }

    @Override
    public boolean tryAdvance(Consumer<T> action)
    {
        boolean advanced = advance();

        if (advanced)
        {
            bufferSink.consumeNext(action);
        }

        return advanced;
    }

    private boolean advance()
    {
        boolean advanced = true;
        Sink<S> wrappedSink = wrappedSink();

        while (bufferSink.count() == 0 && advanced)
        {
            advanced = !wrappedSink.cancellationRequested() && spliterator.tryAdvance(wrappedSink);

            if (!advanced && !finished)
            {
                wrappedSink.end();
                finished = true;
            }
        }

        return bufferSink.count() > 0;
    }

    private Sink<S> wrappedSink()
    {
        if (wrappedSink == null)
        {
            bufferSink = new BufferSink<>();
            wrappedSink = pipeline.buildWrappedSink(bufferSink);
        }

        return wrappedSink;
    }
}
