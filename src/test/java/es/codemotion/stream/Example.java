package es.codemotion.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class Example
{
    @Test
    public void simple()
    {
        Object[] result = Stream.of(2, 3, 2, 1)
            .filter(n -> n < 3)
            .map(n -> n.toString())
            .distinct()
            .toArray();

        assertThat(result, is(arrayContaining("2", "1")));
    }

    @Test
    public void advanced()
    {
        AtomicBoolean firstClosed = new AtomicBoolean();
        AtomicBoolean secondClosed = new AtomicBoolean();

        Collection<Integer> peeked = new ArrayList<>();

        try (Stream<String> stream = Stream.of(0, -1, 2, 3, 2, 1, -3, -2)
            .skip(2)
            .filter(n -> n < 3)
            .onClose(() -> firstClosed.set(true))
            .peek(n -> peeked.add(n))
            .map(n -> n.toString())
            .distinct()
            .flatMap(s -> Stream.of(s, s))
            .sorted()
            .onClose(() -> secondClosed.set(true))
            .limit(3))
        {
            Object[] result = stream.toArray();

            assertThat(peeked, contains(2, 2, 1, -3, -2));
            assertThat(result, is(arrayContaining("-2", "-2", "-3")));
            assertThat(firstClosed.get(), is(false));
            assertThat(secondClosed.get(), is(false));
        }

        assertThat(firstClosed.get(), is(true));
        assertThat(secondClosed.get(), is(true));
    }
}
