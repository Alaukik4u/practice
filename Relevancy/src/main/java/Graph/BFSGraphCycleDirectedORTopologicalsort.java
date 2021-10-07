package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSGraphCycleDirectedORTopologicalsort {
    int vertex;
    List<Integer>[] adjList;

    public BFSGraphCycleDirectedORTopologicalsort(int vertex) {
        this.vertex = vertex;
        this.adjList = new LinkedList[vertex];

        for(int i=0; i<vertex; i++){
            this.adjList[i] = new LinkedList<Integer>();
        }
    }


    public void addEdge(int source, int target){
        this.adjList[source].add(target);
    }



    private boolean bfsHasCycle() {
        int[] indegree = new int[vertex];
        Arrays.fill(indegree, 0);

        for(int i=0; i<vertex; i++){
            for(int node : adjList[i]){
                indegree[node]++;
            }
        }
        Queue<Integer> queue = new LinkedList<Integer>();


        for(int i=0; i<vertex; i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }

        int count =0;

        List<Integer> list = new ArrayList<Integer>();


        while(!queue.isEmpty()){
            int node = queue.poll();
            list.add(node);

            for(int i: adjList[node]){
                if(--indegree[i] ==0){
                    queue.add(i);
                }
            }
            count++;
        }

        if(count != vertex){
            return true;
        }

        for (int i: list){
            System.out.print(i + " ");
        }
        System.out.println();

        return false;
    }


    public static void main(String[] args) {
        BFSGraphCycleDirectedORTopologicalsort bfsGraph = new BFSGraphCycleDirectedORTopologicalsort(4);
        bfsGraph.addEdge(0,2);
        bfsGraph.addEdge(2,1);
        bfsGraph.addEdge(3,1);

        System.out.println(bfsGraph.bfsHasCycle());
    }
}
