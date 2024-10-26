package demo.Service;

import java.util.Map;

public interface HrService {
    Map<String, Object> syncOvertime(int requestId, int workflowID);

    Map<String, Object> syncLeave(int requestId, int workflowId);

    Map<String, Object> syncResetLeave(int requestId, int workflowId);

    Map<String, Object> syncBusinessLeave(int requestId);

    Map<String, Object> syncRewardPunishment(int requestId);

    Map<String, Object> syncTimeRecords(int requestId, int workflowId);


    boolean checkInfo(String username, String employeeId);
}
