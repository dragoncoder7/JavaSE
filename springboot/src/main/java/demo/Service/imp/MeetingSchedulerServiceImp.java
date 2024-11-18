package demo.Service.imp;

import demo.Service.MeetingSchedulerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class MeetingSchedulerServiceImp implements MeetingSchedulerService {

    private final RestTemplate restTemplate;
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);


    public MeetingSchedulerServiceImp(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    @Override
    public void scheduleMeetingClosure(String closeMeetingUrl, LocalDateTime endTime) {
        log.info("预定时任务计划中：" + LocalDateTime.now());
        // 计算当前时间到会议结束时间的延迟
        long delay = Date.from(endTime.atZone(ZoneId.systemDefault()).toInstant()).getTime()
                - System.currentTimeMillis();
        log.info("延迟时长："+ delay);

        // 计划在指定延迟后执行关闭会议任务
        scheduler.schedule(() -> closeMeeting(closeMeetingUrl), delay, TimeUnit.MILLISECONDS);
    }

    private void closeMeeting(String closeMeetingUrl) {
        log.info("开始调用会议结束接口");
        // 调用关闭会议接口
        //restTemplate.postForObject(closeMeetingUrl, null, Void.class);
        System.out.println("会议已自动关闭：" + LocalDateTime.now());
    }
}
