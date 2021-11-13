package com.apricity.starter.web.repository.provider;

import com.apricity.exception.UnexpectedException;
import com.apricity.starter.web.repository.RepositoryHelper;
import com.apricity.starter.web.repository.meta.EntityMetadata;
import com.apricity.starter.web.repository.meta.FieldMetadata;
import com.apricity.utils.ReflectionUtils;
import com.apricity.utils.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UpdateById extends AbstractProvider{


    @Override
    protected String buildSql(EntityMetadata entityMetadata, Object params) {
        if (Objects.nonNull(entityMetadata.getIdDescriptor())) {
            SQL updateById = new SQL().UPDATE(entityMetadata.getTableName());
            List<FieldMetadata> updateFieldList = entityMetadata.getFields().stream()
                    .filter(f -> !f.isPrimary())
                    .filter(f -> Objects.nonNull(ReflectionUtils.getReadMethod(params, f.getFieldName()))) // TODO config update if null
                    .collect(Collectors.toList());
            updateById.SET(
                    StringUtils.join(
                            updateFieldList.stream().map(field ->
                                    String.format("%s = #{%s}", field.getColumnName(), field.getFieldName())
                            ).collect(Collectors.toList()),
                            ',')
            );
            return updateById.toString();
        }
        throw new UnexpectedException(String.format("[ %s ] can not find id field, please use @Id annotation",
                entityMetadata.getEntityClass().getName()));
    }
}
