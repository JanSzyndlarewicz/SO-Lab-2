package algorithms;

import requests.Request;

import java.util.ArrayList;

public class SCAN extends StaticAlgorithm{

    public SCAN(){}

    public SCAN(int currentPosition, int currentTime, int distanceTraveled) {
        super(currentPosition, currentTime, distanceTraveled);
    }

    @Override
    public void doAlgorithm(ArrayList<Request> requests, RealTimeAlgorithm realTimeAlgorithm, int range) {
        int requestCounter = 0;
        int direction = 1;

        while (requestCounter < requests.size()){
            Request.priorityHandler(requests, this, realTimeAlgorithm);

            requestCounter = 0;

            for (Request request: requests)
                if(request.isDone()) requestCounter++;

            Request request = findClosestOnTheSameDirection(requests, currentTime, currentPosition, direction);

            if(request != null){
                Request.requestStatsHandler(this, request);
                requestCounter++;
            }
            else {
                currentTime++;
                currentPosition += direction;
                if(currentPosition > range || currentPosition < 0){
                    direction *= -1;
                    currentPosition += direction;
                    currentPosition += direction;
                }
            }
        }
    }

    private static Request findClosestOnTheSameDirection(ArrayList<Request> requests, int currentTime, int currentPosition, int direction){
        Request closestOnTheSameDirection = null;

        for (Request request : requests) {
            if((closestOnTheSameDirection == null && !request.isDone() && request.getENTRY_TIME()<=currentTime && direction*request.getDISC_POSITION() >= direction*currentPosition) ||
                    ((closestOnTheSameDirection != null &&
                            !request.isDone() &&
                            direction*(request.getDISC_POSITION()-currentPosition) >= 0 &&
                            direction*(request.getDISC_POSITION()-currentPosition)<direction*closestOnTheSameDirection.getDISC_POSITION()-currentPosition &&
                            request.getENTRY_TIME()<=currentTime)))
                closestOnTheSameDirection = request;
        }

        return closestOnTheSameDirection;
    }

    @Override
    public String getAlgorithmName() {
        return "SCAN";
    }
}
