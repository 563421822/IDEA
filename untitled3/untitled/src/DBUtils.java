import java.net.URL;

public class DBUtils {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        URL[] urls = sun.misc.Launcher
        for (URL url : urls) {
            System.out.println(url.toExternalForm());
        }
    }
}
