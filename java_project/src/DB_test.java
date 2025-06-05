import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB_test {
    // main에서 사용할 수 있도록 static
    // 데이터의 내용이 고쳐지면 안되므로 final
    // 상수는 대문자로 표기
    static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
    static final String JDBC_URL = "jdbc:mariadb://localhost:3306/practice";
    static final String USER = "root";
    static final String PASSWORD = "mariadb";

    public static void main(String[] args) {

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {

            Class.forName(JDBC_DRIVER);
            System.out.println("JDBC 드라이버 로드 성공");

            con = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
            System.out.println("데이터베이스 연결 성공");
            stmt = con.createStatement();

            String selectSQL = "SELECT * FROM member";
            rs = stmt.executeQuery(selectSQL);

            while(rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String addr = rs.getString("addr");

                System.out.print("id : " + id + ", ");
                System.out.print("name : " + name + ", ");
                System.out.print("age : " + age + ", ");
                System.out.println("addr : " + addr);
            }

            stmt.close();
            con.close();

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }

    }
}