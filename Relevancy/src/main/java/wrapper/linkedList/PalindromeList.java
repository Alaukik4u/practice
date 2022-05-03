package wrapper.linkedList;

public class PalindromeList {
    static LinkedList head;


    public static void main(String[] args) {
        head = new LinkedList(0);
        head.next = new LinkedList(1);
        /*head.next.next = new LinkedList(2);
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
        LinkedList middle = findMiddle(head);

        LinkedList first = head,second =middle.next;
        middle.next = null;
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
