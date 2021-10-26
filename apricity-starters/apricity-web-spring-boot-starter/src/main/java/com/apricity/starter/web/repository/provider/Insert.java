package com.apricity.starter.web.repository.provider;

import com.apricity.starter.web.repository.meta.EntityMetadata;
import com.apricity.starter.web.repository.meta.FieldMetadata;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.util.Assert;

public class Insert extends AbstractProvider{
    @Override
    protected String buildSql(EntityMetadata entityMetadata, Object params) {
        Assert.isInstanceOf(entityMetadata.getEntityClass(), params);
        // TODO 根据 update if null 筛选出字段与值
        SQL sql = new SQL().INSERT_INTO(entityMetadata.getTableName())
                .INTO_COLUMNS(entityMetadata.getFields().stream()
                        .map(FieldMetadata::getColumnName).toArray(String[]::new)
                ).INTO_VALUES();

        return null;
    }
}
