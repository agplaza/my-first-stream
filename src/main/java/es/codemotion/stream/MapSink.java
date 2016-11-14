package es.codemotion.stream;

import java.util.function.Function;

final class MapSink<T, N> extends ChainedSink<T, N>
{
    private final Function<T, N> mapper;

    public MapSink(Sink<N> next, Function<T, N> mapper)
    {
        super(next);
        this.mapper = mapper;
    }

    @Override
    public void accept(T element)
    {
        N mappedElement = mapper.apply(element);
        next.accept(mappedElement);
    }
}
