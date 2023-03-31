package algorithms;

import requests.Request;

import java.util.ArrayList;

public abstract class RealTimeAlgorithm extends Algorithm{

    public RealTimeAlgorithm(int currentPosition, int currentTime, int distanceTraveled) {
        super(currentPosition, currentTime, distanceTraveled);
    }

    public RealTimeAlgorithm() {}

    public abstract void doAlgorithm(ArrayList<Request> requests, int currentPosition, int currentTime, int distanceTraveled);

    public abstract String getAlgorithmName();




}
