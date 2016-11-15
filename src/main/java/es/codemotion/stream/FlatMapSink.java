package es.codemotion.stream;

import java.util.function.Function;

final class FlatMapSink<T, N> extends ChainedSink<T, N>
{
    private final Function<T, Stream<N>> mapper;

    public FlatMapSink(Sink<N> next, Function<T, Stream<N>> mapper)
    {
        super(next);
        this.mapper = mapper;
    }

    @Override
    public void accept(T element)
    {
        try (Stream<N> mappedElements = mapper.apply(element))
        {
            if (mappedElements != null)
            {
                mappedElements.forEach(next);
            }
        }
    }
}
