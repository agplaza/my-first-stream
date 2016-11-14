package es.codemotion.stream;

import org.junit.Test;

import static org.hamcrest.Matchers.arrayContaining;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class Sorted
{
    @Test
    public void natural()
    {
        Object[] result = Stream.of(2, 3, 2, 1)
            .sorted()
            .toArray();

        assertThat(result, is(arrayContaining(1, 2, 2, 3)));
    }

    @Test
    public void comparator()
    {
        Object[] result = Stream.of(2, 3, 2, 1)
            .sorted((a, b) -> -a.compareTo(b))
            .toArray();

        assertThat(result, is(arrayContaining(3, 2, 2, 1)));
    }
}
