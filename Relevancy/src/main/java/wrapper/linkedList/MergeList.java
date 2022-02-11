package wrapper.linkedList;

import static wrapper.linkedList.Reversal.printList;

public class MergeList {
    static Node list1, list2;
    public static void main(String[] args) {
        list1 = new Node(1);
        list1.nextNode = new Node(3);
        list1.nextNode.nextNode = new Node(5);

        list2 = new Node(2);
        list2.nextNode = new Node(4);
        list2.nextNode.nextNode = new Node(6);

        printList(list1);
        printList(list2);

        Node mergeLst = mergeList(list1, list2);
        printList(mergeLst);
    }

    private static Node mergeList(Node list1, Node list2) {
        Node current = new Node(-1);
        Node result = current;
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }

        while(list1 !=null && list2 != null){
            if(list1.data <= list2.data){
                current.nextNode = list1;
                current = current.nextNode;
                list1 = list1.nextNode;
            }else{
                current.nextNode = list2;
                current = current.nextNode;
                list2 = list2.nextNode;
            }
        }

        if(list1 !=null){
            current.nextNode = list1;
        }else if(list2 != null){
            current.nextNode = list2;
        }

        return result.nextNode;
    }
}
