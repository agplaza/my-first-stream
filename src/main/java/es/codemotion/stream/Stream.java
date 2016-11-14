package es.codemotion.stream;

import java.util.Iterator;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.Arrays.asList;

public interface Stream<T>
{
    @SafeVarargs
    static <T> Stream<T> of(T... elements)
    {
        Iterator<T> iterator = asList(elements).iterator();
        Spliterator<T> spliterator = new IteratorSpliterator<>(iterator);
        return new SourceStream<>(spliterator);
    }

    Stream<T> filter(Predicate<T> condition);

    <R> Stream<R> map(Function<T, R> mapper);

    Stream<T> distinct();

    long count();

    Object[] toArray();
}
