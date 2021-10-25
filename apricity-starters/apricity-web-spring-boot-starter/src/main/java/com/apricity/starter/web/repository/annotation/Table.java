package com.apricity.starter.web.repository.annotation;

import java.lang.annotation.*;


@Target(ElementType.TYPE)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Table {
    /**
     * @return table name
     */
    String value() default "";
}
