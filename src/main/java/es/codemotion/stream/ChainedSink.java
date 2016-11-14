package es.codemotion.stream;

abstract class ChainedSink<T, N> implements Sink<T>
{
    protected final Sink<N> next;

    protected ChainedSink(Sink<N> next)
    {
        this.next = next;
    }

    @Override
    public boolean cancellationRequested()
    {
        return next.cancellationRequested();
    }

    @Override
    public void end()
    {
        next.end();
    }
}
