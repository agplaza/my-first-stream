package es.codemotion.stream;

final class CountSink<T> implements TerminalSink<T, Long>
{
    private long count;

    @Override
    public void accept(T element)
    {
        count++;
    }

    @Override
    public Long getResult()
    {
        return count;
    }
}
