package com.itrex.java.lab.jmm;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ClassLoaderUtil {

    public static byte[] loadByteCode(Class loader, String className) throws IOException {
        String fileName = "/" + className.replaceAll("\\.", "/") + ".class";
        InputStream is = loader.getResourceAsStream(fileName);

        ByteArrayOutputStream buffer = new ByteArrayOutputStream(4096);
        byte[] buff = new byte[1024];
        int l;
        while ((l = is.read(buff)) >= 0) {
            buffer.write(buff, 0, l);
        }

        return buffer.toByteArray();
    }

}