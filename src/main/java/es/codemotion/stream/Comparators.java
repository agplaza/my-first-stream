package es.codemotion.stream;

import java.util.Comparator;

final class Comparators
{
    private Comparators()
    {
        // prevents instantiation
    }

    @SuppressWarnings("unchecked")
    public static <T> Comparator<T> naturalOrder()
    {
        return (Comparator<T>) Comparator.naturalOrder();
    }
}
