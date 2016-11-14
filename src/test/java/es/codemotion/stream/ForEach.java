package es.codemotion.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class ForEach
{
    @Test
    public void none()
    {
        Collection<Integer> iterated = new ArrayList<>();

        Stream.of(noNumbers()).forEach(n -> iterated.add(n));

        assertThat(iterated, is(empty()));
    }

    @Test
    public void all()
    {
        Collection<Integer> iterated = new ArrayList<>();

        Stream.of(2, 3, 2, 1).forEach(n -> iterated.add(n));

        assertThat(iterated, contains(2, 3, 2, 1));
    }

    private static Integer[] noNumbers()
    {
        return new Integer[0];
    }
}
