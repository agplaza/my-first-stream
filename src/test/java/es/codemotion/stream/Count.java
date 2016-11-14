package es.codemotion.stream;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class Count
{
    @Test
    public void none()
    {
        long result = Stream.of().count();

        assertThat(result, is(0L));
    }

    @Test
    public void some()
    {
        long result = Stream.of(2, 3, 2, 1).count();

        assertThat(result, is(4L));
    }
}
