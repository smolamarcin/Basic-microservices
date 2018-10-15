package org.springframework.amqp.tutorials.rabbitmqamqptutorials;

import java.util.*;
import java.util.stream.Collectors;

public class Counter {
    public List<Integer> siema(List<Integer> numbers, int sum) {
        Set<Integer> storage = new HashSet<>();
        for (Integer number : numbers) {
            int difference = sum - number;
            if (difference > 0 && !storage.contains(number)){
                storage.add(number);
            }
            if (storage.contains(difference)){
                List<Integer> integers = Arrays.asList(difference, number);
                integers.sort(Comparator.naturalOrder());
                return integers;
            }
        }
        return  null;
    }

    public Map<Boolean, List<String>> coutnWords(List<String> names) {
        return names.stream().collect(Collectors.partitioningBy(e -> e.length() >= 6));
    }
}
