package com.apricity.starter.web.repository.provider;

import com.apricity.starter.web.repository.meta.EntityMetadata;
import com.apricity.starter.web.repository.meta.FieldMetadata;
import com.apricity.utils.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import java.util.stream.Collectors;

public class SelectAll extends AbstractProvider{
    @Override
    protected String buildSql(EntityMetadata entityMetadata, Object params) {
        SQL selectAll = new SQL();
        return selectAll.SELECT(
                StringUtils.join(entityMetadata.getFields().stream()
                        .map(FieldMetadata::getColumnName).collect(Collectors.toList()), ",")
        ).FROM(entityMetadata.getTableName()).toString();
    }
}
