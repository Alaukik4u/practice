package wrapper.linkedList;

import static wrapper.linkedList.Reversal.printList;

public class SumOfLinkedList {
    static LinkedList head1, head2;


    public static void main(String[] args) {
        head1 = new LinkedList(1);
        head1.next = new LinkedList(4);
        head1.next.next = new LinkedList(3);
        head1.next.next.next = new LinkedList(2);

        head2 = new LinkedList(2);
        head2.next = new LinkedList(0);
        head2.next.next = new LinkedList(0);
        head2.next.next.next = new LinkedList(2);

        printList(head1);
        printList(head2);
        LinkedList node = sumOfLinkedList(head1, head2);
        printList(node);
    }

    private static LinkedList sumOfLinkedList(LinkedList linkedListOne, LinkedList linkedListTwo) {
        LinkedList node1 = linkedListOne, node2=linkedListTwo;
        int carry=0;
        LinkedList sumNode = new LinkedList(-1);
        LinkedList sumNodeIterator = sumNode;
        
        while(node1 != null || node2 != null || carry != 0){
            int value1 = (node1 != null) ? node1.value : 0;
            int value2 = (node2 != null) ? node2.value : 0;

            int sum = value1+value2+carry;
            carry = sum/10;
            sum = sum %10;
            sumNodeIterator.next = new LinkedList(sum);
            sumNodeIterator = sumNodeIterator.next;

            node1 = (node1 != null) ? node1.next: null;
            node2 = (node2 != null) ? node2.next: null;
        }

        return sumNode.next;

    }


}
