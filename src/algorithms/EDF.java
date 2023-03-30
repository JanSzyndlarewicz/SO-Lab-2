package algorithms;

import next.Request;

import java.util.ArrayList;

public class EDF extends Algorithm{

    @Override
    public void doAlgorithm(ArrayList<Request> requests) {
        Request request;

        do{
            request = pickEarliestDeadline(requests, currentTime, currentPosition);

            if(request != null){
                Request.requestStatsHandler(this, request);
                //System.out.println("Time: " + currentTime + ", position: " + currentPosition + ", distance: " + distanceTraveled + ", REQUEST: " + request);
            }

        }while (request != null);
    }

    private static Request pickEarliestDeadline(ArrayList<Request> requests, int currentTime, int currentPosition){
        Request requestWithClosestDeadline = null;

        for (Request request: requests) {
            if(requestWithClosestDeadline == null && !request.isDone() && request.isPRIORITY() && currentTime >= request.getENTRY_TIME()){
                requestWithClosestDeadline = request;
            }
            else if(requestWithClosestDeadline != null &&
                    request.isPRIORITY() &&
                    !request.isDone() &&
                    requestWithClosestDeadline.getDEADLINE() > request.getDEADLINE() &&
                    request.getENTRY_TIME() <= currentTime)
                requestWithClosestDeadline = request;
        }

        return requestWithClosestDeadline;
    }


    @Override
    public String getAlgorithmName() {
        return "EDF";
    }
}
