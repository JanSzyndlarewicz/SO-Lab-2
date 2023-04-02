package requests;

import algorithms.*;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

public abstract class Generator {

    public static ArrayList<Request> generate(int timeLeftRange,
                                              int timeRightRange,
                                              int positionLeftRange,
                                              int positionRightRange,
                                              int numberOfNormalRequests,
                                              int numberOfPriorityRequests,
                                              int deadlineLeftRange,
                                              int deadlineRightRange){
        Random random = new Random();
        ArrayList<Request> generatedRequests = new ArrayList<>();

        for(int i=0; i<numberOfNormalRequests; i++){
            generatedRequests.add(new Request(false,
                    random.nextInt(positionLeftRange, positionRightRange),
                    random.nextInt(timeLeftRange, timeRightRange),
                    0));
        }

        for(int i=0; i<numberOfPriorityRequests; i++){
            int entryTime = random.nextInt(timeLeftRange, timeRightRange);
            generatedRequests.add(new Request(true,
                    random.nextInt(positionLeftRange, positionRightRange),
                    entryTime,
                    entryTime + random.nextInt(deadlineLeftRange, deadlineRightRange)));
        }

        return generatedRequests;
    }

    public static void sortByEntryTime(ArrayList<Request> requests){
        for(int i=0; i<requests.size(); i++){
            for(int j=i+1; j<requests.size(); j++){
                if(requests.get(i).getENTRY_TIME() > requests.get(j).getENTRY_TIME()){
                    swap(requests, i, j);
                }
            }
        }
    }

    public static void printAllRequests(ArrayList<Request> requests){
        for (Request request: requests) {
            System.out.println(request);
        }
    }

    private static void swap(ArrayList<Request> requests, int request1, int request2){
        Request tmp = requests.get(request1);
        requests.set(request1, requests.get(request2));
        requests.set(request2, tmp);
    }

    public static void printStats(ArrayList<Request> requests){
        final DecimalFormat df = new DecimalFormat("0.00");
        double avgExitTime = 0;
        double avgWaitingTime = 0;

        for (Request request: requests) {
            avgExitTime += request.getExitTime();
            avgWaitingTime += request.getWaitingTime();
        }

        avgExitTime /= requests.size();
        avgWaitingTime /= requests.size();

        System.out.printf( "Avg Exit Time: " +  df.format(avgExitTime) + ", Avg Waiting Time: " + df.format(avgWaitingTime) + "\n");
    }

    public static void startAllAlgorithms(ArrayList<Request> requests, int range){
        StaticAlgorithm[] staticAlgorithms = new StaticAlgorithm[4];
        staticAlgorithms[0] = new FCFS();
        staticAlgorithms[1] = new SSTF();
        staticAlgorithms[2] = new C_SCAN();
        staticAlgorithms[3] = new SCAN();

        RealTimeAlgorithm[] realTimeAlgorithms = new RealTimeAlgorithm[2];
        realTimeAlgorithms[0] = new EDF();
        realTimeAlgorithms[1] = new FD_SCAN();

        for (StaticAlgorithm staticAlgorithm : staticAlgorithms) {
            for (RealTimeAlgorithm realTimeAlgorithm : realTimeAlgorithms) {
                staticAlgorithm.doAlgorithm(requests, realTimeAlgorithm, range);
                System.out.print(staticAlgorithm.getAlgorithmName() + " & " + realTimeAlgorithm.getAlgorithmName() + " -> ");
                printStats(requests);
                Request.clear(requests);
                staticAlgorithm.clearParameters();
            }
        }
    }
}
