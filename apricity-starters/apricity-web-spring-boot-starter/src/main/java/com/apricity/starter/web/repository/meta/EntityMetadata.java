package com.apricity.starter.web.repository.meta;

import com.apricity.starter.web.repository.id.IdGenerator;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Builder
public class EntityMetadata {
    private Class<?> entityClass;

    private String tableName;

    private IdDescriptor idDescriptor;

    private List<FieldMetadata> fields = new ArrayList<>();
}
