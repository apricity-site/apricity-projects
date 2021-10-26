package com.apricity.starter.web.repository.meta;

import com.apricity.starter.web.repository.RepositoryHelper;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public enum EntityMetadataManager {

    INSTANCE;

    private final ConcurrentMap<Class<?>, EntityMetadata> entityMetadataMap = new ConcurrentHashMap<>();

    public void registerMetadata(EntityMetadata metadata) {
        this.entityMetadataMap.put(metadata.getEntityClass(), metadata);
    }

    public EntityMetadata getMetadata(Class<?> entityClass) {
        return entityMetadataMap.get(entityClass);
    }

    public EntityMetadata getMetadataByRepo(Class<?> repoClz) {
        return getMetadata(RepositoryHelper.getEntityClass(repoClz));
    }
}
