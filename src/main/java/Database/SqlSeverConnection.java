package Database;

import java.sql.*;

public class SqlSeverConnection {
    public static void main(String[] args) {
        String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

        String dbURL = "jdbc:sqlserver://10.10.12.32:1433;DatabaseName=hxhrEwpt";

        String userName = "ehr";

        String userPwd = "abcd1234@";

        Connection dbConn;

        String startTime = "2024-07-01 08:00";
        String endTime = "2024-07-20 17:30";
        int id = 433039;
        String sql = "SELECT\n" +
                "\t* \n" +
                "FROM\n" +
                "\tk20 a \n" +
                "WHERE\n" +
                "\ta.A0188 = "+id+" \n" +
                "\tAND a.k2006 >= CONVERT ( VARCHAR, '"+startTime.split(" ")[0]+"', 120 ) \n" +
                "\tAND a.k2007 >= CONVERT ( VARCHAR, '"+endTime.split(" ")[0]+"', 120 ) \n" +
                "\tAND a.k2008 = CONVERT ( VARCHAR, '"+startTime.split(" ")[1]+"', 108 ) \n" +
                "\tAND a.k2009 = CONVERT ( VARCHAR, '"+endTime.split(" ")[1]+"', 108 )";
        try {
            dbConn = DriverManager.getConnection(dbURL, userName, userPwd);

            Class.forName(driverName);

            Statement st = dbConn.createStatement();

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                System.out.println(rs.getString("OA单据号"));

            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


        //String sql = "select A01bzzj from A01 where a0190 = 'C0157569'";
        //String starttime = "2024-07-06 08:45";
        //String endtime = "2024-07-06 08:50";


    }
}
