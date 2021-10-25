package com.apricity.utils;

import com.apricity.exception.FileException;

import java.io.IOException;
import java.io.InputStream;

public class StringUtils extends org.apache.commons.lang3.StringUtils {

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

    public static String underscoreToCamelCase(String source) {
        if (!source.contains("_")) {
            return source;
        }
        char[] chars = source.toCharArray();
        StringBuilder sb = new StringBuilder();
        boolean nextUpper = false;
        for (char c : chars) {
            if (c == '_') {
                nextUpper = true;
            } else if (nextUpper) {
                sb.append(Character.toUpperCase(c));
                nextUpper = false;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static String camelCaseToUnderscore(String source) {
        char[] chars = source.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            if (Character.isUpperCase(c)) {
                sb.append('_').append(Character.toLowerCase(c));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
