package wrapper.linkedList;

public class FindStartOfLoop {
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
        head.next.next.next.next.next.next.next.next =  head.next.next.next.next;

        //printList(head);
        LinkedList node = findStartOfLoop(head);
        System.out.println("Loop start point "+ node.value);;
    }

    private static LinkedList findStartOfLoop(LinkedList head) {
        boolean isLoop = false;
        if(head == null || head.next == null){
            return head;
        }

        LinkedList slow = head, fast= head;

        //finding loop
        while(fast != null && fast.next != null){
            if(slow != head && slow == fast ){
                isLoop = true;
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        System.out.println("fast pointer"+ fast.value);
        System.out.println("slow pointer"+ slow.value);

        //finding length of the loop
        int length=1;
        while(fast.next != slow){
            length++;
            fast = fast.next;
        }

        System.out.println("loop leght is "+ length);

        //finding the start of the loop
         slow =head;
         fast = head;
         for(int i=1; i<=length; i++){
             fast = fast.next;
         }

         while(slow != fast){
             slow = slow.next;
             fast = fast.next;
         }

       return slow;
    }

   }
