package com.apricity.utils;

import com.apricity.exception.FileException;

import java.io.IOException;
import java.io.InputStream;

public class AStringUtils {

    /**
     * 将二进制流转换为String
     * @param is 二进制流
     */
    public static String read(InputStream is) {
        try {
            byte[] bytes = null;

            byte[] buf = new byte[2048];
            int i;
            while ((i = is.read(buf)) != -1) {
                if (bytes == null) {
                    bytes = new byte[i];

                    System.arraycopy(buf, 0, bytes, 0, i);
                } else {
                    byte[] temp = new byte[bytes.length + i];

                    System.arraycopy(bytes, 0, temp, 0, bytes.length);

                    System.arraycopy(buf, 0, temp, bytes.length, i);

                    bytes = temp;
                }
            }

            if (bytes == null) {
                return "";
            }

            return new String(bytes, EncodingDetect.detect(bytes));
        } catch (IOException e) {
            throw new FileException(e);
        }
    }
}
