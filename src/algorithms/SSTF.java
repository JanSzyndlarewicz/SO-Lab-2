package algorithms;

import next.Main;
import next.Request;

import java.util.ArrayList;

public class SSTF implements Algorithm{
    @Override
    public void doAlgorithm(ArrayList<Request> requests) {
        int currentPosition = 0;
        int distanceTraveled = 0;
        int requestCounter = 0;

        while (requestCounter<requests.size()){
            Request request = pickRequestWithTheShortestDistance(requests, distanceTraveled, currentPosition);

            //System.out.println(request);

            distanceTraveled += Math.abs(currentPosition-request.getDISC_POSITION());
            currentPosition = request.getDISC_POSITION();
            request.setWaitingTime(distanceTraveled - request.getENTRY_TIME());
            request.setExitTime(distanceTraveled);
            request.setDone(true);
            requestCounter++;
        }


    }

    private static Request pickRequestWithTheShortestDistance(ArrayList<Request> requests, int time, int currentPosition){
        Request bestRequestToPick = null;

        for (Request request : requests) {
            if((bestRequestToPick == null && !request.isDone()) ||
                    ((bestRequestToPick != null &&
                            !request.isDone() &&
                            Math.abs(request.getDISC_POSITION()-time)<Math.abs(bestRequestToPick.getDISC_POSITION()-time) &&
                            request.getENTRY_TIME()<=currentPosition)))
                bestRequestToPick = request;
        }

        return bestRequestToPick;
    }

    @Override
    public String getAlgorithmName() {
        return "SSTF";
    }
}
