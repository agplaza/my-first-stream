package es.codemotion.stream;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Optional;
import java.util.function.*;

import static java.util.Arrays.asList;

public interface Stream<T> extends AutoCloseable
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

    <A> A[] toArray(IntFunction<A[]> generator);

    <R> Stream<R> flatMap(Function<T, Stream<R>> mapper);

    Stream<T> limit(long maxSize);

    Stream<T> skip(long n);

    Stream<T> peek(Consumer<T> action);

    Stream<T> sorted();

    Stream<T> sorted(Comparator<T> comparator);

    Optional<T> min(Comparator<T> comparator);

    Optional<T> max(Comparator<T> comparator);

    boolean anyMatch(Predicate<T> condition);

    boolean allMatch(Predicate<T> condition);

    boolean noneMatch(Predicate<T> condition);

    Optional<T> findFirst();

    Optional<T> findAny();

    void forEach(Consumer<T> action);

    T reduce(T identity, BinaryOperator<T> accumulator);

    Optional<T> reduce(BinaryOperator<T> accumulator);

    <R, A> R collect(Collector<T, A, R> collector);

    Stream<T> onClose(Runnable closeHandler);

    @Override void close();

    Iterator<T> iterator();

    Spliterator<T> spliterator();
}
