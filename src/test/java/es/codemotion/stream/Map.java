package es.codemotion.stream;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class Map
{
    @Test
    public void none()
    {
        Object[] result = Stream.of(noNumbers())
            .map(n -> n.toString())
            .toArray();

        assertThat(result, is(emptyArray()));
    }

    @Test
    public void all()
    {
        Object[] result = Stream.of(2, 3, 2, 1)
            .map(n -> n.toString())
            .toArray();

        assertThat(result, is(arrayContaining("2", "3", "2", "1")));
    }

    private static Integer[] noNumbers()
    {
        return new Integer[0];
    }
}
