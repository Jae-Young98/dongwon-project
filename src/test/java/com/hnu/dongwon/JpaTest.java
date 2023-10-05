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
public class JpaTest {

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
            stmt = connection.createStatement();
            resultSet = stmt.executeQuery("SELECT TOP 1000 * FROM Dongwontemp.dbo.Manage_NationalDefense");
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            final int columnCount = resultSetMetaData.getColumnCount();
            while (resultSet.next()) {
                Object[] values = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    values[i-1] = resultSet.getObject(i);
                    System.err.print(values[i - 1] + "      ");
                }
                System.err.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            assert resultSet != null;
            resultSet.close();
            stmt.close();
            connection.close();
        }
    }
}
