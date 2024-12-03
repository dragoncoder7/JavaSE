package LeetCode.QueueAndStack;

import java.text.SimpleDateFormat;
import java.util.Date;

public class abcc {
    public static void main(String[] args) {
        // 获取当前时间
        Date now = new Date();

        // 定义日期格式
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // 格式化日期
        String formattedDate = dateFormat.format(now);

        System.out.println("当前时间：" + formattedDate);

        System.out.println(new java.sql.Date(System.currentTimeMillis()));

        String sql = "select a.requestid,e.lastname,b.syzxm,b.syrgh,b.sybm,f.jobtitlename,d.departmentname,b.sscq,b.lxfs,b.qxlx,b.bz,a.sqrxm,a.sqrgh,a.sqbm,a.lcbh\n" +
                "from formtable_main_1661 a right join formtable_main_1661_dt1 b on a.id = b.mainid\n" +
                "left join workflow_requestbase c on a.requestid = c.requestid\n" +
                "left join hrmdepartment d on b.sybm = d.id\n" +
                "left join hrmresource e on b.syzxm = e.id\n" +
                "left join hrmjobtitles f on b.zw = f.id\n" +
                "where b.syzxm is not null and c.Currentnodetype = 3";

        System.out.println(sql);
    }
}
