package es.codemotion.stream;

import java.util.function.Consumer;

interface Sink<T> extends Consumer<T>
{
    // in its simplest version, Sink<T> is just a Consumer<T>
}
