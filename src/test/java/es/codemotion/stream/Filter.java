package es.codemotion.stream;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class Filter
{
    @Test
    public void none()
    {
        Object[] result = Stream.of(2, 3, 2, 1)
            .filter(n -> n > 0)
            .toArray();

        assertThat(result, is(arrayContaining(2, 3, 2, 1)));
    }

    @Test
    public void some()
    {
        Object[] result = Stream.of(2, 3, 2, 1)
            .filter(n -> n < 3)
            .toArray();

        assertThat(result, is(arrayContaining(2, 2, 1)));
    }

    @Test
    public void all()
    {
        Object[] result = Stream.of(2, 3, 2, 1)
            .filter(n -> n > 3)
            .toArray();

        assertThat(result, is(emptyArray()));
    }
}
