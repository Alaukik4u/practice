package Graph;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSGraph {
    int vertex;
    List<Integer>[] adjList;

    public BFSGraph(int vertex) {
        this.vertex = vertex;
        this.adjList = new LinkedList[vertex];

        for(int i=0; i<vertex; i++){
            this.adjList[i] = new LinkedList<Integer>();
        }
    }


    public void addEdge(int source, int target){
        this.adjList[source].add(target);
    }


    private void bfsUtlis(int startNode) {
        boolean[] visited = new boolean[vertex];
        Arrays.fill(visited, false);

        bfs(startNode, visited);

        for(int i=0; i<vertex; i++){
            if(!visited[i]){
                bfs(i, visited);
            }

        }
    }

    private void bfs(int startNode, boolean[] visited) {
       Queue<Integer> queue = new LinkedList<Integer>();
       queue.add(startNode);
       visited[startNode]=true;

        while(!queue.isEmpty()){
            Integer nextNode = queue.poll();
            System.out.println(nextNode);

            Iterator<Integer> iterator = adjList[nextNode].listIterator();

            while(iterator.hasNext()){
                Integer next = iterator.next();
                if(!visited[next]){
                    queue.add(next);
                    visited[next]=true;
                }
            }
        }
    }


    public static void main(String[] args) {
        BFSGraph bfsGraph = new BFSGraph(4);
        bfsGraph.addEdge(0,2);
        bfsGraph.addEdge(2,1);
        bfsGraph.addEdge(3,3);

        bfsGraph.bfsUtlis(0);
    }
}
