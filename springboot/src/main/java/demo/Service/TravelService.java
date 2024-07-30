package demo.Service;

import demo.entity.TravelInfo;

public interface TravelService {

    String createTravelApply(int requestId);

    TravelInfo getTravelInfo(int requestId);

    String test();
}
