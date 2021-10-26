package com.apricity.starter.web.repository;

import com.apricity.starter.web.repository.annotation.Column;
import com.apricity.starter.web.repository.annotation.Id;
import com.apricity.starter.web.repository.annotation.Table;
import com.apricity.starter.web.repository.meta.EntityMetadata;
import com.apricity.starter.web.repository.meta.FieldMetadata;
import com.apricity.starter.web.repository.meta.IdDescriptor;
import com.apricity.starter.web.repository.meta.MetadataManager;
import com.apricity.utils.StringUtils;
import org.springframework.context.ApplicationContext;

import java.lang.reflect.Field;
import java.util.*;

public class RepositoryInitializer {

    private final ApplicationContext applicationContext;

    public RepositoryInitializer(ApplicationContext applicationContext) throws Exception {
        this.applicationContext = applicationContext;
        init();
    }

    @SuppressWarnings("all")
    public void init() throws Exception {
        Map<String, Repository> repositoryMap = applicationContext.getBeansOfType(Repository.class);
        Set<Repository> repositorySet = new HashSet<>(repositoryMap.values());
        for (Repository repository : repositorySet) {
            Class<?> entityClass = RepositoryHelper.getEntityClass(repository.getClass());
            initEntityMetadata(entityClass);
        }
    }

    private void initEntityMetadata(Class<?> entityClass) throws Exception {
        EntityMetadata entityMetadata = EntityMetadata.builder().entityClass(entityClass)
                .fields(resolveEntityFields(entityClass))
                .idDescriptor(resolveIdDesc(entityClass))
                .tableName(resolveTablName(entityClass))
                .build();
        MetadataManager.INSTANCE.registerMetadata(entityMetadata);
    }

    private String resolveTablName(Class<?> entityClass) {
        Table table = entityClass.getAnnotation(Table.class);
        if (Objects.nonNull(table)) {
            return table.value();
        }
        // TODO 全局表名前缀 && 下划线
        return entityClass.getSimpleName().toLowerCase();
    }


    private IdDescriptor resolveIdDesc(Class<?> entityClass) throws Exception {
        Field idField = Arrays.stream(entityClass.getDeclaredFields())
                .filter(field -> Objects.nonNull(field.getAnnotation(Id.class)))
                .findFirst().orElse(null);
        if (Objects.nonNull(idField)) {
            return IdDescriptor.builder()
                    .idGenerator(
                            idField.getAnnotation(Id.class)
                                    .generateStrategy().getDeclaredConstructor().newInstance()
                    ).field(idField)
                    .column(idField.getName())
                    .build();
        }
        if (Objects.nonNull(entityClass.getSuperclass())) {
            return resolveIdDesc(entityClass.getSuperclass());
        }
        return null;
    }

    private List<FieldMetadata> resolveEntityFields(Class<?> entityClass) {
        List<FieldMetadata> fieldMetadataList = new ArrayList<>();
        if (entityClass.getSuperclass() != null) {
            fieldMetadataList.addAll(resolveEntityFields(entityClass.getSuperclass()));
        }
        for (Field field : entityClass.getDeclaredFields()) {
            FieldMetadata.builder()
                    .fieldName(field.getName())
                    .columnName(resolveColumnName(field))
                    .updateIfNull(isUpdateIfNull(field))
                    .primary(Objects.nonNull(field.getAnnotation(Id.class)))
                    .build();
        }
        return fieldMetadataList;
    }

    private boolean isUpdateIfNull(Field field) {
        Column column = field.getAnnotation(Column.class);
        if (Objects.nonNull(column)) {
            return column.updateIfNull();
        }
        // TODO 全局配置
        return false;
    }

    private String resolveColumnName(Field field) {
        Column column = field.getAnnotation(Column.class);
        if (Objects.nonNull(column) && StringUtils.isNotBlank(column.value())) {
            return column.value();
        }
        // TODO 根据全局配置设置下划线
        return field.getName().toLowerCase();
    }
}
