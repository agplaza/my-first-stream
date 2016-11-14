package es.codemotion.stream;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class Skip
{
    @Test
    public void some()
    {
        Object[] result = Stream.of(2, 3, 2, 1)
            .skip(2)
            .toArray();

        assertThat(result, is(arrayContaining(2, 1)));
    }

    @Test
    public void none()
    {
        Object[] result = Stream.of(2, 3, 2, 1)
            .skip(0)
            .toArray();

        assertThat(result, is(arrayContaining(2, 3, 2, 1)));
    }

    @Test
    public void all()
    {
        Object[] result = Stream.of(2, 3, 2, 1)
            .skip(4)
            .toArray();

        assertThat(result, is(emptyArray()));
    }

    @Test
    public void more()
    {
        Object[] result = Stream.of(2, 3, 2, 1)
            .skip(5)
            .toArray();

        assertThat(result, is(emptyArray()));
    }
}
