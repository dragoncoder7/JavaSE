package Database;

import java.sql.*;


public class JDBCDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.加载驱动
        //Driver driver = new com.mysql.cj.jdbc.Driver();//需要导包，可替换为new com.mysql.cj.jdbc.Driver();
        //Class.forName("com.mysql.cj.jdbc.Driver");
        //注册驱动
        //DriverManager.registerDriver(driver);
        Driver driver = new oracle.jdbc.driver.OracleDriver();
        DriverManager.registerDriver(driver);
        Class.forName("oracle.jdbc.driver.OracleDriver");
        //2.连接信息url,用户信息
        String url = "jdbc:oracle:thin:@10.10.1.59:1521:oatst?useUnicode=true&characterEncoding=utf8&useSSL=true&serverTimezone=UTC";
        String username = "ecology";
        String password = "ecology";

        //3.连接,获得数据库对象connection
        Connection connection = DriverManager.getConnection(url, username, password);
        connection.setAutoCommit(false);
        Statement statement = connection.createStatement();//获得HR系统中有OA账号的人员
        Statement statement1 = connection.createStatement();//查询人员OA 的id 和 需要更新的岗位id
        Statement statement2 = connection.createStatement();//查询人员原OA 岗位
        Statement statement3 = connection.createStatement();
        String query = "select * from uf_a01 a inner join hrmresource b on a.a0190= b.workcode and a.a0101 = b.lastname where b.status in(0,1,2,3) and a.a01zjtitle is not null";
        ResultSet resultSet = statement.executeQuery(query);
        String oldTitle = "";

        int count = 0;
        int SuccessCount = 0;
        while (resultSet.next()){
            count++;
            String workcode = resultSet.getString("a0190");
            //String workcode = "A0117856";
            String queryID = "select c.id,\n" +
                    "       b.id\n" +
                    "  from HrmJobTitles c\n" +
                    " inner join uf_a01 a\n" +
                    "    on c.jobtitlemark = a.a01zjtitle\n" +
                    " inner join hrmresource b\n" +
                    "    on a.a0190 = b.workcode\n" +
                    "   and a.a0101 = b.lastname\n" +
                    " where b.status in (0, 1, 2, 3)\n" +
                    "   and a.a0190 = '"+workcode+"'\n" +
                    "   and c.jobactivityid in\n" +
                    "       (select b.id from hrmjobactivities b where b.jobgroupid = 2537)\n" +
                    "   and (canceled is null or canceled != '1')";
            if(count == 1)System.out.println(queryID);

            String query1 = "select c.jobtitlemark from HrmJobTitles c where c.id = (select a.jobtitle from hrmresource a where a.workcode = '"+workcode+"')";

            ResultSet result = statement2.executeQuery(query1);
            while (result.next()){
                oldTitle = result.getString("jobtitlemark");
            }
            if (oldTitle.isEmpty() || oldTitle.equals(" ")){
                oldTitle = "null";
            }
            String lastname = resultSet.getString("lastname");
            String a01zjtitle = resultSet.getString("a01zjtitle");
            //System.out.println("lastname："+lastname+" workcode："+workcode+" 现OA岗位："+oldTitle+" HR岗位："+a01zjtitle);
            /*if (oldTitle.equals(a01zjtitle)){
                System.out.println("岗位与HR系统一致，不需要修改");
                continue;
            }*/
            if (!oldTitle.equals(a01zjtitle)){
                System.out.println("lastname："+lastname+" workcode："+workcode+" 现OA岗位："+oldTitle+" HR岗位："+a01zjtitle);
                SuccessCount++;
                continue;
            }

            ResultSet rs = statement1.executeQuery(queryID);
            int jobtitleid = 0,hrid = 0;
            while (rs.next()){
                jobtitleid = rs.getInt(1);
                hrid = rs.getInt(2);
                System.out.println("jobtitleid = "+jobtitleid+" hrid = "+hrid);
            }
            /*String updateSql = "update hrmresource a set a.jobtitle = "+jobtitleid+" where a.id = "+hrid;
            System.out.println(updateSql);

            int res = statement3.executeUpdate(updateSql);
            if (res > 0){
                System.out.println("修改成功\n");
                connection.commit();
            }
            SuccessCount += res;
            if (count >= 3)
                break;*/
        }
        System.out.println("成功修改："+SuccessCount+"条");
        //4.执行sql

        //5.处理结果

        //6.关闭连接
        resultSet.close();
        statement.close();
        connection.close();
    }
}
