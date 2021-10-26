package wrapper.Tree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class verticalSum {


    public static void main(String[] args) {
        Node root = new Node(1);
        root.setLeft(new Node(2));
        root.setRight(new Node(3));
        root.getLeft().setLeft(new Node(4));
        root.getLeft().setRight(new Node(5));
        root.getRight().setLeft(new Node(6));
        root.getRight().setRight(new Node(7));

        System.out.println("Following are the values of" +
                " vertical sums with the positions" +
                " of the columns with respect to root ");
        for(Map.Entry entry : VerticalSumMain(root).entrySet()){
            System.out.println(entry);
        }
    }


    private static Map<Integer, Integer> VerticalSumMain(Node root) {
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();

        if (root == null) {
            return map;
        }

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int sum = map.get(node.index) != null ? map.get(node.index) : 0;
            sum += node.key;
            map.put(node.index, sum);


            if (node.left != null) {
                int index = node.index - 1;
                node.left.index = index;
                queue.add(node.left);
            }

            if (node.right != null) {
                int index = node.index +1;
                node.right.index = index;
                queue.add(node.right);
            }

        }


        return map;
    }
}
