package Tree;

import lombok.Data;
@Data
public class Node {
    int key;
    int index;
    Node left;

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getNextRight() {
        return nextRight;
    }

    public void setNextRight(Node nextRight) {
        this.nextRight = nextRight;
    }

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
