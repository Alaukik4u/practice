package Tree;

public class Sametree {
    Node root1, root2;


    public static void main(String[] args)
    {
        Sametree tree = new Sametree();

        tree.root1 = new Node(1);
        tree.root1.left = new Node(2);
        tree.root1.right = new Node(3);
        tree.root1.left.left = new Node(4);
        tree.root1.left.right = new Node(5);

        tree.root2 = new Node(1);
        tree.root2.left = new Node(2);
        tree.root2.right = new Node(3);
        tree.root2.left.left = new Node(4);
        tree.root2.left.right = new Node(5);

        if (tree.identicalTrees(tree.root1, tree.root2))
            System.out.println("Both trees are identical");
        else
            System.out.println("Trees are not identical");

    }

    private boolean identicalTrees(Node root1, Node root2) {
        if(root1==null && root2==null){
            return true;
        }

        if(root1.key==root2.key && identicalTrees(root1.left, root2.left) && identicalTrees(root2.right, root2.right)){
            return true;
        }

        return false;
    }
}
