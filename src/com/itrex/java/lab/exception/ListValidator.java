package com.itrex.java.lab.exception;

import java.util.List;

public class ListValidator {

    public void validate(List<Integer> randomList) throws ValidationException {
//        check the list for even numbers, if there is an even number in the list, throw an exception
        for (int i = 0; i < randomList.size(); i++) {
            if (randomList.get(i) % 2 == 0) {
                throw new ValidationException(randomList.get(i), "list contain even number!");
            }
        }
    }

}
