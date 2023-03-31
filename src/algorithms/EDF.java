package algorithms;

import next.Request;

import java.util.ArrayList;

public class EDF extends RealTimeAlgorithm {

    public EDF(){}

    public EDF(int currentPosition, int currentTime, int distanceTraveled) {
        super(currentPosition, currentTime, distanceTraveled);
    }

    @Override
    public void doAlgorithm(ArrayList<Request> requests, int currentPosition, int currentTime, int distanceTraveled) {
        this.currentPosition = currentPosition;
        this.currentTime = currentTime;
        this.distanceTraveled = distanceTraveled;
        Request request;

        do{
            request = pickEarliestDeadline(requests, this.currentTime);
            if(request != null) Request.requestStatsHandler(this, request);

        }while (request != null);
    }

    private static Request pickEarliestDeadline(ArrayList<Request> requests, int currentTime){
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
