package wrapper.linkedList;

import static wrapper.linkedList.Reversal.printList;

public class RemoveDuplicates {
    static Node root;
    public static void main(String[] args) {
        root = new Node(1);
        root.nextNode = new Node(2);
        root.nextNode.nextNode = new Node(2);
        root.nextNode.nextNode.nextNode = new Node(3);

        printList(root);

        removeDuplicates(root);

        printList(root);
    }

    private static void removeDuplicates(Node root) {
        Node current = root;

        if(root == null || root.nextNode == null){
            return;
        }

        while(current != null && current.nextNode != null){
            if(current.data == current.nextNode.data){
                current.nextNode = current.nextNode.nextNode;
            }else{
                current = current.nextNode;
            }
        }
    }
}
