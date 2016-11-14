package es.codemotion.stream;

import org.junit.Test;

import static org.hamcrest.Matchers.arrayContaining;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class Distinct
{
    @Test
    public void none()
    {
        Object[] result = Stream.of(2, 3, 2, 1, 3, 2)
            .distinct()
            .toArray();

        assertThat(result, is(arrayContaining(2, 3, 1)));
    }

    @Test
    public void some()
    {
        Object[] result = Stream.of(2, 3, 2, 1)
            .distinct()
            .toArray();

        assertThat(result, is(arrayContaining(2, 3, 1)));
    }

    @Test
    public void all()
    {
        Object[] result = Stream.of(2, 3, 1)
            .distinct()
            .toArray();

        assertThat(result, is(arrayContaining(2, 3, 1)));
    }
}
