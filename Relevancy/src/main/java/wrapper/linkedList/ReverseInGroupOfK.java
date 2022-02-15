package wrapper.linkedList;

import static wrapper.linkedList.Reversal.printList;

public class ReverseInGroupOfK {
    static LinkedList head;


    public static void main(String[] args) {
        head = new LinkedList(1);
        head.next = new LinkedList(4);
        head.next.next = new LinkedList(3);
        head.next.next.next = new LinkedList(2);
        head.next.next.next.next = new LinkedList(5);
        head.next.next.next.next.next = new LinkedList(6);
        head.next.next.next.next.next.next = new LinkedList(7);
        head.next.next.next.next.next.next.next = new LinkedList(8);

        printList(head);
        LinkedList node = reverseinKgroup(head, 4);
        printList(node);


    }

    private static LinkedList reverseinKgroup(LinkedList head, int groupSize) {
        LinkedList pre = null, curr = head, next = null;
        int count = 1;
        while (count <= groupSize && curr != null) {
            count++;
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }

        if (next != null) {
            head.next = reverseinKgroup(next, groupSize);
        }

        return pre;
    }

}
