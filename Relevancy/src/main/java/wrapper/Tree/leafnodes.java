package wrapper.Tree;

public class leafnodes {
    Node root;
    public static void main(String[] args) {
        leafnodes tree = new leafnodes();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        /* get leaf count of the above tree */
        System.out.println("The leaf count of binary tree is : "
                + tree.getLeafCount(tree.root));
    }

    private int getLeafCount(Node root) {
        if(root == null){
            return 0;
        }
        if(root.left==null && root.right==null){
            return 1;
        }else{
            return getLeafCount(root.left)+getLeafCount(root.right);
        }
    }
}
