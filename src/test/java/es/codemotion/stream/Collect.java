package es.codemotion.stream;

import org.junit.Test;

import java.util.List;

import static es.codemotion.stream.Collectors.toList;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class Collect
{
    @Test
    public void none()
    {
        List<Integer> result = Stream.of(noNumbers())
            .collect(toList());

        assertThat(result, is(empty()));
    }

    @Test
    public void all()
    {
        List<Integer> result = Stream.of(2, 3, 2, 1)
            .collect(toList());

        assertThat(result, contains(2, 3, 2, 1));
    }

    private static Integer[] noNumbers()
    {
        return new Integer[0];
    }
}
