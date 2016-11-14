package es.codemotion.stream;

import java.util.Comparator;
import java.util.Optional;
import java.util.function.*;

abstract class ReferenceStream<P, T> extends AbstractStream<P, T>
{
    protected ReferenceStream(AbstractStream<?, P> previous)
    {
        super(previous);
    }

    @Override
    public final Stream<T> filter(Predicate<T> condition)
    {
        throw new UnsupportedOperationException("Not implemented!");
    }

    @Override
    public final <R> Stream<R> map(Function<T, R> mapper)
    {
        throw new UnsupportedOperationException("Not implemented!");
    }

    @Override
    public final Stream<T> distinct()
    {
        throw new UnsupportedOperationException("Not implemented!");
    }

    @Override
    public final long count()
    {
        return evaluate(new CountSink<>());
    }

    @Override
    public final Object[] toArray()
    {
        throw new UnsupportedOperationException("Not implemented!");
    }

    @Override
    public final <A> A[] toArray(IntFunction<A[]> generator)
    {
        throw new UnsupportedOperationException("Not implemented!");
    }

    @Override
    public final <R> Stream<R> flatMap(Function<T, Stream<R>> mapper)
    {
        throw new UnsupportedOperationException("Not implemented!");
    }

    @Override
    public final Stream<T> limit(long maxSize)
    {
        throw new UnsupportedOperationException("Not implemented!");
    }

    @Override
    public final Stream<T> skip(long n)
    {
        throw new UnsupportedOperationException("Not implemented!");
    }

    @Override
    public final Stream<T> peek(Consumer<T> action)
    {
        throw new UnsupportedOperationException("Not implemented!");
    }

    @Override
    public final Stream<T> sorted()
    {
        throw new UnsupportedOperationException("Not implemented!");
    }

    @Override
    public final Stream<T> sorted(Comparator<T> comparator)
    {
        throw new UnsupportedOperationException("Not implemented!");
    }

    @Override
    public final Optional<T> min(Comparator<T> comparator)
    {
        throw new UnsupportedOperationException("Not implemented!");
    }

    @Override
    public final Optional<T> max(Comparator<T> comparator)
    {
        throw new UnsupportedOperationException("Not implemented!");
    }

    @Override
    public final boolean anyMatch(Predicate<T> condition)
    {
        throw new UnsupportedOperationException("Not implemented!");
    }

    @Override
    public final boolean allMatch(Predicate<T> condition)
    {
        throw new UnsupportedOperationException("Not implemented!");
    }

    @Override
    public final boolean noneMatch(Predicate<T> condition)
    {
        throw new UnsupportedOperationException("Not implemented!");
    }

    @Override
    public final Optional<T> findFirst()
    {
        throw new UnsupportedOperationException("Not implemented!");
    }

    @Override
    public final Optional<T> findAny()
    {
        throw new UnsupportedOperationException("Not implemented!");
    }

    @Override
    public final void forEach(Consumer<T> action)
    {
        throw new UnsupportedOperationException("Not implemented!");
    }

    @Override
    public final T reduce(T identity, BinaryOperator<T> accumulator)
    {
        throw new UnsupportedOperationException("Not implemented!");
    }

    @Override
    public final Optional<T> reduce(BinaryOperator<T> accumulator)
    {
        throw new UnsupportedOperationException("Not implemented!");
    }

    @Override
    public final <R, A> R collect(Collector<T, A, R> collector)
    {
        throw new UnsupportedOperationException("Not implemented!");
    }
}
