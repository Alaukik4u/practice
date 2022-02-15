package wrapper.linkedList;

import static wrapper.linkedList.Reversal.printList;

public class FindLoop {
    static LinkedList root;


    public static void main(String[] args) {
        root = new LinkedList(1);
        root.next = new LinkedList(4);
        root.next.next = new LinkedList(3);
        root.next.next.next = new LinkedList(2);
        root.next.next.next.next = new LinkedList(5);
        root.next.next.next.next.next = new LinkedList(6);
        root.next.next.next.next.next.next = new LinkedList(7);
        root.next.next.next.next.next.next.next = new LinkedList(8);
        root.next.next.next.next.next.next.next.next = new LinkedList(5);


        printList(root);
        LinkedList node = reArrangeAroundK(root, 3);
        printList(node);


    }

    private static LinkedList reArrangeAroundK(LinkedList root, int k) {
        LinkedList lower = null;
        LinkedList equal = null;
        LinkedList greater = null;

        LinkedList lowerhead = lower, equalHead = equal, greaterHead = greater;

        LinkedList current = root;

        while(current != null){
          if(current.value < k)  {
              if(lower == null){
                    lowerhead = current;
                    lower = current;
              }else{
                lower.next = current;
                lower = lower.next;
              }
          }else if(current.value == k)  {
                if(equal == null){
                    equalHead = current;
                    equal = current;
                }else{
                    equal.next = current;
                    equal = equal.next;
                }
            }else{
              if(greater == null){
                  greaterHead = current;
                  greater = current;
              }else{
                  greater.next = current;
                  greater = greater.next;
              }
          }
            current = current.next;
        }

        LinkedList start =null;
        if(greater != null){
          start = greaterHead;
            greaterHead.next = null;
        }

        if(equal != null){
            equal.next = start;
            start = equalHead;
        }

        if(lower != null){
            lower.next = start;
            start = lowerhead;
        }

        return start;
    }
}
