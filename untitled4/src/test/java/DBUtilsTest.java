import org.junit.Test;
import utils.DBUtils;

import java.sql.SQLException;

public class DBUtilsTest {
    @Test
    public void updateTest() throws SQLException {
        String sql = "INSERT INTO t_contacts ( name, password, phone, address ) VALUES (?,?,?,?)";
        for (int i = 0; i < 1000; i++) {
            DBUtils.update(sql, "王永亮" + i, Math.random() * 1000 + 1, "", i % 2 == 0 ? "地址不详" : "无");
        }
    }
}
