package wrapper.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class spiralForm {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.setLeft(new Node(2));
        root.setRight(new Node(3));
        root.getLeft().setLeft(new Node(4));
        root.getLeft().setRight(new Node(5));
        root.getRight().setLeft(new Node(6));
        root.getRight().setRight(new Node(7));

        spiralorder(root);
    }

    private static void spiralorder(Node root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> currentList = new ArrayList<Integer>();

        boolean leftoright = false;

        if (root == null) {
            System.out.println("Empty tree");
            return;
        }

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        queue.add(null);


        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node != null) {
                currentList.add(node.key);
                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            } else {
                if (leftoright) {
                    result.add(new ArrayList<Integer>(currentList));
                    currentList.clear();
                } else {
                    Collections.reverse(currentList);
                    result.add(new ArrayList<Integer>(currentList));
                    currentList.clear();
                }

                if (!queue.isEmpty()) {
                    queue.add(null);
                    leftoright = !leftoright;
                }
            }

        }


        for (List<Integer> list : result) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }


}
