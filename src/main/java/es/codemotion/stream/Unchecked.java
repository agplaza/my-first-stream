package es.codemotion.stream;

final class Unchecked
{
    private Unchecked()
    {
        // prevents instantiation
    }

    @SuppressWarnings("unchecked")
    public static <T, R> R cast(T value)
    {
        return (R) value;
    }
}
