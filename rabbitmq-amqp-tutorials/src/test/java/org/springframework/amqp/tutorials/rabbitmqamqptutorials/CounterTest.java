package org.springframework.amqp.tutorials.rabbitmqamqptutorials;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class CounterTest {
    private Counter counter = new Counter();

    @Test
    public void shouldCheck_IsNameLengthIsGreaterOrEqual_ThanSix() {
        List<String> names = Arrays.asList("Marcin", "Marcin", "A", "BB", "CCCCC");

        Map<Boolean, List<String>> sortedByNameLengthMap = counter.coutnWords(names);
        assertEquals(2, sortedByNameLengthMap.size());
        assertEquals(2, sortedByNameLengthMap.get(true).size());
        assertEquals(3, sortedByNameLengthMap.get(false).size());
    }

    @Test
    public void shouldReturnTwoNumbers_equalsToSum() {
        List<Integer> numbers = Arrays.asList(10, 5, -1, 0 ,1, 3, 5);
        List<Integer> actual = counter.siema(numbers, 15);
        assertEquals(Arrays.asList(5, 10), actual);
    }
}