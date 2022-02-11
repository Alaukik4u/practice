package wrapper.linkedList;

public class Reversal {
    static Node root;


    public static void main(String[] args) {
        root = new Node(1);
        root.nextNode = new Node(2);
        root.nextNode.nextNode = new Node(3);
        root.nextNode.nextNode.nextNode = new Node(4);

        printList(root);
        Node node = reverseList(root);
        printList(node);

    }

    private static Node  reverseList(Node root) {
      Node  prev =null, curr = root, next =null;

      while(curr != null){

          next = curr.nextNode;
          curr.nextNode = prev;
          prev = curr;
          curr = next;

      }

      return prev;
    }




    public static void printList(Node node) {
        while(node !=null){

            System.out.print(node.data+" ");
            node=node.nextNode;
        }
        System.out.println();
    }
}



