package algorithms;

import next.Request;
import java.util.ArrayList;

public interface Algorithm {

    void doAlgorithm(ArrayList<Request> requests);
    String getAlgorithmName();
}
