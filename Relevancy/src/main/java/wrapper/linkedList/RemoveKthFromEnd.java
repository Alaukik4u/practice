package wrapper.linkedList;

import static wrapper.linkedList.Reversal.printList;

public class RemoveKthFromEnd {
    static Node root;
    public static void main(String[] args) {
        root = new Node(1);
        root.nextNode = new Node(2);
        root.nextNode.nextNode = new Node(2);
        root.nextNode.nextNode.nextNode = new Node(3);

        printList(root);
        removeKthFromEnd(root,1);
        printList(root);
    }

    private static void removeKthFromEnd(Node root, int k) {
        Node current = root, pre=null;



        if(root == null){
            return;
        }

        for(int i=0; i<k; i++){
            current = current.nextNode;
        }

        while(current != null){
            if(pre == null){
                pre = root;
            }else{
               pre = pre.nextNode;
            }
            current = current.nextNode;
        }

        if(pre == null){
            root.data = root.nextNode.data;
            pre = root;
        }

        //TODO here we are deleting the kth element by copying k-1th element to kth element and deleting k-1th element to kth element
        pre.nextNode = pre.nextNode.nextNode;
    }
}
