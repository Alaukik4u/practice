package wrapper.Tree;

public class mirrortree {
    Node root;


    public static void main(String[] args)
    {
        mirrortree tree = new mirrortree();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(4);
        tree.root.right.left = new Node(4);
        tree.root.right.right = new Node(3);
        boolean output = tree.isSymmetric(tree.root, tree.root);
        if (output == true)
            System.out.println("Symmetric");
        else
            System.out.println("Not symmetric");

    }

    private boolean isSymmetric(Node root1, Node root2) {
        if(root1==null && root2==null){
            return true;
        }

        if(root1.key==root2.key){
            return isSymmetric(root1.left, root2.right) && isSymmetric(root1.right, root2.left);
        }

        return false;
    }
}
