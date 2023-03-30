

import java.util.ArrayList;

public class FCFS implements Algorithm {

    @Override
    public void doAlgorithm(ArrayList<Request> requests) {
        int currentPosition = 0;
        for (Request request: requests) {
            currentPosition += Math.abs(currentPosition-request.getDISC_POSITION());
            request.setWaitingTime(currentPosition - request.getENTRY_TIME());
            request.setExitTime(currentPosition);
        }
    }

    @Override
    public String getAlgorithmName() {
        return "FCFS";
    }
}
