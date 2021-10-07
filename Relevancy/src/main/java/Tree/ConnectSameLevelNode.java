package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectSameLevelNode {
    Node root; 
    
    
    
    public static void main(String[] args) {
        ConnectSameLevelNode tree = new ConnectSameLevelNode();
 
        /* Constructed binary tree is
             10
            /  \
          8     2
         / \
        3   5
        */
        tree.root = new Node(10);
        tree.root.left = new Node(8);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(5);

        // Populates nextRight pointer in all nodes
        tree.connect(tree.root);

        // Let us check the values of nextRight pointers
        System.out.println("Following are populated nextRight pointers in "
                + "the tree"
                + "(-1 is printed if there is no nextRight)");
        int a = tree.root.nextRight != null ? tree.root.nextRight.key : -1;
        System.out.println("nextRight of " + tree.root.key + " is "
                + a);
        int b = tree.root.left.nextRight != null ? tree.root.left.nextRight.key : -1;
        System.out.println("nextRight of " + tree.root.left.key + " is "
                + b);
        int c = tree.root.right.nextRight != null ? tree.root.right.nextRight.key : -1;
        System.out.println("nextRight of " + tree.root.right.key + " is "
                + c);
        int d = tree.root.left.left.nextRight != null ? tree.root.left.left.nextRight.key : -1;
        System.out.println("nextRight of " + tree.root.left.left.key + " is "
                + d);
    }

    private void connect(Node root) {
        if(root == null){
            return ;
        }

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);

        Node temp = null;
        while(!queue.isEmpty()){
            int size = queue.size();


            for(int i=1; i<=size; i++){
                Node prev = temp;
                temp = queue.poll();

                if(i>1){
                    prev.nextRight = temp;
                }

                if(temp.left != null){
                    queue.add(temp.left);
                }

                if(temp.right != null){
                    queue.add(temp.right);
                }

            }

        }

    }
}

