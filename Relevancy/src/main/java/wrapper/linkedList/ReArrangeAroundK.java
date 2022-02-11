package wrapper.linkedList;

import static wrapper.linkedList.Reversal.printList;

public class ReArrangeAroundK {
    static Node root;


    public static void main(String[] args) {
        root = new Node(1);
        root.nextNode = new Node(4);
        root.nextNode.nextNode = new Node(3);
        root.nextNode.nextNode.nextNode = new Node(2);

        printList(root);
        Node node = reArrangeAroundK(root, 3);
        printList(node);


    }

    private static Node reArrangeAroundK(Node root, int k) {
        Node lower = null;
        Node equal = null;
        Node greater = null;

        Node lowerhead = lower, equalHead = equal, greaterHead = greater;

        Node current = root;

        while(current != null){
          if(current.data < k)  {
              if(lower == null){
                    lowerhead = current;
                    lower = current;
              }else{
                lower.nextNode = current;
                lower = lower.nextNode;
              }
          }else if(current.data == k)  {
                if(equal == null){
                    equalHead = current;
                    equal = current;
                }else{
                    equal.nextNode = current;
                    equal = equal.nextNode;
                }
            }else{
              if(greater == null){
                  greaterHead = current;
                  greater = current;
              }else{
                  greater.nextNode = current;
                  greater = greater.nextNode;
              }
          }
            current = current.nextNode;
        }

        Node start =null;
        if(greater != null){
          start = greaterHead;
            greaterHead.nextNode = null;
        }

        if(equal != null){
            equal.nextNode = start;
            start = equalHead;
        }

        if(lower != null){
            lower.nextNode = start;
            start = lowerhead;
        }

        return start;
    }
}
