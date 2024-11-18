package demo.Service;

import java.time.LocalDateTime;

public interface MeetingSchedulerService {
    void scheduleMeetingClosure(String closeMeetingUrl, LocalDateTime endTime);
}
