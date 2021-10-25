package com.apricity.starter.web.repository.id;

/**
 * 主键生成策略
 * @param <T> id 类型
 */
public interface IdGenerator<T> {
    T next();
}
