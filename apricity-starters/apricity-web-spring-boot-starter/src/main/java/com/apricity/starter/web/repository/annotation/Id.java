package com.apricity.starter.web.repository.annotation;

import com.apricity.starter.web.repository.id.IdGenerator;
import com.apricity.starter.web.repository.id.UuidGenerator;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Id {
    Class<? extends IdGenerator> generateStrategy() default UuidGenerator.class;
}
