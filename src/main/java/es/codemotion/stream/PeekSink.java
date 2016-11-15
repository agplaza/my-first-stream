package es.codemotion.stream;

import java.util.function.Consumer;

final class PeekSink<T> extends ChainedSink<T, T>
{
    private final Consumer<T> action;

    public PeekSink(Sink<T> next, Consumer<T> action)
    {
        super(next);
        this.action = action;
    }

    @Override
    public void accept(T element)
    {
        action.accept(element);
        next.accept(element);
    }
}
