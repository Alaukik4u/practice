package wrapper.Tree;

public class TreeHeight {
    Node root;

    public static void main(String[] args) {
        TreeHeight tree = new TreeHeight();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("Height of tree is : " +
                tree.maxDepth(tree.root));
    }

    private int maxDepth(Node root) {
        if(root == null){
            return 0;
        }

        int lheight = maxDepth(root.left);
        int rheight = maxDepth(root.right);

        return 1+Math.max(lheight, rheight);
    }
}
