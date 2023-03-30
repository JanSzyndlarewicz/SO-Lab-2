package algorithms;

import next.Request;

import java.util.ArrayList;

public class FCFS extends Algorithm {

    @Override
    public void doAlgorithm(ArrayList<Request> requests) {

        for (Request request: requests) {
            if(currentTime<request.getENTRY_TIME())
                currentTime = request.getENTRY_TIME();
            Request.requestStatsHandler(this, request);
            request.setDone(true);
        }
    }

    @Override
    public String getAlgorithmName() {
        return "algorithms.FCFS";
    }
}
