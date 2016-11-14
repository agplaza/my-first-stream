package es.codemotion.stream;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class ToArray
{
    @Test
    public void none()
    {
        Object[] result = Stream.of().toArray();

        assertThat(result, is(emptyArray()));
    }

    @Test
    public void all()
    {
        Object[] result = Stream.of(2, 3, 2, 1).toArray();

        assertThat(result, is(arrayContaining(2, 3, 2, 1)));
    }
}
