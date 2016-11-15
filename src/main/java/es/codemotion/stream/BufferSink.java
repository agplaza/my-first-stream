package es.codemotion.stream;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.function.Consumer;

final class BufferSink<T> implements Sink<T>
{
    private final Deque<T> elements = new ArrayDeque<>();

    @Override
    public void accept(T element)
    {
        elements.add(element);
    }

    public int count()
    {
        return elements.size();
    }

    public void consumeNext(Consumer<T> action)
    {
        T element = elements.remove();
        action.accept(element);
    }
}
