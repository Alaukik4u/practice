package Graph;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DFSGraph {
    int vertex;
    List<Integer>[] adjList;

    public DFSGraph(int vertex) {
        this.vertex = vertex;
        this.adjList = new LinkedList[vertex];

        for(int i=0; i<vertex; i++){
            this.adjList[i] = new LinkedList<Integer>();
        }
    }


    public void addEdge(int source, int target){
        this.adjList[source].add(target);
    }


    private void dfsUtils() {
        boolean[] visited = new boolean[vertex];
        Arrays.fill(visited, false);
        for(int i=0; i<vertex; i++){
            if(!visited[i]){
                dfs(i, visited);
            }

        }
    }

    private void dfs(int startNode, boolean[] visited) {
        visited[startNode] = true;
        System.out.println(startNode);

        Iterator<Integer> list = adjList[startNode].listIterator();

        while(list.hasNext()){
            int nextNode = list.next();

            if(!visited[nextNode]){
                dfs(nextNode, visited);
            }
        }
    }


    public static void main(String[] args) {
        DFSGraph dfsGraph = new DFSGraph(4);
        dfsGraph.addEdge(0,2);
        dfsGraph.addEdge(0,3);
        dfsGraph.addEdge(2,3);

        dfsGraph.addEdge(1,3);

        dfsGraph.dfsUtils();
    }
}
