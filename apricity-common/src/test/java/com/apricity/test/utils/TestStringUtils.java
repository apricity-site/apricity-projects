package com.apricity.test.utils;

import com.apricity.utils.StringUtils;
import org.junit.jupiter.api.Test;

public class TestStringUtils {
    @Test
    void test_camelToUnderline() {
        String helloWorld = StringUtils.camelToUnderline("helloWorldA");
        System.out.print(helloWorld);
    }

    @Test
    void test_underlineToCamel() {
        String helloWorld = StringUtils.underlineToCamel("hello_world_a");
        System.out.print(helloWorld);
    }
}
