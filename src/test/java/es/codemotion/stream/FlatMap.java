package es.codemotion.stream;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class FlatMap
{
    @Test
    public void none()
    {
        Object[] result = Stream.of(2, 3, 2, 1)
            .flatMap(n -> Stream.of())
            .toArray();

        assertThat(result, is(emptyArray()));
    }

    @Test
    public void one()
    {
        Object[] result = Stream.of(2, 3, 2, 1)
            .flatMap(n -> Stream.of(n))
            .toArray();

        assertThat(result, is(arrayContaining(2, 3, 2, 1)));
    }

    @Test
    public void multiple()
    {
        Object[] result = Stream.of(2, 3, 2, 1)
            .flatMap(n -> Stream.of(n, n))
            .toArray();

        assertThat(result, is(arrayContaining(2, 2, 3, 3, 2, 2, 1, 1)));
    }
}
