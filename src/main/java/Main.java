import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    public static final Main MAIN = new Main();

    public static int sum(int a, int b) {
        return a + b;
    }

    public static long getTimeMillis(String datetime) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        long timestamp = 0;
        try {
            Date date = formatter.parse(datetime);
            timestamp = date.getTime();
            System.out.println("Timestamp: " + timestamp);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return timestamp;
    }

    public static void main(String[] args) {
        ArrayList<Object> objects = new ArrayList<>();
        int[] ints = new int[10];
        String sql = "select * from (SELECT b.selectvalue,\n" + "              trim((case\n" + "                     when b.selectname like '~`~`7%' then\n" + "                      SUBSTR(b.selectname,\n" + "                             INSTR(b.selectname, '7') + 1,\n" + "                             INSTR(b.selectname, '`', INSTR(b.selectname, '7') + 1) -\n" + "                             INSTR(b.selectname, '7') - 1)\n" + "                     else\n" + "                      b.selectname\n" + "                   end)) AS selectname\n" + "         FROM workflow_billfield a, workflow_selectitem b, workflow_base c\n" + "        WHERE a.billid = c.formid\n" + "          AND c.id = ?\n" + "          AND b.fieldid = a.id)\n" + "       where selectname = ?";
        System.out.println(sql);
        System.out.println("2024-10".replace("-", ""));
        if (getTimeMillis("2024-09-14 08:53") < getTimeMillis("2024-10-01 00:00")) {
            System.out.println("成功");
        }
        System.out.println(System.currentTimeMillis());
        System.out.println("select id, billid, fieldname, viewtype, detailtable, b.comments" + "  from workflow_billfield a, user_col_comments b" + " where a.billid = #{billid}" + "   and a.viewtype = #{viewtype}" + "   and a.fieldname = lower(b.column_name)" + "   and b.table_name =upper(#{tablename})");

        System.out.println(addStrings("56", "77"));
        String startTime = "2024-04-03 08:00", endTime = "2024-04-07 17:30";
        float id = 42905;

        String sql22 = "SELECT\n" + "\t* \n" + "FROM\n" + "\tk20 a \n" + "WHERE\n" + "\ta.A0188 = " + id + " \n" + "\tAND (\n" + "\t\t( a.k2006 > CONVERT ( VARCHAR, '" + startTime.split(" ")[0] + "', 120 ) AND a.k2006 < CONVERT ( VARCHAR, '" + endTime.split(" ")[0] + "', 120 ) ) \n" + "\t\tOR ( a.k2006 <= CONVERT ( VARCHAR, '" + startTime.split(" ")[0] + "', 120 ) AND a.k2007 >= CONVERT ( VARCHAR, '" + endTime.split(" ")[0] + "', 120 ) ) \n" + "\t\tOR ( a.k2007 > CONVERT ( VARCHAR, '" + startTime.split(" ")[0] + "', 120 ) AND a.k2007 < CONVERT ( VARCHAR, '" + endTime.split(" ")[0] + "', 120 ) ) \n" + "\t)";

        String sadfa = """
                select a.requestid,e.lastname,b.syzxm,b.syrgh,b.sybm,f.jobtitlename,d.departmentname,b.sscq,b.lxfs,b.qxlx,b.bz,a.sqrxm,a.sqrgh,a.sqbm,a.lcbh
                from formtable_main_1661 a right join formtable_main_1661_dt1 b on a.id = b.mainid
                left join workflow_requestbase c on a.requestid = c.requestid
                left join hrmdepartment d on b.sybm = d.id
                left join hrmresource e on b.syzxm = e.id
                left join hrmjobtitles f on b.zw = f.id
                where b.syzxm is not null and c.Currentnodetype = 3""";
        System.out.println(sadfa);
        System.out.println("sql22: " + sql22);

        String sql1 = """
                select a.requestid,a.sqr,b.sfrxm vName,b.zjlx vCertKindName,b.zjhm vCertNo,b.sjhm vPhone,b.sfdw vCompany,b.cph vLicensePlate,b.bzsm vMenu,a.dfsj vStartTime,a.lksj vEndTime,
                a.bfsy1 vReason,a.jdry vEmpName,a.sjhm vEmpPhone,a.lfrs vVisitorNum,a.itwp,a.itwpsm,a.wjp,a.wjpsm,a.sbgjsm,a.sqbm vEmpDepartment,a.hdfw quyu,a.jtwz,a.sjcq area
                from formtable_main_1531 a right join formtable_main_1531_dt1 b on a.id = b.mainid\s
                left join workflow_requestbase c on a.requestid = c.requestid
                where c.Currentnodetype = 3 and trunc(to_date(c.lastoperatedate,'yyyy-MM-dd'))=trunc(sysdate)""";

        System.out.println(Arrays.toString(sql.getBytes(StandardCharsets.UTF_8)));
        System.out.println(sql.codePointAt(1));//获取下标为i的字符的Unicode码
        System.out.println(sql.chars());
        System.out.println(sql.isBlank());
        System.out.println(sql.getClass());
        System.out.println(sql.endsWith("trunc(sysdate)"));//判断一个string是否是以你输入的串结尾
        char[] s = new char[]{1, 2, 3, 4, 55, 66, 88, 10, 5, 9, 10, 22, 78, 16};
        sql.getChars(5, 10, s, 7);
        System.out.println(Arrays.toString(s) + " \n " + sql);
        System.out.println(sql.replace('a', 'b'));
        System.out.println(startTime.repeat(2));
        System.out.println(sql.replaceAll(" ", "999"));
        System.out.println(sql.compareTo(" "));

        System.out.println(String.copyValueOf(new char[]{'a', 'b', ' ', 'c'}));
        //String
        hello();

        System.out.println("#result-set-1");
        JsonNode a = null;
        try {
            if (Objects.equals(a.get("a").asText(), "1")) {
                System.out.println("a");
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    private static void hello() {
        System.out.println(Integer.compare(5, 10));
        System.out.println(Integer.compare(5, 5));
        System.out.println(Integer.compare(5, 3));
        System.out.println("{\"requestId\": " + 9002274 + "}");
    }

    public static String addStrings(String num1, String num2) {
        int add;
        int length = Math.max(num1.length(), num2.length());
        int[] ints = new int[length];
        for (int i = length - 1; i >= 0; i--) {
            int res = 0;
//            int a = Integer.parseInt();
//            int b = Integer.parseInt();
//            if (a + b >= 10){
//                add = 1;
//                res = a + b - 10;
//            }
            ints[i] = res;
        }
        return Arrays.toString(ints);
    }

    private static ObjectNode createAttachmentNode(String oid) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = mapper.createObjectNode();
        node.put("attachmentOID", oid);
        return node;
    }

    private static String initiated() {
        return """
                {
                    "applicant": {
                        "employeeID": ""
                    },
                    "currencyCode": "CNY",
                    "companyCode": "",
                    "custFormValues": [
                        {
                            "fieldCode": "company",
                            "messageKey": "select_company",
                            "valueCode": ""
                        },
                        { \s
                            "fieldCode": "department",
                            "messageKey": "select_cost_center",
                            "value": "",
                            "required": false
                        },
                        {
                            "fieldCode": "travelType",
                            "messageKey": "cust_list",
                            "value": ""
                        },
                        {
                            "fieldCode": "start_date",
                            "messageKey": "start_date",
                            "value": ""
                        },
                        {
                            "fieldCode": "end_date",
                            "messageKey": "end_date",
                            "value": ""
                        },
                        {
                            "fieldCode": "city",
                            "messageKey": "city",
                            "value": "CHN044019000"
                        },
                        {
                            "fieldCode": "participant",
                            "value": "毛云龙",
                            "messageKey": "input"
                        },
                        {
                            "fieldCode": "businessReason",
                            "messageKey": "title",
                            "value": "出差深圳长盈精密~"
                        },
                        {
                            "fieldCode": "isOrderAirTicket",
                            "messageKey": "cust_list",
                            "value": "1"
                        },
                        {
                            "fieldCode": "TAfee",
                            "value": "50000.00",
                            "messageKey": "number"
                        },
                        {
                            "fieldCode": "WorkAgent",
                            "messageKey": "select_user",
                            "valueCode": ""
                        },
                        {
                            "fieldCode": "file",
                            "messageKey": "attachment",
                            "value": ""
                        },
                        {
                            "fieldCode": "projectNoDesc",
                            "messageKey": "input",
                            "value": ""
                        },
                        {
                            "fieldCode": "projectNo",
                            "messageKey": "select_cost_center",
                            "value": "",
                        }
                    ],
                    "formOID": "f3eb46e7-b133-49ca-885f-31eac722b38c",
                    "formType": 2001,
                    "status": 1003,
                    "travelApplication": {},
                    "type": 1002
                }""";
    }
}