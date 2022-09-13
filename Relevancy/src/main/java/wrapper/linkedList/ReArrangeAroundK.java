package wrapper.linkedList;

import static wrapper.linkedList.ReversalAndMiddle.printList;

public class ReArrangeAroundK {
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
        LinkedList node = reArrangeAroundK(head, 5);
        printList(node);


    }

    private static LinkedList reArrangeAroundK(LinkedList head, int k) {
    LinkedList lower = null;
    LinkedList equal = null;
    LinkedList greater = null;

    LinkedList lowerhead = null, equalHead = null, greaterHead = null;

    LinkedList current = head;

        while (current != null) {
            if (current.value < k) {
                if (lower == null) {
                    lowerhead = current;
                    lower = current;
                } else {
                    lower.next = current;
                    lower = lower.next;
                }
            } else if (current.value == k) {
                if (equal == null) {
                    equalHead = current;
                    equal = current;
                } else {
                    equal.next = current;
                    equal = equal.next;
                }
            } else {
                if (greater == null) {
                    greaterHead = current;
                    greater = current;
                } else {
                    greater.next = current;
                    greater = greater.next;
                }
            }
            current = current.next;
        }

        LinkedList start = null;
        if (greater != null) {
            start = greaterHead;
            greater.next = null;
        }

        if (equal != null) {
            equal.next = start;
            start = equalHead;
        }

        if (lower != null) {
            lower.next = start;
            start = lowerhead;
        }

        return start;
}}
