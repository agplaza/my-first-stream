package es.codemotion.stream;

import java.util.Optional;
import java.util.function.BinaryOperator;

final class ReduceSink<T> implements TerminalSink<T, Optional<T>>
{
    private final BinaryOperator<T> accumulator;

    private boolean hasResult;

    private T result;

    public ReduceSink(BinaryOperator<T> accumulator)
    {
        this.accumulator = accumulator;
    }

    public ReduceSink(T identity, BinaryOperator<T> accumulator)
    {
        this(accumulator);
        this.hasResult = true;
        this.result = identity;
    }

    @Override
    public void accept(T element)
    {
        if (hasResult)
        {
            result = accumulator.apply(result, element);
        }
        else
        {
            result = element;
            hasResult = true;
        }
    }

    @Override
    public Optional<T> getResult()
    {
        if (hasResult)
        {
            return Optional.of(result);
        }

        return Optional.empty();
    }
}
