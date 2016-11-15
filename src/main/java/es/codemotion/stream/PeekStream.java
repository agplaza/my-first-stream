package es.codemotion.stream;

import java.util.function.Consumer;

final class PeekStream<T> extends ReferenceStream<T, T>
{
    private final Consumer<T> action;

    public PeekStream(AbstractStream<?, T> previous, Consumer<T> action)
    {
        super(previous);
        this.action = action;
    }

    @Override
    protected Sink<T> wrapSink(Sink<T> sink)
    {
        return new PeekSink<>(sink, action);
    }
}
