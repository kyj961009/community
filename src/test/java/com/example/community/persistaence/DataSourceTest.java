package com.example.community.persistaence;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
@Slf4j
public class DataSourceTest {
    @Autowired
    private DataSource dataSource;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Test
    public void testConnection() {
        try(Connection connection = dataSource.getConnection()) {
            log.info("connection = {}" , connection);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testSqlSessionFactory() {
        try (SqlSession session = sqlSessionFactory.openSession();
             Connection connection = session.getConnection()) {
            log.info("session = {}",session);
            log.info("connection = {}",connection);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
}
