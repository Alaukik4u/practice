package Graph;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSGraphCycleUnDirected {
    int vertex;
    List<Integer>[] adjList;

    public BFSGraphCycleUnDirected(int vertex) {
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


    private boolean bfsUtlis() {
        boolean[] visited = new boolean[vertex];
        Arrays.fill(visited, false);

        int[] parent = new int[vertex];
        Arrays.fill(parent, -1);

        for(int i=0; i<vertex; i++){
            if(!visited[i] && bfsHasCycleUndirected(i, visited, parent)){
                return true;
            }

        }
        return false;
    }

    private boolean bfsHasCycleUndirected(int startNode, boolean[] visited, int[] parent) {
       Queue<Integer> queue = new LinkedList<Integer>();
       queue.add(startNode);
       visited[startNode]=true;

        while(!queue.isEmpty()){
            Integer nextNode = queue.poll();

            for(int next : adjList[nextNode]){
                if(!visited[next]){
                    queue.add(next);
                    visited[next]=true;
                    parent[next] = nextNode;
                }else if(parent[nextNode] != next) {
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        BFSGraphCycleUnDirected bfsGraph = new BFSGraphCycleUnDirected(4);
        bfsGraph.addEdge(0,2);
        bfsGraph.addEdge(3,1);
        bfsGraph.addEdge(1,3);


        System.out.println(bfsGraph.bfsUtlis());
    }
}
