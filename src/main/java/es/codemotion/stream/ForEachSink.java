package es.codemotion.stream;

import java.util.function.Consumer;

final class ForEachSink<T> implements TerminalSink<T, Void>
{
    private final Consumer<T> action;

    public ForEachSink(Consumer<T> action)
    {
        this.action = action;
    }

    @Override
    public void accept(T element)
    {
        action.accept(element);
    }
}
