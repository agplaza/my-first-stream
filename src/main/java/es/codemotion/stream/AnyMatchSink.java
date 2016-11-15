package es.codemotion.stream;

import java.util.function.Predicate;

final class AnyMatchSink<T> extends MatchSink<T>
{
    public AnyMatchSink(Predicate<T> condition)
    {
        super(false, condition);
    }

    @Override
    protected void accumulate(boolean match)
    {
        accumulator = accumulator || match;
        cancellationRequested = accumulator;
    }
}
