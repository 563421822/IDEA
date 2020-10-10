import java.sql.*;

public class JdbcTest {
    public static void main(String[] args) {
        Connection conn = null;
        Statement state = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/aa", "root", "");
            String sql = "SELECT sno,sname,ssex,sbirthday,class FROM student";
            state = conn.createStatement();
            resultSet = state.executeQuery(sql);
            System.out.println("StuNO\tName\tSex\tBirthday\tClass");
            while (resultSet.next()) {
//                the first row
//                int sno = resultSet.getInt("sno");
//                String sname = resultSet.getString("sname");
//                String ssex = resultSet.getString("ssex");
//                Date birthday = resultSet.getDate("sbirthday");
//                String aClass = resultSet.getString("class");

                int sno = resultSet.getInt(1);
                String sname = resultSet.getString(2);
                String ssex = resultSet.getString(3);
                Date birthday = resultSet.getDate(4);
                String aClass = resultSet.getString(5);


                System.out.println(sno + "\t" + sname + "\t" + ssex + "\t" + birthday + "\t" + aClass);

            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {

        }
    }
}
