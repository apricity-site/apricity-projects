package com.apricity.starter.web.repository.provider;

import com.apricity.starter.web.repository.RepositoryHelper;
import com.apricity.starter.web.repository.meta.EntityMetadata;
import org.apache.ibatis.jdbc.SQL;

import java.util.Objects;

public class UpdateById extends AbstractProvider{
    @Override
    protected String buildSql(EntityMetadata entityMetadata, Object params) {
        if (Objects.nonNull(entityMetadata.getIdDescriptor())) {
            SQL sql = new SQL().UPDATE(entityMetadata.getTableName());
        }
        return null;
    }
}
