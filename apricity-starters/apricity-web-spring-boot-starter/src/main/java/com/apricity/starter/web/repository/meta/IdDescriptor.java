package com.apricity.starter.web.repository.meta;

import com.apricity.starter.web.repository.id.IdGenerator;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Field;

@Setter
@Getter
@Builder
public class IdDescriptor {
    private String column;
    private Field field;
    private IdGenerator<?> idGenerator;
}
