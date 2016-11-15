package es.codemotion.stream;

final class SkipSink<T> extends ChainedSink<T, T>
{
    private long elementsToSkip;

    public SkipSink(Sink<T> next, long elementsToSkip)
    {
        super(next);
        this.elementsToSkip = elementsToSkip;
    }

    @Override
    public void accept(T element)
    {
        if (elementsToSkip == 0)
        {
            next.accept(element);
        }
        else
        {
            elementsToSkip--;
        }
    }
}
