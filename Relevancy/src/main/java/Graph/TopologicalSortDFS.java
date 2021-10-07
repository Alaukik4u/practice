package Graph;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TopologicalSortDFS {
    int vertex;
    List<Integer>[] adjList;

    public TopologicalSortDFS(int vertex) {
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

        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0; i<vertex; i++){
            if(!visited[i]){
                topologicalSort(i, visited, stack);
            }
        }


        while(!stack.empty()){
            System.out.print(stack.pop()+" ");
        }
        System.out.println();
    }

    private void topologicalSort(int startNode, boolean[] visited, Stack<Integer> stack) {
        visited[startNode] = true;

       for(int nextNode : adjList[startNode]){
           if(!visited[nextNode]){
               topologicalSort(nextNode, visited, stack);
           }
       }

       stack.push(startNode);
    }


    public static void main(String[] args) {
        TopologicalSortDFS dfsGraph = new TopologicalSortDFS(4);
        dfsGraph.addEdge(0,2);
        dfsGraph.addEdge(0,3);
        dfsGraph.addEdge(2,3);

        dfsGraph.addEdge(1,3);

        dfsGraph.dfsUtils();
    }
}
