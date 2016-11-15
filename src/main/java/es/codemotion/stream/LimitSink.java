package es.codemotion.stream;

final class LimitSink<T> extends ChainedSink<T, T>
{
    private long elementsToLimit;

    public LimitSink(Sink<T> next, long elementsToLimit)
    {
        super(next);
        this.elementsToLimit = elementsToLimit;
    }

    @Override
    public void accept(T element)
    {
        if (elementsToLimit > 0)
        {
            elementsToLimit--;
            next.accept(element);
        }
    }

    @Override
    public boolean cancellationRequested()
    {
        return elementsToLimit == 0 || next.cancellationRequested();
    }
}
