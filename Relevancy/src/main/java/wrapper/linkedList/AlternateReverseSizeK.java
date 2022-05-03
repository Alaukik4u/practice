package wrapper.linkedList;

import static wrapper.linkedList.Reversal.printList;

public class AlternateReverseSizeK {
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
        LinkedList node = reverseinKgroup(head, 3);
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

        if (head != null) {
            head.next = curr;
        }

        count =1;
        while (count < groupSize && curr != null) {
            curr = curr.next;
            count++;
        }

        if(curr != null){
            curr.next = reverseinKgroup(curr.next, groupSize);
        }

        return pre;
    }

    private static LinkedList traverse(LinkedList head, int groupSize) {
        LinkedList pre = null, curr = head, next = null;
        int count = 1;
        while (count <= groupSize && curr != null) {
            count++;
           curr = curr.next;
        }

        return curr;

    }

}
