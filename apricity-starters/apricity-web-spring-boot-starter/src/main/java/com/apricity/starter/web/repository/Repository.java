package com.apricity.starter.web.repository;

import com.apricity.starter.web.repository.provider.MybatisProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.Collection;
import java.util.List;

public interface Repository<T> {
    @InsertProvider()
    boolean insert(T t);

    int insertBatch(Collection<T> entities);

    @SelectProvider(MybatisProvider.class)
    List<T> listAll();

    @SelectProvider(MybatisProvider.class)
    T selectById();
}
