package algorithms;

import next.Request;

import java.util.ArrayList;

public class FCFS extends StaticAlgorithm {

    public FCFS(){}

    public FCFS(int currentPosition, int currentTime, int distanceTraveled) {
        super(currentPosition, currentTime, distanceTraveled);
    }

    @Override
    public void doAlgorithm(ArrayList<Request> requests, RealTimeAlgorithm realTimeAlgorithm) {

        for (Request request: requests) {

            Request.priorityHandler(requests, this, realTimeAlgorithm);

            if(!request.isDone()){
                if(currentTime<request.getENTRY_TIME())
                    currentTime = request.getENTRY_TIME();

                Request.requestStatsHandler(this, request);
            }
        }
    }


    @Override
    public String getAlgorithmName() {
        return "FCFS";
    }
}
