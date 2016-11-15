package es.codemotion.stream;

import java.util.Optional;

final class FindSink<T> implements TerminalSink<T, Optional<T>>
{
    private boolean hasValue;

    private T value;

    @Override
    public void accept(T element)
    {
        if (!hasValue)
        {
            hasValue = true;
            value = element;
        }
    }

    @Override
    public boolean cancellationRequested()
    {
        return hasValue;
    }

    @Override
    public Optional<T> getResult()
    {
        if (hasValue)
        {
            return Optional.of(value);
        }

        return Optional.empty();
    }
}
