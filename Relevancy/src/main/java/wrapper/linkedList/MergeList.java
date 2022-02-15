package wrapper.linkedList;

import static wrapper.linkedList.Reversal.printList;

public class MergeList {
    static LinkedList list1, list2;
    public static void main(String[] args) {
        list1 = new LinkedList(1);
        list1.next = new LinkedList(3);
        list1.next.next = new LinkedList(5);

        list2 = new LinkedList(2);
        list2.next = new LinkedList(4);
        list2.next.next = new LinkedList(6);

        printList(list1);
        printList(list2);

        LinkedList mergeLst = mergeList(list1, list2);
        printList(mergeLst);
    }

    private static LinkedList mergeList(LinkedList list1, LinkedList list2) {
        LinkedList current = new LinkedList(-1);
        LinkedList result = current;
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }

        while(list1 !=null && list2 != null){
            if(list1.value <= list2.value){
                current.next = list1;
                current = current.next;
                list1 = list1.next;
            }else{
                current.next = list2;
                current = current.next;
                list2 = list2.next;
            }
        }

        if(list1 !=null){
            current.next = list1;
        }else if(list2 != null){
            current.next = list2;
        }

        return result.next;
    }
}
