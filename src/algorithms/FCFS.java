package algorithms;

import algorithms.Algorithm;
import next.Request;

import java.util.ArrayList;

public class FCFS implements Algorithm {

    @Override
    public void doAlgorithm(ArrayList<Request> requests) {
        int currentPosition = 0;
        int distanceTraveled = 0;

        for (Request request: requests) {
            distanceTraveled += Math.abs(currentPosition-request.getDISC_POSITION());
            currentPosition = request.getDISC_POSITION();
            request.setWaitingTime(distanceTraveled - request.getENTRY_TIME());
            request.setExitTime(distanceTraveled);
            request.setDone(true);
        }
    }

    @Override
    public String getAlgorithmName() {
        return "algorithms.FCFS";
    }
}
