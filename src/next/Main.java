package next;

import algorithms.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Request> requests = new ArrayList<>();
        requests.add(new Request(false, 8, 3, 0));
        requests.add(new Request(true, 3, 3, 10));
        requests.add(new Request(false, 4, 4, 0));
        requests.add(new Request(true, 6, 4, 5));
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

        RequestLibrary.clear(requests);

        System.out.println();
        C_SCAN CScan = new C_SCAN();
        CScan.doAlgorithm(requests);
        for (Request request: requests) {
            System.out.println(request.getExitTime() + " " + request.getWaitingTime());
        }

        RequestLibrary.clear(requests);

        System.out.println();
        SCAN scan = new SCAN();
        scan.doAlgorithm(requests);
        for (Request request: requests) {
            System.out.println(request.getExitTime() + " " + request.getWaitingTime());
        }

        ArrayList<Request> requests2 = new ArrayList<>();
        requests2.add(new Request(true, 10, 0, 3));
        requests2.add(new Request(true, 5, 0, 2));
        requests2.add(new Request(true, 1, 0, 1));
        requests2.add(new Request(true, 8, 0, 5));
        requests2.add(new Request(true, 3, 0, 4));

        System.out.println();
        EDF edf = new EDF();
        edf.doAlgorithm(requests2);
        for (Request request: requests2) {
            System.out.println(request.getExitTime() + " " + request.getWaitingTime());
        }
    }
}