package es.codemotion.stream;

final class CollectSink<T, A, R> implements TerminalSink<T, R>
{
    private final Collector<T, A, R> collector;

    private A accumulator;

    private R result;

    public CollectSink(Collector<T, A, R> collector)
    {
        this.collector = collector;
        this.accumulator = collector.createAccumulator();
    }

    @Override
    public void accept(T element)
    {
        collector.accumulate(accumulator, element);
    }

    @Override
    public void end()
    {
        result = collector.finish(accumulator);
    }

    @Override
    public R getResult()
    {
        return result;
    }
}
