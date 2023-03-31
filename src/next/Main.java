package next;

import algorithms.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Request> requests = Generator.generate(0,
                100,
                0,
                50,
                30,
                10,
                3,
                10);

        Generator.sortByEntryTime(requests);
        Generator.printAllRequests(requests);




        /*requests.add(new Request(false, 3, 3, 0));
        requests.add(new Request(true, 5, 3, 10));
        requests.add(new Request(false, 4, 4, 0));
        requests.add(new Request(true, 6, 4, 5));
        requests.add(new Request(false, 3, 10, 0));

        FD_SCAN fd_scan = new FD_SCAN();
        fd_scan.doAlgorithm(requests, 0, 3, 0);

        for (Request request: requests) {
            System.out.println(request.getExitTime() + " " + request.getWaitingTime());
        }

        RequestLibrary.clear(requests);



        FCFS Fcfs = new FCFS();
        EDF edf = new EDF();
        Fcfs.doAlgorithm(requests, edf);

        for (Request request: requests) {
            System.out.println(request.getExitTime() + " " + request.getWaitingTime());
        }

        RequestLibrary.clear(requests);

        System.out.println();
        SSTF sstf = new SSTF();
        sstf.doAlgorithm(requests, edf);
        for (Request request: requests) {
            System.out.println(request.getExitTime() + " " + request.getWaitingTime());
        }

        RequestLibrary.clear(requests);

        System.out.println();
        C_SCAN CScan = new C_SCAN();
        CScan.doAlgorithm(requests, edf);
        for (Request request: requests) {
            System.out.println(request.getExitTime() + " " + request.getWaitingTime());
        }

        RequestLibrary.clear(requests);

        System.out.println();
        SCAN scan = new SCAN();
        scan.doAlgorithm(requests, edf);
        for (Request request: requests) {
            System.out.println(request.getExitTime() + " " + request.getWaitingTime());
        }
*/
    }
}