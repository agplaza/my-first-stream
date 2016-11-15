package es.codemotion.stream;

import java.util.function.Predicate;

final class AllMatchSink<T> extends MatchSink<T>
{
    public AllMatchSink(Predicate<T> condition)
    {
        super(true, condition);
    }

    @Override
    protected void accumulate(boolean match)
    {
        accumulator = accumulator && match;
        cancellationRequested = !accumulator;
    }
}
