package com.hnu.dongwon;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class DBTest {

    @Autowired
    DataSource dataSource;

    @Test
    public void connection() throws SQLException {
        Connection connection = null;
        Statement stmt = null;
        ResultSet resultSet = null;

        try {
            connection = dataSource.getConnection();
            DatabaseMetaData metaData = connection.getMetaData();
            log.info("URL : " + metaData.getURL());
            log.info("DriverName : " + metaData.getDriverName());
            log.info("UserName : " + metaData.getUserName());
            //stmt = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //stmt.close();
            connection.close();
        }
    }
}
