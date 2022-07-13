package wrapper.linkedList;

public class PalindromeList {
    static LinkedList head;


    public static void main(String[] args) {

        //TODO case when list is even
        head = new LinkedList(0);
        head.next = new LinkedList(1);
        head.next.next = new LinkedList(2);
        head.next.next.next = new LinkedList(1);
        head.next.next.next.next = new LinkedList(3);
        head.next.next.next.next.next = new LinkedList(3);
        head.next.next.next.next.next.next = new LinkedList(1);
        head.next.next.next.next.next.next.next = new LinkedList(2);
        head.next.next.next.next.next.next.next.next = new LinkedList(1);
        head.next.next.next.next.next.next.next.next.next =  new LinkedList(0);

        //TODO case when list is odd
        /*head = new LinkedList(0);
        head.next = new LinkedList(1);
        head.next.next = new LinkedList(2);
        head.next.next.next = new LinkedList(1);
        head.next.next.next.next = new LinkedList(3);
        head.next.next.next.next.next = new LinkedList(1);
        head.next.next.next.next.next.next = new LinkedList(2);
        head.next.next.next.next.next.next.next = new LinkedList(1);
        head.next.next.next.next.next.next.next.next =  new LinkedList(0);*/

        //printList(head);
        Boolean node = isPalindrome(head);
        System.out.println("Palindrome LinkedList "+ node);;
    }

    private static boolean isPalindrome(LinkedList head) {
        if(head == null || head.next == null){
            return true;
        }

        //find middle of linkedList
        LinkedList slow = head, prevElementToSlow = head, fast = head, mid =null;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            prevElementToSlow = slow;
            slow=slow.next;
        }

        if(fast != null){
            System.out.println("middle is odd");
            mid = slow;
            slow = slow.next;
        }

        LinkedList first = head, second =slow;
        prevElementToSlow.next = null;
        //reverse second list
        second  = reverseList(second);

        //compare both list
        while(first != null && second != null){
            if(first.value != second.value){
                return false;
            }
            first = first.next;
            second = second.next;
        }

        return first != second ? false: true;
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
