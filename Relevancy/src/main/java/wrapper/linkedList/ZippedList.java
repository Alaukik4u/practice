package wrapper.linkedList;

import static wrapper.linkedList.Reversal.printList;

public class ZippedList {
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
        LinkedList node = getZippedList(head);
        printList(node);
    }

    private static LinkedList getZippedList(LinkedList head) {
        if(head == null || head.next == null){
            return head;
        }

        LinkedList middle  = findMiddle(head);
        LinkedList first = head, second = middle.next;
        middle.next = null;

        second = reverseList(second);
        return findInterLievedList(first, second);
    }

    private static LinkedList findInterLievedList(LinkedList first, LinkedList second) {
        LinkedList firstIterator = first, seconditerator = second;


        while (firstIterator != null && seconditerator != null){
            LinkedList firsthalfIterator = firstIterator.next;
            LinkedList secondhalfiterator = seconditerator.next;

            firstIterator.next = seconditerator;
            seconditerator.next = firsthalfIterator;

            firstIterator = firsthalfIterator;
            seconditerator = secondhalfiterator;
        }

        return first;
    }


    private static LinkedList reverseList(LinkedList head) {
        LinkedList prev=null, curr = head, next=null;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private static LinkedList findMiddle(LinkedList head) {
        LinkedList slow = head , fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

}
