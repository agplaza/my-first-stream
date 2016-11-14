package es.codemotion.stream;

import java.util.function.Function;

final class IntermediateStream<P, T> extends ReferenceStream<P, T>
{
    private final Function<Sink<T>, Sink<P>> wrapper;

    public IntermediateStream(AbstractStream<?, P> previous, Function<Sink<T>, Sink<P>> wrapper)
    {
        super(previous);
        this.wrapper = wrapper;
    }

    @Override
    protected Sink<P> wrapSink(Sink<T> sink)
    {
        return wrapper.apply(sink);
    }
}
