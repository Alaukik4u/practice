package wrapper.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class RightView {
    Node root;

    public static void main(String args[])
    {
        /* creating a binary tree and entering the nodes */
        RightView tree = new RightView();
        tree.root = new Node(12);
        tree.root.left = new Node(10);
        tree.root.right = new Node(30);
        tree.root.right.left = new Node(25);
        tree.root.right.right = new Node(40);

        tree.rightView(tree.root);
    }

    private void rightView(Node root) {
        if(root == null){
            return;
        }

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){

                Node node = queue.poll();
                if(i==size-1){
                    System.out.println(node.key);
                }

                if(node.left != null){
                    queue.add(node.left);
                }

                if(node.right != null){
                    queue.add(node.right);
                }
            }
        }

    }
}
