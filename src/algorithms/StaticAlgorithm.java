package algorithms;

import next.Request;

import java.util.ArrayList;

public abstract class StaticAlgorithm extends Algorithm{

    public StaticAlgorithm() {
    }

    public StaticAlgorithm(int currentPosition, int currentTime, int distanceTraveled) {
        super(currentPosition, currentTime, distanceTraveled);
    }

    public abstract void doAlgorithm(ArrayList<Request> requests, RealTimeAlgorithm realTimeAlgorithm);
}
