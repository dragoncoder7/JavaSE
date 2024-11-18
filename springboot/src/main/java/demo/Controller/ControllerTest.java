package demo.Controller;

import demo.Https.HTTP;
import demo.Service.MeetingSchedulerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
@Slf4j
@RestController
public class ControllerTest {

    private final MeetingSchedulerService meetingSchedulerService;

    public ControllerTest(MeetingSchedulerService meetingSchedulerService) {
        this.meetingSchedulerService = meetingSchedulerService;
    }


    @GetMapping(path = "/test1",params = "time")
    public String test(@RequestParam long time){
        log.info("time :"+time);
        meetingSchedulerService.scheduleMeetingClosure("abc", LocalDateTime.now().plusSeconds(time));
        return "success";
    }
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(new HTTP().Get("","https://api.lbbb.cc/api/zuanyulu"));
        }
    }
}
