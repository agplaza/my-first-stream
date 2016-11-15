package es.codemotion.stream;

import java.util.function.Predicate;

abstract class MatchSink<T> implements TerminalSink<T, Boolean>
{
    private final Predicate<T> condition;

    protected boolean cancellationRequested;

    protected boolean accumulator;

    protected MatchSink(boolean seed, Predicate<T> condition)
    {
        this.accumulator = seed;
        this.condition = condition;
    }

    @Override
    public void accept(T element)
    {
        if (!cancellationRequested)
        {
            accumulate(condition.test(element));
        }
    }

    protected abstract void accumulate(boolean match);

    @Override
    public boolean cancellationRequested()
    {
        return cancellationRequested;
    }

    @Override
    public Boolean getResult()
    {
        return accumulator;
    }
}
