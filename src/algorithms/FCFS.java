package algorithms;

import next.Request;

import java.util.ArrayList;

public class FCFS extends Algorithm {

    public FCFS(){

    }

    public FCFS(int currentPosition, int currentTime, int distanceTraveled) {
        super(currentPosition, currentTime, distanceTraveled);
    }

    @Override
    public void doAlgorithm(ArrayList<Request> requests) {

        for (Request request: requests) {
            if(isPriority(requests, currentTime)){
                EDF edf = new EDF(currentPosition, currentTime, distanceTraveled);
                edf.doAlgorithm(requests);
                currentPosition = edf.getCurrentPosition();
                currentTime = edf.getCurrentTime();
                distanceTraveled = edf.getDistanceTraveled();
                System.out.println("fdsf");
            }

            if(!request.isDone()){
                if(currentTime<request.getENTRY_TIME())
                    currentTime = request.getENTRY_TIME();

                Request.requestStatsHandler(this, request);
                request.setDone(true);
            }

        }
    }

    public static boolean isPriority(ArrayList<Request> requests, int currentTime){

        for (Request request: requests)
            if(request.isPRIORITY() && !request.isDone() && request.getENTRY_TIME() <= currentTime) return true;

        return false;
    }


    @Override
    public String getAlgorithmName() {
        return "FCFS";
    }
}
