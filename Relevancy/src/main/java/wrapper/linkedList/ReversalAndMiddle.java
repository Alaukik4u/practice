package wrapper.linkedList;

public class ReversalAndMiddle {
    static LinkedList head;


    public static void main(String[] args) {
        head = new LinkedList(1);
        head.next = new LinkedList(2);
        head.next.next = new LinkedList(3);
        head.next.next.next = new LinkedList(4);
        head.next.next.next.next = new LinkedList(5);
        head.next.next.next.next.next = new LinkedList(6);

        printList(head);
        LinkedList middle = findMiddleElement(head);
        System.out.println("middle element :: " + middle.value);
        LinkedList node = reverseList(head);
        printList(node);


    }

    private static LinkedList findMiddleElement(LinkedList head) {
        LinkedList slow = head, prevElementToSlow = head, fast = head, mid =null;


        while(fast != null && fast.next != null){
            fast = fast.next.next;
            prevElementToSlow = slow;
            slow=slow.next;
        }

        if(fast != null){
            System.out.println("middle is odd");
            mid = slow;
        }else{
            System.out.println("middle is even");
            mid = prevElementToSlow;
        }

        return mid;
    }

    private static LinkedList reverseList(LinkedList head) {
      LinkedList prev =null, curr = head, next =null;

      while(curr != null){

          next = curr.next;
          curr.next = prev;
          prev = curr;
          curr = next;

      }

      return prev;
    }




    public static void printList(LinkedList node) {
        while(node !=null){

            System.out.print(node.value+" ");
            node=node.next;
        }
        System.out.println();
    }
}



