package demo.Service;

import java.util.Map;

public interface HrService {
    Map<String,Object> syncOvertime(int requestId);

    Map<String,Object> syncLeave(int requestId,int workflowId);

    Map<String,Object> syncResetLeave();

    Map<String,Object> syncBusinessLeave();

    Map<String,Object> syncRewardPunishment();

    Map<String,Object> syncTimeRecords();


}
