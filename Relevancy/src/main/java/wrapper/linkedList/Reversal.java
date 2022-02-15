package wrapper.linkedList;

public class Reversal {
    static LinkedList head;


    public static void main(String[] args) {
        head = new LinkedList(1);
        head.next = new LinkedList(2);
        head.next.next = new LinkedList(3);
        head.next.next.next = new LinkedList(4);

        printList(head);
        LinkedList node = reverseList(head);
        printList(node);

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



