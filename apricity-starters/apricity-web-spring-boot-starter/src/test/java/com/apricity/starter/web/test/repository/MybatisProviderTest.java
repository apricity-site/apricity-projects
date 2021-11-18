package com.apricity.starter.web.test.repository;



import com.apricity.starter.web.test.SpringBaseTest;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = {SpringMybatisConfig.class})
public class MybatisProviderTest extends SpringBaseTest {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Test
    void t00_providerInjectTest() {
        Configuration configuration = sqlSessionFactory.getConfiguration();
    }
}
