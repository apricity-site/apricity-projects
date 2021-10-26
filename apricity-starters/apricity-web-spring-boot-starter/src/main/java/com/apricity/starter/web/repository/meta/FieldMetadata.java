package com.apricity.starter.web.repository.meta;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class FieldMetadata {
    private String fieldName;

    private String columnName;

    private boolean primary = false;

    private boolean updateIfNull = false;
}
