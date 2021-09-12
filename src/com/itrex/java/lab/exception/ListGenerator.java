package com.itrex.java.lab.exception;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListGenerator {

    private final Random rand = new Random();
    private final ListValidator validator = new ListValidator();

    private List<Integer> createRandomList(int number) {
//        Using a pseudo-random number generator, we get a list of 3 elements from 1 to 9.
        List<Integer> randomList = new ArrayList<>();

        for (int i = 0; i < number; i++) {
            randomList.add(rand.nextInt(9) + 1);
        }
        System.out.println("Генератор попытался сосздать список нечетных элементов: ");

        return randomList;
    }

    public List<Integer> generateOddList() {
//        method for getting a list of odd numbers and exception handling
        List<Integer> randomList = createRandomList(3);
        try {
            validator.validate(randomList);
            System.out.println(randomList.toString() + " и все элементы нечетные!");
        }catch (ValidationException e) {
            System.out.println(randomList.toString() + ", но в списке есть четное число: " + e.getNumEven() + "!\n" + "log: " + e.getClass().getName() + "\n");
            randomList = generateOddList();
        }

        return randomList;
    }

}
