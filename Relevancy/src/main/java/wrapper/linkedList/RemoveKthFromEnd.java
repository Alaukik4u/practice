package wrapper.linkedList;

import static wrapper.linkedList.Reversal.printList;

public class RemoveKthFromEnd {
    static LinkedList head;
    public static void main(String[] args) {
        head = new LinkedList(1);
        head.next = new LinkedList(2);
        head.next.next = new LinkedList(2);
        head.next.next.next = new LinkedList(3);

        printList(head);
        removeKthFromEnd(head,1);
        printList(head);
    }

    private static void removeKthFromEnd(LinkedList head, int k) {
        LinkedList current = head, pre=null;



        if(head == null){
            return;
        }

        for(int i=0; i<k; i++){
            current = current.next;
        }

        while(current != null){
            if(pre == null){
                pre = head;
            }else{
               pre = pre.next;
            }
            current = current.next;
        }

        if(pre == null){
            head.value = head.next.value;
            pre = head;
        }

        //TODO here we are deleting the kth element by copying k-1th element to kth element and deleting k-1th element to kth element
        pre.next = pre.next.next;
    }
}
