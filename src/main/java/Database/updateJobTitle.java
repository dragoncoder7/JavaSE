package Database;

import java.sql.*;


public class updateJobTitle {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("oracle.jdbc.driver.OracleDriver");

        String url = "jdbc:oracle:thin:@10.10.1.59:1521:oatst?useUnicode=true&characterEncoding=utf8&useSSL=true&serverTimezone=UTC";
        String username = "ecology";
        String password = "ecology";

        Connection connection = DriverManager.getConnection(url, username, password);

        connection.setAutoCommit(false);

        Statement statement = connection.createStatement();

        Statement statement1 = connection.createStatement();

        //获得HR系统人员用OA账号且岗位不为空、OA账号正常使用 人名工号都一致的OA账号人员
        String query = "select * from uf_a01 a inner join hrmresource b on a.a0190= b.workcode and a.a0101 = b.lastname where b.status in(0,1,2,3) and a.a01zjtitle is not null";

        ResultSet resultSet = statement.executeQuery(query);

        String oldTitle = "";

        int count = 0;

        int SuccessCount = 0;

        while (resultSet.next()){
            count++;
            String workcode = resultSet.getString("a0190");//工号
            String lastname = resultSet.getString("lastname");//人员姓名
            String a01zjtitle = resultSet.getString("a01zjtitle");//HR岗位信息
            //String workcode = "A0117856";

            //获得OA人员id和HR岗位同步到OA岗位表中对应的id 测试环境数据
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
            if(count == 1)System.out.println(queryID);//输出执行的SQL

            //查询该人员现OA岗位信息
            String query1 = "select c.jobtitlemark from HrmJobTitles c where c.id = (select a.jobtitle from hrmresource a where a.workcode = '"+workcode+"')";

            ResultSet result = statement1.executeQuery(query1);

            while (result.next()){
                oldTitle = result.getString("jobtitlemark");
            }
            if (oldTitle.isEmpty() || oldTitle.equals(" ")){
                oldTitle = "null";
            }
            System.out.println("修改前信息：lastname："+lastname+" workcode："+workcode+" 现OA岗位："+oldTitle+" HR岗位："+a01zjtitle);
            if (oldTitle.equals(a01zjtitle)){
                System.out.println("岗位与HR系统一致，不需要修改\n");
                continue;
            }

            result = statement1.executeQuery(queryID);
            int jobtitleid = 0,hrid = 0;
            while (result.next()){
                jobtitleid = result.getInt(1);
                hrid = result.getInt(2);
                System.out.println("jobtitleid = "+jobtitleid+" hrid = "+hrid);
            }
            String updateSql = "update hrmresource a set a.jobtitle = "+jobtitleid+" where a.id = "+hrid;
            System.out.println(updateSql);

            int res = statement1.executeUpdate(updateSql);
            if (res > 0){
                System.out.println("修改成功\n");
                connection.commit();
                SuccessCount += res;
            }else {
                System.out.println("修改失败\n");
            }

            //获得更新后的OA岗位
            String getNewJobtitle = "select jobtitlemark from hrmjobtitles a inner join hrmresource b on a.id = b.jobtitle and b.workcode = '"+workcode+"'";
            result = statement1.executeQuery(getNewJobtitle);
            result.next();
            System.out.println("修改后信息：lastname："+lastname+" workcode："+workcode+" 现OA岗位："+result.getString("jobtitlemark")+" HR岗位："+a01zjtitle);
            break;//只更新一条数据
        }
        System.out.println("一共查询到"+count+"条  成功修改："+SuccessCount+"条");
        //4.执行sql

        //5.处理结果

        //6.关闭连接
        resultSet.close();
        statement.close();
        statement1.close();
        connection.close();
    }
}
