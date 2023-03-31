package next;

import java.util.ArrayList;
import java.util.Random;

public class Generator {

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
}
