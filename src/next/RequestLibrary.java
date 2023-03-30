package next;

import java.util.ArrayList;

public class RequestLibrary {

    public static void clear(ArrayList<Request> requests){
        for (Request request : requests) {
            request.setExitTime(0);
            request.setWaitingTime(0);
            request.setDone(false);
        }
    }
}
