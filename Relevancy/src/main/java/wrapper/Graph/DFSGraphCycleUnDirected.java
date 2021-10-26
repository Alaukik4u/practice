package wrapper.Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DFSGraphCycleUnDirected {
    int vertex;
    List<Integer>[] adjList;

    public DFSGraphCycleUnDirected(int vertex) {
        this.vertex = vertex;
        this.adjList = new LinkedList[vertex];

        for(int i=0; i<vertex; i++){
            this.adjList[i] = new LinkedList<Integer>();
        }
    }


    public void addEdge(int source, int target){
        this.adjList[source].add(target);
        this.adjList[target].add(source);
    }


    private boolean dfsUtlis() {
        boolean[] visited = new boolean[vertex];
        Arrays.fill(visited, false);

        for(int i=0; i<vertex; i++){
            if(!visited[i] && dfsCyclicUndirected(i, visited, -1)){
                return true;
            }
        }

        return false;
    }

    private boolean dfsCyclicUndirected(int startNode, boolean[] visited, int parent) {
        visited[startNode] = true;

        for(Integer nextnode : adjList[startNode]){
            if(!visited[nextnode]){
                if(dfsCyclicUndirected(nextnode, visited, startNode)){
                   return true;
                }
            }else if(parent != nextnode){
                return true;
            }
        }

        return false;
    }


    public static void main(String[] args) {
        DFSGraphCycleUnDirected dfsGraph = new DFSGraphCycleUnDirected(4);
        dfsGraph.addEdge(0,2);
        dfsGraph.addEdge(0,3);
        dfsGraph.addEdge(2,3);

        /*dfsGraph.addEdge(1,3);
        dfsGraph.addEdge(3,1);*/

        System.out.println("Present Cycle ===>"+dfsGraph.dfsUtlis());
    }
}
