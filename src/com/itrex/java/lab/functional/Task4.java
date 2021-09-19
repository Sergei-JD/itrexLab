package com.itrex.java.lab.functional;

import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.reducing;

/**
 * Write a collector that evaluates the product of squares of integer numbers in a Stream<Integer>.
 * <p>
 * Important. You should write only the collector in any valid formats but without ; on the end.
 * It will be passed as an argument to the collect() method of a stream as shown below.
 */
public class Task4 {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(0, 1, 2, 3);
        long val = numbers
                .stream()
                .collect(reducing(1, (n, m) -> n * m * m));

//        System.out.println(val);
    }

}
