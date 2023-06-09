package requests;

import algorithms.Algorithm;
import algorithms.RealTimeAlgorithm;
import algorithms.StaticAlgorithm;

import java.util.ArrayList;

public class Request{

    private static int IdCounter = 0;
    private final int ID;
    private final boolean PRIORITY;
    private final int DISC_POSITION;
    private final int ENTRY_TIME;
    private final int DEADLINE;
    private int exitTime;
    private int waitingTime;
    private boolean isDone;

    public Request(boolean PRIORITY,
                   int DISC_POSITION,
                   int ENTRY_TIME,
                   int DEADLINE) {
        this.ID = IdCounter;
        this.PRIORITY = PRIORITY;
        this.DISC_POSITION = DISC_POSITION;
        this.ENTRY_TIME = ENTRY_TIME;
        this.DEADLINE = DEADLINE;
        this.exitTime = 0;
        this.waitingTime = 0;
        this.isDone = false;

        IdCounter++;
    }

    public static void requestStatsHandler(Algorithm algorithm, Request request){

        algorithm.setCurrentTime(algorithm.getCurrentTime() + Math.abs(algorithm.getCurrentPosition()-request.getDISC_POSITION()));
        algorithm.setDistanceTraveled(algorithm.getDistanceTraveled() + Math.abs(algorithm.getCurrentPosition()-request.getDISC_POSITION()));
        algorithm.setCurrentPosition(request.getDISC_POSITION());

        request.setWaitingTime(algorithm.getCurrentTime() - request.getENTRY_TIME());
        request.setExitTime(algorithm.getCurrentTime());
        request.setDone(true);

    }

    public static boolean isPriority(ArrayList<Request> requests, int currentTime){
        for (Request request: requests)
            if(request.isPRIORITY() && !request.isDone() && request.getENTRY_TIME() <= currentTime){

                return true;
            }

        return false;
    }

    public static void priorityHandler(ArrayList<Request> requests, StaticAlgorithm staticAlgorithm, RealTimeAlgorithm realTimeAlgorithm){
        if(Request.isPriority(requests, staticAlgorithm.getCurrentTime())){
            realTimeAlgorithm.doAlgorithm(requests, staticAlgorithm.getCurrentPosition(), staticAlgorithm.getCurrentTime(), staticAlgorithm.getDistanceTraveled());
            staticAlgorithm.setCurrentPosition(realTimeAlgorithm.getCurrentPosition());
            staticAlgorithm.setCurrentTime(realTimeAlgorithm.getCurrentTime());
            staticAlgorithm.setDistanceTraveled(realTimeAlgorithm.getDistanceTraveled());
        }
    }

    public static void clear(ArrayList<Request> requests){
        for (Request request : requests) {
            request.setExitTime(0);
            request.setWaitingTime(0);
            request.setDone(false);
        }
    }


    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public static int getIdCounter() {
        return IdCounter;
    }

    public static void setIdCounter(int idCounter) {
        IdCounter = idCounter;
    }

    public int getID() {
        return ID;
    }

    public int getENTRY_TIME() {
        return ENTRY_TIME;
    }

    public boolean isPRIORITY() {
        return PRIORITY;
    }

    public int getDISC_POSITION() {
        return DISC_POSITION;
    }

    public int getDEADLINE() {
        return DEADLINE;
    }

    public int getExitTime() {
        return exitTime;
    }

    public void setExitTime(int exitTime) {
        this.exitTime = exitTime;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }



    @Override
    public String toString() {
        return "Request{" +
                "ID=" + ID +
                ", PRIORITY=" + PRIORITY +
                ", DISC_POSITION=" + DISC_POSITION +
                ", ENTRY_TIME=" + ENTRY_TIME +
                ", DEADLINE=" + DEADLINE +
                ", exitTime=" + exitTime +
                ", waitingTime=" + waitingTime +
                ", isDone=" + isDone +
                '}';
    }
}
