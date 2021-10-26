package wrapper.Tree;

public class MaxPathSum {
    Node root;
    int result = Integer.MIN_VALUE;

    public static void main(String[] args) {
        MaxPathSum tree = new MaxPathSum();

        tree.root = new Node(10);
        tree.root.left = new Node(2);
        tree.root.right = new Node(10);
        tree.root.left.left = new Node(20);
        tree.root.left.right = new Node(1);
        tree.root.right.right = new Node(-25);
        tree.root.right.right.left = new Node(3);
        tree.root.right.right.right = new Node(4);
        System.out.println("maximum path sum is : " +
                tree.findMaxSumUtil(tree.root));
    }

    private int findMaxSumUtil(Node root){
        Result result = new Result();
        findMaxSum(root, result);

        return result.result;
    }

    private int findMaxSum(Node root, Result result) {
        if (root == null)
            return 0;
        int leftsum = findMaxSum(root.left, result);
        int rightsum = findMaxSum(root.right, result);

        int temp = Math.max(Math.max(leftsum, rightsum) + root.key, root.key);
        int ans = Math.max(temp, root.key + rightsum + leftsum);
        result.result = Math.max(result.result, ans);

        return temp;
    }
}

