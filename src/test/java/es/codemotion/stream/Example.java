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
}
