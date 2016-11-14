package es.codemotion.stream;

import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class Reduce
{
    @Test
    public void none()
    {
        Optional<Integer> result = Stream.of(noNumbers())
            .reduce((a, b) -> a + b);

        assertThat(result, is(Optional.empty()));
    }

    @Test
    public void all()
    {
        Optional<Integer> result = Stream.of(2, 3, 2, 1)
            .reduce((a, b) -> a + b);

        assertThat(result, is(Optional.of(8)));
    }

    @Test
    public void noneSeeded()
    {
        int result = Stream.of(noNumbers())
            .reduce(10, (a, b) -> a + b);

        assertThat(result, is(10));
    }

    @Test
    public void allSeeded()
    {
        int result = Stream.of(2, 3, 2, 1)
            .reduce(10, (a, b) -> a + b);

        assertThat(result, is(18));
    }

    private static Integer[] noNumbers()
    {
        return new Integer[0];
    }
}
