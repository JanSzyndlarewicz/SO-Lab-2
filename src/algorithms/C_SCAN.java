package algorithms;

import next.Request;

import java.util.ArrayList;

public class C_SCAN extends Algorithm{

    @Override
    public void doAlgorithm(ArrayList<Request> requests) {
        int requestCounter = 0;
        int RANGE = 10;

        while (requestCounter < requests.size()){
            Request request = findClosestOnTheRight(requests, currentTime, currentPosition);

            if(request != null){
                Request.requestStatsHandler(this, request);
                requestCounter++;
            }
            else {
                currentTime++;
                currentPosition++;
                if(currentPosition > RANGE){
                    currentPosition = 0;
                    currentTime += RANGE-1;
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
                            request.getENTRY_TIME()<=currentTime)))
                closestOnTheRight = request;
        }

        return closestOnTheRight;
    }

    @Override
    public String getAlgorithmName() {
        return "C-SCAN";
    }
}
