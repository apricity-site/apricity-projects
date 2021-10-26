package com.apricity.starter.web.repository.provider;

import com.apricity.starter.web.repository.meta.EntityMetadata;
import com.apricity.starter.web.repository.meta.EntityMetadataManager;
import org.apache.ibatis.builder.annotation.ProviderContext;

public abstract class AbstractProvider {

    public String invoke(Object params, ProviderContext context) {
        EntityMetadata entityMetadata = EntityMetadataManager.INSTANCE.getMetadataByRepo(context.getMapperType());
        return buildSql(entityMetadata, params);
    }

    protected abstract String buildSql(EntityMetadata entityMetadata, Object params);
}
