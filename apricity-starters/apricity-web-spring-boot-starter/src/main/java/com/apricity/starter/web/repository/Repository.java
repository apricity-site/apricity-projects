package com.apricity.starter.web.repository;

import com.apricity.starter.web.repository.provider.Insert;
import org.apache.ibatis.annotations.InsertProvider;

public interface Repository<T> {
    @InsertProvider(value = Insert.class, method = "invoke")
    void insert(T e);
}
