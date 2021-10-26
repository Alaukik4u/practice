package wrapper.recursion;

import lombok.Data;

@Data
public class Node {
    Node left;
    Node right;
    int val;

    public Node( int val) {
        this.left = null;
        this.right = null;
        this.val = val;
    }
}
