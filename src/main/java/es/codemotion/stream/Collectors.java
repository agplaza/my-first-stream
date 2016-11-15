package es.codemotion.stream;

import java.util.List;

public final class Collectors
{
    private Collectors()
    {
        // prevents instantiation
    }

    public static <T> Collector<T, List<T>, List<T>> toList()
    {
        return new ListCollector<>();
    }
}
