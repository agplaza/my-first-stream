package es.codemotion.stream;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class NoneMatch
{
    @Test
    public void empty()
    {
        boolean result = Stream.of(noNumbers()).noneMatch(n -> n > 0);

        assertThat(result, is(true));
    }

    @Test
    public void none()
    {
        boolean result = Stream.of(2, 3, 2, 1).noneMatch(n -> n > 3);

        assertThat(result, is(true));
    }

    @Test
    public void some()
    {
        boolean result = Stream.of(2, 3, 2, 1).noneMatch(n -> n > 1);

        assertThat(result, is(false));
    }

    @Test
    public void all()
    {
        boolean result = Stream.of(2, 3, 2, 1).noneMatch(n -> n > 0);

        assertThat(result, is(false));
    }

    private static Integer[] noNumbers()
    {
        return new Integer[0];
    }
}
