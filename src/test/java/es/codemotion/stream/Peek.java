package es.codemotion.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class Peek
{
    @Test
    public void nothing()
    {
        Collection<Integer> peeked = new ArrayList<>();

        Stream.of(2, 3, 2, 1).peek(n -> peeked.add(n));

        assertThat(peeked, is(empty()));
    }

    @Test
    public void none()
    {
        Collection<Integer> peeked = new ArrayList<>();

        Stream.of(noNumbers())
            .peek(n -> peeked.add(n))
            .count();

        assertThat(peeked, is(empty()));
    }

    @Test
    public void all()
    {
        Collection<Integer> peeked = new ArrayList<>();

        Stream.of(2, 3, 2, 1)
            .peek(n -> peeked.add(n))
            .count();

        assertThat(peeked, contains(2, 3, 2, 1));
    }

    private static Integer[] noNumbers()
    {
        return new Integer[0];
    }
}
