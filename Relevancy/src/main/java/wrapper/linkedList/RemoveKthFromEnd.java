package wrapper.linkedList;

import static wrapper.linkedList.ReversalAndMiddle.printList;

public class RemoveKthFromEnd {
    static LinkedList head;
    public static void main(String[] args) {
        head = new LinkedList(1);
        head.next = new LinkedList(2);
        head.next.next = new LinkedList(3);
        head.next.next.next = new LinkedList(4);

        printList(head);
        LinkedList list = removeKthFromEnd(head,6);
        printList(list);
    }

    /*private static void removeKthFromEnd(LinkedList head, int k) {
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
    }*/

        private static LinkedList removeKthFromEnd(LinkedList head, int k) {
        LinkedList fast =head, slow = head;

        int length = LinkedList.findLength(head);
        if(length < k){
            System.out.println("illegal input lengh --->"+ k+" for actual length::"+ length );
            return head;
        }

        for(int i=0; i<k; i++){
            if(fast != null){
                fast = fast.next;
            }
        }

        if(fast == null){
            head = head.next;
            return head;
        }

        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
            return fast;
        }

}
