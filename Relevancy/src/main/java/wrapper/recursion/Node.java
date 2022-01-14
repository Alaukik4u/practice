package wrapper.recursion;

import lombok.Data;

@Data
public class Node {
    public Node left;
    public Node right;
    int val;

    public Node( int val) {
        this.left = null;
        this.right = null;
        this.val = val;
    }
}
