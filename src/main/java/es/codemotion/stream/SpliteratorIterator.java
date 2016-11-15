package es.codemotion.stream;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

final class SpliteratorIterator<T> implements Iterator<T>, Consumer<T>
{
    private final Spliterator<T> spliterator;

    private boolean nextRead;

    private T next;

    public SpliteratorIterator(Spliterator<T> spliterator)
    {
        this.spliterator = spliterator;
    }

    @Override
    public void accept(T element)
    {
        nextRead = true;
        next = element;
    }

    @Override
    public boolean hasNext()
    {
        if (!nextRead)
        {
            spliterator.tryAdvance(this);
        }

        return nextRead;
    }

    @Override
    public T next()
    {
        if (!hasNext())
        {
            throw new NoSuchElementException();
        }

        nextRead = false;
        return next;
    }
}
