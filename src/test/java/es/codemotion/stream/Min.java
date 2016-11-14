package es.codemotion.stream;

import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class Min
{
    @Test
    public void empty()
    {
        Optional<Integer> result = Stream.of(noNumbers())
            .min((a, b) -> a.compareTo(b));

        assertThat(result, is(Optional.empty()));
    }

    @Test
    public void nonEmpty()
    {
        Optional<Integer> result = Stream.of(2, 3, 2, 1)
            .min((a, b) -> a.compareTo(b));

        assertThat(result, is(Optional.of(1)));
    }

    private static Integer[] noNumbers()
    {
        return new Integer[0];
    }
}
