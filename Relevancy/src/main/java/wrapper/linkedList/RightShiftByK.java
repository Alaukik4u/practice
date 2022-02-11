package wrapper.linkedList;

import static wrapper.linkedList.Reversal.printList;

public class RightShiftByK {
    static Node root;
    public static void main(String[] args) {
        root = new Node(1);
        root.nextNode = new Node(2);
        root.nextNode.nextNode = new Node(3);
        root.nextNode.nextNode.nextNode = new Node(4);
        root.nextNode.nextNode.nextNode.nextNode = new Node(5);
        root.nextNode.nextNode.nextNode.nextNode.nextNode = new Node(6);

        printList(root);
        Node node = rightShiftByK(root, -2);
        printList(node);

    }

    private static Node rightShiftByK(Node root, int k) {
        //1-2-3-4-5-6
        //case when negative , positive and equal to length

        Node current = root;

        int length = calculateLength(root);

        if(k>0){
            k = k-length;
        }

        if(k==length){
            return root;
        }

        current = root;
        k++;

        while(k<0){
            current = current.nextNode;
            k++;
        }

        Node newHead = current.nextNode;
        current.nextNode = null;

        current = newHead;

        while(current.nextNode !=null){
            current = current.nextNode;
        }

        current.nextNode = root;

        return newHead;
    }

    private static int calculateLength(Node root) {
        int length=0;
        while(root != null){
            length++;
            root = root.nextNode;
        }

        return length;
    }
}
