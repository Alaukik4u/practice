package Tree;

import lombok.Data;

@Data
public class Node {
    int key;
    int index;
    Node left;
    Node right;
    Node nextRight;

    public Node(int key) {
        this.key = key;
        this.left = null;
        this.right = null;
        this.nextRight =null;
        this.index=0;
    }
}
