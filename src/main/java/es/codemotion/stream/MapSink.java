package es.codemotion.stream;

import java.util.function.Function;

final class MapSink<T, N> implements Sink<T>
{
    private final Sink<N> next;

    private final Function<T, N> mapper;

    public MapSink(Sink<N> next, Function<T, N> mapper)
    {
        this.next = next;
        this.mapper = mapper;
    }

    @Override
    public void accept(T element)
    {
        N mappedElement = mapper.apply(element);
        next.accept(mappedElement);
    }
}
