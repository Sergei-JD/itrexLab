package com.itrex.java.lab.jmm;

import java.io.IOException;

public class MetaspaceQuiz0 {

    public static void main(String[] args) throws IOException {

        Class<?> clazz = MetaspaceQuiz0.class;
        byte[] buffer = ClassLoaderUtil.loadByteCode(clazz, clazz.getName());

        MyClassLoader loader = new MyClassLoader();
        for (long i = 0; i < Long.MAX_VALUE; i++) {
            String newClassName = "_" + String.format("%0" + (clazz.getSimpleName().length() -1 ) + "d", i);
            byte[] newClassData = new String(buffer, "latin1").replaceAll(clazz.getSimpleName(), newClassName).getBytes("latin1");
//            !Metaspace not overflow condition!
//            loader = new MyClassLoader();
            loader._defineClass(clazz.getName().replaceAll(clazz.getSimpleName(),newClassName), newClassData);
        }
    }

}
