package algorithms;


import next.Request;

import java.util.ArrayList;

public class FD_SCAN extends RealTimeAlgorithm{

    public FD_SCAN(){}

    public FD_SCAN(int currentPosition, int currentTime, int distanceTraveled) {
        super(currentPosition, currentTime, distanceTraveled);
    }

    @Override
    public void doAlgorithm(ArrayList<Request> requests, int currentPosition, int currentTime, int distanceTraveled) {
        this.currentPosition = currentPosition;
        this.currentTime = currentTime;
        this.distanceTraveled = distanceTraveled;
        Request request;

        do{
            request = pickClosestToReachDeadline(requests, this.currentTime, this.currentPosition);

            if(request != null){
                Request staticRequest;
                do{

                    staticRequest = pickNextInCurrentDirection(requests, request, this.currentTime, this.currentPosition);

                    if(staticRequest != null){
                        Request.requestStatsHandler(this, staticRequest);
                    }
                }while (staticRequest != null);

                Request.requestStatsHandler(this, request);
            }

        }while (request != null);
    }

    private static Request pickClosestToReachDeadline(ArrayList<Request> requests, int currentTime, int currentPosition){
        Request closestToReachDeadline = null;

        for (Request request: requests) {
            if(closestToReachDeadline == null && !request.isDone() && request.isPRIORITY() && currentTime >= request.getENTRY_TIME()){
                closestToReachDeadline = request;
            }
            else if(closestToReachDeadline != null &&
                    request.isPRIORITY() &&
                    !request.isDone() &&
                    Math.abs(closestToReachDeadline.getDISC_POSITION()-currentPosition) > Math.abs(request.getDISC_POSITION()-currentPosition) &&
                    request.getENTRY_TIME() <= currentTime)
                closestToReachDeadline = request;
        }

        return closestToReachDeadline;
    }

    private static Request pickNextInCurrentDirection(ArrayList<Request> requests, Request priorityRequest, int currentTime, int currentPosition){
        Request nextInCurrentDirection = null;

        for (Request request: requests) {
            if(nextInCurrentDirection == null &&
                    !request.isDone() &&
                    !request.isPRIORITY() &&
                    (priorityRequest.getDISC_POSITION() - currentPosition) * (request.getDISC_POSITION() - currentPosition) >= 0 &&
                    Math.abs(priorityRequest.getDISC_POSITION() - currentPosition) >= Math.abs(request.getDISC_POSITION() - currentPosition) &&
                    currentTime >= request.getENTRY_TIME()){
                nextInCurrentDirection = request;
            }
            else if(nextInCurrentDirection != null &&
                    !request.isPRIORITY() &&
                    !request.isDone() &&
                    Math.abs(nextInCurrentDirection.getDISC_POSITION()-currentPosition) > Math.abs(request.getDISC_POSITION()-currentPosition) &&
                    (priorityRequest.getDISC_POSITION() - currentPosition) * (request.getDISC_POSITION() - currentPosition) >= 0 &&
                    Math.abs(priorityRequest.getDISC_POSITION() - currentPosition) >= Math.abs(request.getDISC_POSITION() - currentPosition)&&
                    request.getENTRY_TIME() <= currentTime)
                nextInCurrentDirection = request;
        }

        return nextInCurrentDirection;
    }


    @Override
    public String getAlgorithmName() {
        return "FD-SCAN";
    }

}
