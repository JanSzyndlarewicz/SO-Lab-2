package algorithms;

import requests.Request;

import java.util.ArrayList;

public class C_SCAN extends StaticAlgorithm{

    public C_SCAN(){}

    public C_SCAN(int currentPosition, int currentTime, int distanceTraveled) {
        super(currentPosition, currentTime, distanceTraveled);
    }

    @Override
    public void doAlgorithm(ArrayList<Request> requests, RealTimeAlgorithm realTimeAlgorithm, int range) {
        int requestCounter = 0;

        while (requestCounter < requests.size()){
            Request.priorityHandler(requests, this, realTimeAlgorithm);

            requestCounter = 0;

            for (Request request: requests)
                if(request.isDone()) requestCounter++;

            Request request = findClosestOnTheRight(requests, currentTime, currentPosition);

            if(request != null){
                Request.requestStatsHandler(this, request);
                requestCounter++;
            }
            else {
                currentTime++;
                currentPosition++;
                if(currentPosition > range){
                    currentPosition = 0;
                    currentTime += range -1;
                }
            }
        }
    }

    private static Request findClosestOnTheRight(ArrayList<Request> requests, int currentTime, int currentPosition){
        Request closestOnTheRight = null;

        for (Request request : requests) {
            if((closestOnTheRight == null && !request.isDone() && request.getENTRY_TIME()<=currentTime && request.getDISC_POSITION() >= currentPosition) ||
                    ((closestOnTheRight != null &&
                            !request.isDone() &&
                            request.getDISC_POSITION()-currentPosition >= 0 &&
                            request.getDISC_POSITION()-currentPosition<closestOnTheRight.getDISC_POSITION()-currentPosition &&
                            request.getENTRY_TIME()<=currentTime))){
                closestOnTheRight = request;
            }

        }

        return closestOnTheRight;
    }

    @Override
    public String getAlgorithmName() {
        return "C-SCAN";
    }
}
