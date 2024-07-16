package Database;

import java.sql.*;

public class SqlSeverConnection {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

        String dbURL = "jdbc:sqlserver://10.10.12.32:1433;DatabaseName=hxhrEwpt";

        String userName = "ehr";

        String userPwd = "abcd1234@";

        Class.forName(driverName);

        Connection dbConn = DriverManager.getConnection(dbURL, userName, userPwd);

        Statement st = dbConn.createStatement();

        String sql = "select A01bzzj from A01 where a0190 = 'C0157569'";
        String starttime = "2024-07-06 08:45";
        String endtime = "2024-07-06 08:50";
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {

            System.out.println(rs.getString(1));

        }
    }
}
