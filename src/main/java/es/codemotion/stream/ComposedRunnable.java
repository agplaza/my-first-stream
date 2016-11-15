package es.codemotion.stream;

final class ComposedRunnable implements Runnable
{
    protected final Runnable first;

    protected final Runnable second;

    public ComposedRunnable(Runnable first, Runnable second)
    {
        this.first = first;
        this.second = second;
    }

    @Override
    public void run()
    {
        first.run();
        second.run();
    }
}
