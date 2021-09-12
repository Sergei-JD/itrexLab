package com.itrex.java.lab.exception;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        ListGenerator listGenerator = new ListGenerator();
        List<Integer> oddList = listGenerator.generateOddList();

    }

}
