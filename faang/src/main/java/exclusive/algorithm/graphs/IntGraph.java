package exclusive.algorithm.graphs;

import java.util.LinkedList;
import java.util.Queue;


public class IntGraph {

    private final int noOfVertex;
    private final LinkedList<Integer>[] integerGraph;


    public IntGraph(int noOfVertex){
        this.noOfVertex = noOfVertex;
        integerGraph = new LinkedList[noOfVertex];
        for(int i = 0; i < noOfVertex; i++){
            integerGraph[i] =  new LinkedList<>();
        }
    }

    public void addEdge(int vertex, int node){
        integerGraph[vertex].add(node);
    }

    public void traversalBFS(int node){
        boolean[] visited = new boolean[noOfVertex];
        Queue<Integer> queue = new LinkedList<>();

        visited[node] = true;
        queue.add(node);

        while (!queue.isEmpty()){
            node = queue.poll();
            System.out.print(node + " ");
            for (int temp : integerGraph[node]) {
                if (!visited[temp]) {
                    visited[temp] = true;
                    queue.add(temp);
                }
            }
        }
    }

    public void DFS(int node){
        boolean[] visited = new boolean[noOfVertex];
        traversalDFS(node, visited);
    }

    public void traversalDFS(int node, boolean[] visited){
        visited[node] = true;
        System.out.print(node + " ");
        for (int temp : integerGraph[node]) {
            if(!visited[temp]){
                traversalDFS(temp, visited);
            }
        }
    }

    public static void main(String[] args) {
        IntGraph intGraph = new IntGraph(9);
        intGraph.addEdge(0,1);
        intGraph.addEdge(0,3);
        intGraph.addEdge(1,0);
        intGraph.addEdge(2,3);
        intGraph.addEdge(2,8);
        intGraph.addEdge(3,0);
        intGraph.addEdge(3,2);
        intGraph.addEdge(3,5);
        intGraph.addEdge(3,4);
        intGraph.addEdge(4,3);
        intGraph.addEdge(4,6);
        intGraph.addEdge(5,3);
        intGraph.addEdge(6,4);
        intGraph.addEdge(6,7);
        intGraph.addEdge(7,6);
        intGraph.addEdge(8,2);

        System.out.println(
                "Following is Breadth First Traversal "
                        + "(starting from vertex 2)");
        intGraph.DFS(2);
    }
}
