package demo.Service;

import demo.entity.Message;
import demo.entity.TravelInfo;

public interface TravelService {

    Message createTravelApply(int requestId);

    TravelInfo getTravelInfo(int requestId);

    String getHeliosPeopleInfo(String EmployeeID);

    boolean isHasHeliosAccount(String responseBody);

    String test();
}
