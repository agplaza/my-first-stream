package es.codemotion.stream;

import java.util.function.Consumer;

interface Sink<T> extends Consumer<T>
{
    default boolean cancellationRequested()
    {
        return false;
    }

    default void end()
    {
        // do nothing
    }
}
