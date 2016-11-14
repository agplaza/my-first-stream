package es.codemotion.stream;

import java.util.function.Function;

final class MapStream<P, T> extends ReferenceStream<P, T>
{
    private final Function<P, T> mapper;

    public MapStream(AbstractStream<?, P> previous, Function<P, T> mapper)
    {
        super(previous);
        this.mapper = mapper;
    }

    @Override
    protected Sink<P> wrapSink(Sink<T> sink)
    {
        return new MapSink<>(sink, mapper);
    }
}
