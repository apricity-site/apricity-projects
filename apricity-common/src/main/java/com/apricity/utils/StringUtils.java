package com.apricity.utils;

import com.apricity.constant.StringPool;
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

    /**
     * 字符串下划线转驼峰格式
     *
     * @param param 需要转换的字符串
     * @return 转换好的字符串
     */
    public static String underlineToCamel(String param) {
        if (isBlank(param)) {
            return EMPTY;
        }
        String temp = param.toLowerCase();
        int len = temp.length();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c = temp.charAt(i);
            if (c == '_') {
                if (++i < len) {
                    sb.append(Character.toUpperCase(temp.charAt(i)));
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * 字符串驼峰转下划线格式
     *
     * @param param 需要转换的字符串
     * @return 转换好的字符串
     */
    public static String camelToUnderline(String param) {
        if (isBlank(param)) {
            return EMPTY;
        }
        int len = param.length();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c = param.charAt(i);
            if (Character.isUpperCase(c) && i > 0) {
                sb.append('_');
            }
            sb.append(Character.toLowerCase(c));
        }
        return sb.toString();
    }
}
