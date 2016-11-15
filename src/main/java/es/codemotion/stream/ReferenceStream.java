package es.codemotion.stream;

import java.util.Comparator;
import java.util.Optional;
import java.util.function.*;

import static es.codemotion.stream.Comparators.naturalOrder;
import static java.util.function.BinaryOperator.maxBy;
import static java.util.function.BinaryOperator.minBy;

abstract class ReferenceStream<P, T> extends AbstractStream<P, T>
{
    protected ReferenceStream(AbstractStream<?, P> previous)
    {
        super(previous);
    }

    @Override
    public final Stream<T> filter(Predicate<T> condition)
    {
        return new FilterStream<>(this, condition);
    }

    @Override
    public final <R> Stream<R> map(Function<T, R> mapper)
    {
        return new MapStream<>(this, mapper);
    }

    @Override
    public final Stream<T> distinct()
    {
        return new DistinctStream<>(this);
    }

    @Override
    public final long count()
    {
        return evaluate(new CountSink<>());
    }

    @Override
    public final Object[] toArray()
    {
        return toArray(size -> new Object[size]);
    }

    @Override
    public final <A> A[] toArray(IntFunction<A[]> generator)
    {
        return evaluate(new ToArraySink<>(generator));
    }

    @Override
    public final <R> Stream<R> flatMap(Function<T, Stream<R>> mapper)
    {
        return new FlatMapStream<>(this, mapper);
    }

    @Override
    public final Stream<T> limit(long maxSize)
    {
        return new LimitStream<>(this, maxSize);
    }

    @Override
    public final Stream<T> skip(long n)
    {
        return new SkipStream<>(this, n);
    }

    @Override
    public final Stream<T> peek(Consumer<T> action)
    {
        return new PeekStream<>(this, action);
    }

    @Override
    public final Stream<T> sorted()
    {
        return sorted(naturalOrder());
    }

    @Override
    public final Stream<T> sorted(Comparator<T> comparator)
    {
        return new SortedStream<>(this, comparator);
    }

    @Override
    public final Optional<T> min(Comparator<T> comparator)
    {
        return reduce(minBy(comparator));
    }

    @Override
    public final Optional<T> max(Comparator<T> comparator)
    {
        return reduce(maxBy(comparator));
    }

    @Override
    public final boolean anyMatch(Predicate<T> condition)
    {
        return evaluate(new AnyMatchSink<>(condition));
    }

    @Override
    public final boolean allMatch(Predicate<T> condition)
    {
        return evaluate(new AllMatchSink<>(condition));
    }

    @Override
    public final boolean noneMatch(Predicate<T> condition)
    {
        return allMatch(condition.negate());
    }

    @Override
    public final Optional<T> findFirst()
    {
        return evaluate(new FindSink<>());
    }

    @Override
    public final Optional<T> findAny()
    {
        return findFirst();
    }

    @Override
    public final void forEach(Consumer<T> action)
    {
        evaluate(new ForEachSink<>(action));
    }

    @Override
    public final T reduce(T identity, BinaryOperator<T> accumulator)
    {
        return evaluate(new ReduceSink<>(identity, accumulator)).get();
    }

    @Override
    public final Optional<T> reduce(BinaryOperator<T> accumulator)
    {
        return evaluate(new ReduceSink<>(accumulator));
    }

    @Override
    public final <R, A> R collect(Collector<T, A, R> collector)
    {
        return evaluate(new CollectSink<>(collector));
    }
}
