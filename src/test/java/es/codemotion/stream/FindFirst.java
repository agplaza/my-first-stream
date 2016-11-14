package es.codemotion.stream;

import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class FindFirst
{
    @Test
    public void none()
    {
        Optional<Integer> result = Stream.of(noNumbers()).findFirst();

        assertThat(result, is(Optional.empty()));
    }

    @Test
    public void first()
    {
        Optional<Integer> result = Stream.of(2, 3, 2, 1).findFirst();

        assertThat(result, is(Optional.of(2)));
    }

    private static Integer[] noNumbers()
    {
        return new Integer[0];
    }
}
