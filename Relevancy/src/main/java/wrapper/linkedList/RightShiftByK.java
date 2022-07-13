package wrapper.linkedList;

import static wrapper.linkedList.ReversalAndMiddle.printList;

public class RightShiftByK {
    static LinkedList head;
    public static void main(String[] args) {
        head = new LinkedList(1);
        head.next = new LinkedList(2);
        head.next.next = new LinkedList(3);
        head.next.next.next = new LinkedList(4);
        head.next.next.next.next = new LinkedList(5);
        head.next.next.next.next.next = new LinkedList(6);

        printList(head);
        LinkedList node = rightShiftByK(head, -2);
        printList(node);

    }

    private static LinkedList rightShiftByK(LinkedList head, int k) {
        //1-2-3-4-5-6
        //case when negative , positive and equal to length

        LinkedList current = head;

        int length = calculateLength(head);

        if(k>0){
            k = k-length;
        }

        if(k==length){
            return head;
        }

        current = head;
        k++;

        while(k<0){
            current = current.next;
            k++;
        }

        LinkedList newHead = current.next;
        current.next = null;

        current = newHead;

        while(current.next !=null){
            current = current.next;
        }

        current.next = head;

        return newHead;
    }

    private static int calculateLength(LinkedList head) {
        int length=0;
        while(head != null){
            length++;
            head = head.next;
        }

        return length;
    }
}
