package wrapper.linkedList;

import static wrapper.linkedList.Reversal.printList;

public class RemoveDuplicates {
    static LinkedList head;
    public static void main(String[] args) {
        head = new LinkedList(1);
        head.next = new LinkedList(2);
        head.next.next = new LinkedList(2);
        head.next.next.next = new LinkedList(3);

        printList(head);

        removeDuplicates(head);

        printList(head);
    }

    private static void removeDuplicates(LinkedList head) {
        LinkedList current = head;

        if(head == null || head.next == null){
            return;
        }

        while(current != null && current.next != null){
            if(current.value == current.next.value){
                current.next = current.next.next;
            }else{
                current = current.next;
            }
        }
    }
}
