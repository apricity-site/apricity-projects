package com.apricity.test.utils;

import com.apricity.utils.ReflectionUtils;
import org.junit.jupiter.api.Test;

public class TestReflectionUtils {



    @Test
    void test_getReadMethod() {
        Student student = new Student();
        student.setName("name");
        student.setScore(100);
        student.setGraduated(false);
        student.setMale(false);

        ReflectionUtils.getReadMethod(student, "name");
        ReflectionUtils.getReadMethod(student, "score");
        ReflectionUtils.getReadMethod(student, "graduated");
        ReflectionUtils.getReadMethod(student, "male");
    }



    class Student {
        private String name;
        private int score;
        private boolean graduated;
        private Boolean male;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public boolean isGraduated() {
            return graduated;
        }

        public void setGraduated(boolean graduated) {
            this.graduated = graduated;
        }

        public Boolean getMale() {
            return male;
        }

        public void setMale(Boolean male) {
            this.male = male;
        }
    }
}
