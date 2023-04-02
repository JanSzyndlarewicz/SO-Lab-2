package requests;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        final int TIME_LEFT_RANGE = 0;
        final int TIME_RIGHT_RANGE = 10000;
        final int POSITION_LEFT_RANGE = 0;
        final int POSITION_RIGHT_RANGE = 100;
        final int NUMBER_OF_NORMAL_REQUESTS = 1000;
        final int NUMBER_OF_PRIORITY_REQUESTS = 50;
        final int DEADLINE_LEFT_RANGE = 1;
        final int DEADLINE_RIGHT_RANGE = 500;

        ArrayList<Request> requests = Generator.generate(
                TIME_LEFT_RANGE,
                TIME_RIGHT_RANGE,
                POSITION_LEFT_RANGE,
                POSITION_RIGHT_RANGE,
                NUMBER_OF_NORMAL_REQUESTS,
                NUMBER_OF_PRIORITY_REQUESTS,
                DEADLINE_LEFT_RANGE,
                DEADLINE_RIGHT_RANGE);

        Generator.sortByEntryTime(requests);
        //Generator.printAllRequests(requests);

        Generator.startAllAlgorithms(requests, POSITION_RIGHT_RANGE);

    }
}