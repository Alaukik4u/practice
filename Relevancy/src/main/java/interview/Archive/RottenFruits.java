package interview.Archive;

/*  **************** ZETA **************************

Given a mxn matrix, with the following values
0 representing an empty cell,
1 representing a fresh fruit, or
2 representing a rotten fruit.
    Every minute, any fresh fruit adjacent to rotten one gets rotten

    Find minimum number of time taken to rot all the fruits

        [2,1,1]
        [1,0,0]
        [0,1,2]

    ans : 4*/

import java.util.LinkedList;
import java.util.Queue;

public class RottenFruits {

    static int count = 0;


    public static void main(String[] args) {
        int[][] matrix = {  {2, 1, 0, 2, 1},
                            {1, 0, 1, 2, 1},
                            {1, 0, 0, 2, 1}};

        System.out.println("Time to rot all fruits :: " + timeToRotAllFruits(matrix));
    }

    private static int timeToRotAllFruits(int[][] matrix) {
        Queue<Node> queue = new LinkedList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 2) {
                    queue.add(new Node(i, j));
                }
            }
        }
        queue.add(null);
        bfsTimeToRotAllFruits(matrix, queue);


        return count-1;
    }

    private static int bfsTimeToRotAllFruits(int[][] matrix, Queue<Node> queue) {

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node != null) {
                matrix[node.i][node.j] = 0;
                if (node.i-1 >= 0 && node.j >= 0 && node.j < matrix[0].length && (node.i -1) < matrix.length && matrix[node.i-1][node.j] ==1) {
                    queue.add(new Node(node.i - 1, node.j));
                }

                if (node.i+1 >= 0 && node.j >= 0 && node.j < matrix[0].length && (node.i+1) < matrix.length && matrix[node.i+1][node.j] ==1) {
                    queue.add(new Node(node.i + 1, node.j));
                }


                if (node.i >= 0 && node.j- 1 >= 0 && node.j - 1 < matrix[0].length && node.i < matrix.length && matrix[node.i][node.j-1] ==1) {
                    queue.add(new Node(node.i, node.j - 1));
                }

                if (node.i >= 0 && node.j + 1 >= 0 && node.j + 1 < matrix[0].length && (node.i) < matrix.length && matrix[node.i][node.j+1] ==1) {
                    queue.add(new Node(node.i, node.j + 1));
                }

            } else {
                count++;
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
            }

        }

        return count;
    }
}


class Node {
    int i, j;

    public Node(int i, int j) {
        this.i = i;
        this.j = j;
    }
}