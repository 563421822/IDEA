package utils;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class DBUtilsTest {

    @Test
    public void update() throws SQLException {
        String sql = "INSERT INTO t_user ( username, PASSWORD, gender, birthday, hobby, city ) VALUES (?,?,?,?,?,?)";

        for (int i = 0; i < 100; i++) {
            DBUtils.update(sql, "张三" + i, 2 % (i + 1), i % 2 == 0 ? "female" : "male", 1997 + i + "-10-8", "测试" + i, "Beijing");

        }
    }
}