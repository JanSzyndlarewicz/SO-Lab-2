package algorithms;

import requests.Request;

import java.util.ArrayList;

public class SSTF extends StaticAlgorithm{

    public SSTF(){}

    public SSTF(int currentPosition, int currentTime, int distanceTraveled) {
        super(currentPosition, currentTime, distanceTraveled);
    }

    @Override
    public void doAlgorithm(ArrayList<Request> requests, RealTimeAlgorithm realTimeAlgorithm, int range) {
        int requestCounter = 0;

        while (requestCounter<requests.size()){

            Request.priorityHandler(requests, this, realTimeAlgorithm);

            requestCounter = 0;

            for (Request request: requests)
                if(request.isDone()) requestCounter++;

            Request request = pickRequestWithTheShortestDistance(requests, currentTime, currentPosition);

            if(request != null){
                Request.requestStatsHandler(this, request);
                requestCounter++;
            }
            else {
                currentTime++;
            }
        }
    }

    private static Request pickRequestWithTheShortestDistance(ArrayList<Request> requests, int currentTime, int currentPosition){
        Request bestRequestToPick = null;

        for (Request request : requests) {
            if((bestRequestToPick == null && !request.isDone() && request.getENTRY_TIME()<=currentTime) ||
                    ((bestRequestToPick != null &&
                            !request.isDone() &&
                            Math.abs(request.getDISC_POSITION()-currentPosition)<Math.abs(bestRequestToPick.getDISC_POSITION()-currentPosition) &&
                            request.getENTRY_TIME()<=currentTime)))
                bestRequestToPick = request;
        }

        return bestRequestToPick;
    }


    @Override
    public String getAlgorithmName() {
        return "SSTF";
    }
}
