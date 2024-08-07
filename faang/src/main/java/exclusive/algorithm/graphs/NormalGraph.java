package exclusive.algorithm.graphs;

import java.util.LinkedList;

public class NormalGraph {

    public LinkedList<Integer>[] dependent;

    public NormalGraph(int vertex){
        dependent = new LinkedList[vertex];
        for(int i =0; i < vertex; i++){
            dependent[i] = new LinkedList<Integer>();
        }
    }
}
