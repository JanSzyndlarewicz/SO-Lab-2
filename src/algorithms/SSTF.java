package algorithms;

import next.Request;

import java.util.ArrayList;

public class SSTF extends Algorithm{

    @Override
    public void doAlgorithm(ArrayList<Request> requests) {
        int requestCounter = 0;

        while (requestCounter<requests.size()){
            Request request = pickRequestWithTheShortestDistance(requests, currentTime, currentPosition);

            if(request != null){
                Request.requestStatsHandler(this, request);
                //System.out.println("Time: " + currentTime + ", position: " + currentPosition + ", distance: " + distanceTraveled + ", REQUEST: " + request);
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
