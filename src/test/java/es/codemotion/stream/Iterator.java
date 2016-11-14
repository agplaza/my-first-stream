package es.codemotion.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class Iterator
{
    @Test
    public void none()
    {
        Collection<Integer> iterated = new ArrayList<>();

        Stream.of(noNumbers()).iterator().forEachRemaining(n -> iterated.add(n));

        assertThat(iterated, is(empty()));
    }

    @Test
    public void all()
    {
        Collection<Integer> iterated = new ArrayList<>();

        Stream.of(2, 3, 2, 1).iterator().forEachRemaining(n -> iterated.add(n));

        assertThat(iterated, contains(2, 3, 2, 1));
    }

    @Test
    public void advanced()
    {
        Collection<Integer> peeked = new ArrayList<>();
        Collection<String> iterated = new ArrayList<>();

        Stream<String> stream = Stream.of(0, -1, 2, 3, 2, 1, -3, -2)
            .skip(2)
            .filter(n -> n < 3)
            .peek(n -> peeked.add(n))
            .map(n -> n.toString())
            .distinct()
            .flatMap(s -> Stream.of(s, s))
            .sorted()
            .limit(3);

        stream.iterator().forEachRemaining(s -> iterated.add(s));

        assertThat(peeked, contains(2, 2, 1, -3, -2));
        assertThat(iterated, contains("-2", "-2", "-3"));
    }

    private static Integer[] noNumbers()
    {
        return new Integer[0];
    }
}
