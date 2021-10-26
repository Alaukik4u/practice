package wrapper.Tree;

import java.util.ArrayList;
import java.util.List;

public class RootToleaf {
    Node root;

    public static void main(String[] args) {
        RootToleaf tree = new RootToleaf();
        tree.root = new Node(10);
        tree.root.left = new Node(8);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(2);

        /* Let us test the built tree by printing Inorder traversal */
        tree.RootToleaf(tree.root);
    }

    private void RootToleaf(Node root) {
        List<List<String>> paths = new ArrayList<List<String>>();

    }
}
