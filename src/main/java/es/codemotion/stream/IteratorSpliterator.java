package es.codemotion.stream;

import java.util.Iterator;
import java.util.function.Consumer;

final class IteratorSpliterator<T> implements Spliterator<T>
{
    private final Iterator<T> iterator;

    public IteratorSpliterator(Iterator<T> iterator)
    {
        this.iterator = iterator;
    }

    @Override
    public boolean tryAdvance(Consumer<T> action)
    {
        boolean hasElement = iterator.hasNext();

        if (hasElement)
        {
            T element = iterator.next();
            action.accept(element);
        }

        return hasElement;
    }
}
