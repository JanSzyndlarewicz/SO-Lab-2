package algorithms;



public abstract class Algorithm {
     int currentPosition = 0;
     int currentTime = 0;
     int distanceTraveled = 0;

    public Algorithm() {
    }

    public Algorithm(int currentPosition, int currentTime, int distanceTraveled) {
        this.currentPosition = currentPosition;
        this.currentTime = currentTime;
        this.distanceTraveled = distanceTraveled;
    }

    public void clearParameters(){
        currentPosition = 0;
        currentTime = 0;
        distanceTraveled = 0;
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
