package algorithms;

import next.Request;
import java.util.ArrayList;

public abstract class Algorithm {
     int currentPosition = 0;
     int currentTime = 0;
     int distanceTraveled = 0;

    void doAlgorithm(ArrayList<Request> requests) {

    }

    String getAlgorithmName() {
        return null;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public int getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(int currentTime) {
        this.currentTime = currentTime;
    }

    public int getDistanceTraveled() {
        return distanceTraveled;
    }

    public void setDistanceTraveled(int distanceTraveled) {
        this.distanceTraveled = distanceTraveled;
    }
}
