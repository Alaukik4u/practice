package wrapper.recursion;

public class HeightTreeIBH {
    static Node root;

    public static void main(String[] args) {
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);

        System.out.println("height of tree is "+ heightOftree(root));
    }

    private static int heightOftree(Node root) {
        //Base condition
        if(root == null)
            return 0;

        //hypothesis
        int left = heightOftree(root.left);
        int right = heightOftree(root.right);

        //induction
        return 1+ Math.max(left, right);
    }
}
