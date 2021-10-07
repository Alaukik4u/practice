package Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DFSGraphCycleDirected {
    int vertex;
    List<Integer>[] adjList;

    public DFSGraphCycleDirected(int vertex) {
        this.vertex = vertex;
        this.adjList = new LinkedList[vertex];

        for(int i=0; i<vertex; i++){
            this.adjList[i] = new LinkedList<Integer>();
        }
    }


    public void addEdge(int source, int target){
        this.adjList[source].add(target);
    }


    private boolean dfsUtlis() {
        boolean[] visited = new boolean[vertex];
        Arrays.fill(visited, false);

        boolean[] recstack = new boolean[vertex];
        Arrays.fill(visited, false);

        for(int i=0; i<vertex; i++){
            if(!visited[i] && dfsCyclicDirected(i, visited, recstack)){
                return true;
            }
        }

        return false;
    }

    private boolean dfsCyclicDirected(int startNode, boolean[] visited, boolean[] stack) {
        if(stack[startNode]){
            return true;
        }

        if(visited[startNode])
            return false;

        visited[startNode] = true;
        stack[startNode] = true;

        for(Integer nextNode: adjList[startNode]){
            if(dfsCyclicDirected(nextNode, visited, stack)){
                return true;
            }

        }

        stack[startNode] = false;

        return false;
    }


    public static void main(String[] args) {
        DFSGraphCycleDirected dfsGraph = new DFSGraphCycleDirected(4);
        dfsGraph.addEdge(0,2);
        dfsGraph.addEdge(0,3);
        dfsGraph.addEdge(2,3);
        dfsGraph.addEdge(1,3);
        dfsGraph.addEdge(3,1);
        System.out.println("Present Cycle ===>"+dfsGraph.dfsUtlis());
    }
}
