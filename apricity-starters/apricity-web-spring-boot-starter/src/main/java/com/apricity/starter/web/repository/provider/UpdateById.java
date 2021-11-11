package com.apricity.starter.web.repository.provider;

import com.apricity.starter.web.repository.RepositoryHelper;
import com.apricity.starter.web.repository.meta.EntityMetadata;
import com.apricity.utils.ReflectionUtils;
import org.apache.ibatis.jdbc.SQL;

import java.util.Objects;

public class UpdateById extends AbstractProvider{
    @Override
    protected String buildSql(EntityMetadata entityMetadata, Object params) {
        if (Objects.nonNull(entityMetadata.getIdDescriptor())) {
            SQL updateById = new SQL().UPDATE(entityMetadata.getTableName());
//            entityMetadata.getFields().stream()
//                    .filter(f -> !f.isPrimary())
//                    .filter(Objects.nonNull())

        }
        return null;
    }
}
