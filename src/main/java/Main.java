import WebService.WorkflowService;
import WebService.WorkflowServicePortType;

public class Main {
    public static void main(String[] args) {
        WorkflowService workflowService = new WorkflowService();
        WorkflowServicePortType workflowServicePortType = workflowService.getWorkflowServiceHttpPort();
        boolean s = workflowServicePortType.deleteRequest(7001078,231129);

        System.out.println(s);
    }
}