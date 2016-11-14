package es.codemotion.stream;

public interface Collector<T, A, R>
{
    A createAccumulator();

    void accumulate(A accumulator, T element);

    R finish(A accumulator);
}
