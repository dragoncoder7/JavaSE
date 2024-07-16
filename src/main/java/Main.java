import WebService.WorkflowService;
import WebService.WorkflowServicePortType;

public class Main {
    public static void main(String[] args) {
        /*WorkflowService workflowService = new WorkflowService();
        WorkflowServicePortType workflowServicePortType = workflowService.getWorkflowServiceHttpPort();
        boolean s = workflowServicePortType.deleteRequest(7001078,231129);*/

        //System.out.println(s);
        String time,date,HRid;
        time = "10:00:00";
        date = "2023-03-01";
        HRid = "123456";
        String sql = "SELECT *\n" +
                "FROM\n" +
                "\tk07 a \n" +
                "WHERE\n" +
                "\ta.k0701 = (SELECT CONVERT\n" +
                "\t(\n" +
                "\t\tDATETIME,\n" +
                "\t\t'1900-01-01 ' + '"+time+"' ))\n" +
                "\t\tAND a.k0700 = (select CONVERT ( DATETIME, '"+date+"', 120 ))  and a.A0188 = "+ HRid;
        System.out.println(sql);
    }
}