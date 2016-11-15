package es.codemotion.stream;

import java.util.function.Function;

final class FlatMapStream<P, T> extends ReferenceStream<P, T>
{
    private final Function<P, Stream<T>> mapper;

    public FlatMapStream(AbstractStream<?, P> previous, Function<P, Stream<T>> mapper)
    {
        super(previous);
        this.mapper = mapper;
    }

    @Override
    protected Sink<P> wrapSink(Sink<T> sink)
    {
        return new FlatMapSink<>(sink, mapper);
    }
}
