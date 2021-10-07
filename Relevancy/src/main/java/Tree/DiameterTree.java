package Tree;

public class DiameterTree {
    Node root;
    int result = Integer.MIN_VALUE;

    public static void main(String[] args) {

        // creating a binary tree and entering the nodes
        DiameterTree tree = new DiameterTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        // Function Call
        System.out.println(
                "The diameter of given binary tree is : "
                        + tree.diameter(tree.root));
    }

    private int diameter(Node root){
        Result result = new Result();
        diameter(root, result);

        return result.result;
    }

    private int diameter(Node root, Result result) {
        if (root == null)
            return 0;
        int leftheight = maxDepth(root.left);
        int rightheight= maxDepth(root.right);

        int temp = Math.max(leftheight, rightheight) + 1;
        int ans = Math.max(temp, root.key + leftheight + rightheight);
        result.result = Math.max(result.result, ans);

        return temp;
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


