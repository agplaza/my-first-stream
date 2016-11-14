package es.codemotion.stream;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class Close
{
    @Test
    public void none()
    {
        Stream.of(2, 3, 2, 1).close();
    }

    @Test
    public void single()
    {
        AtomicBoolean closed = new AtomicBoolean();

        Stream.of(2, 3, 2, 1)
            .onClose(() -> closed.set(true))
            .close();

        assertThat(closed.get(), is(true));
    }

    @Test
    public void multiple()
    {
        AtomicInteger i = new AtomicInteger();
        AtomicInteger first = new AtomicInteger();
        AtomicInteger second = new AtomicInteger();

        Stream.of(2, 3, 2, 1)
            .onClose(() -> first.set(i.incrementAndGet()))
            .onClose(() -> second.set(i.incrementAndGet()))
            .close();

        assertThat(first.get(), is(1));
        assertThat(second.get(), is(2));
    }
}
