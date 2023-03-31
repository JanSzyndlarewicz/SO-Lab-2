package next;

import algorithms.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Request> requests = Generator.generate(0,
                100,
                0,
                100,
                1000,
                200,
                3,
                10);

        Generator.sortByEntryTime(requests);
        Generator.printAllRequests(requests);

        Generator.startAllAlgorithms(requests);

    }
}