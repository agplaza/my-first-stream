package es.codemotion.stream;

final class NullRunnable implements Runnable
{
    public static final Runnable INSTANCE = new NullRunnable();

    private NullRunnable()
    {
        // prevents external instantiation
    }

    @Override
    public void run()
    {
        // do nothing
    }
}
