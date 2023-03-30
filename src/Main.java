import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Request> requests = new ArrayList<>();
        requests.add(new Request(false, 3, 0, 0));
        requests.add(new Request(false, 5, 0, 0));
        requests.add(new Request(false, 1, 0, 0));
        requests.add(new Request(false, 8, 0, 0));
        requests.add(new Request(false, 3, 0, 0));

        for (Request request: requests) {
            System.out.println(request.getExitTime() + " " + request.getWaitingTime());

        }
    }
}