package es.codemotion.stream;

import java.util.function.Consumer;

public interface Spliterator<T>
{
    boolean tryAdvance(Consumer<T> action);
}
