package next;

import algorithms.FCFS;
import algorithms.SSTF;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Request> requests = new ArrayList<>();
        requests.add(new Request(false, 3, 0, 0));
        requests.add(new Request(false, 5, 1, 0));
        requests.add(new Request(false, 1, 3, 0));
        requests.add(new Request(false, 8, 3, 0));
        requests.add(new Request(false, 3, 5, 0));

        FCFS Fcfs = new FCFS();
        Fcfs.doAlgorithm(requests);

        for (Request request: requests) {
            System.out.println(request.getExitTime() + " " + request.getWaitingTime());
        }

        RequestLibrary.clear(requests);

        System.out.println();
        SSTF sstf = new SSTF();
        sstf.doAlgorithm(requests);
        for (Request request: requests) {
            System.out.println(request.getExitTime() + " " + request.getWaitingTime());
        }
    }
}