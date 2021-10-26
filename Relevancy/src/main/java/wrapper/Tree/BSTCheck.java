package wrapper.Tree;

public class BSTCheck {
    Node root;

    public static void main(String args[])
    {
        BSTCheck tree = new BSTCheck();
        tree.root = new Node(4);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);

        if (tree.isBST())
            System.out.println("IS BST");
        else
            System.out.println("Not a BST");
    }

    private boolean isBST() {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isValidBST(Node root, int min, int max) {
        if (root == null) {
            return true;
        }

        if (root.key < min || root.key > max) {
            return false;
        }

        return isValidBST(root.left, min, root.key) && isValidBST(root.right, root.key, max);

    }
}
