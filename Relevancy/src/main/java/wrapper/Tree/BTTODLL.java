package wrapper.Tree;

public class BTTODLL {
    Node root;

    Node head;

    static Node prev;
   
   
    public static void main(String[] args)
    {
        // Let us create the tree as shown in above diagram
        BTTODLL tree = new BTTODLL();
        tree.root = new Node(10);
        tree.root.left = new Node(12);
        tree.root.right = new Node(15);
        tree.root.left.left = new Node(25);
        tree.root.left.right = new Node(30);
        tree.root.right.left = new Node(36);

        // convert to DLL
        tree.BinaryTree2DoubleLinkedList(tree.root);

        // Print the converted List
        tree.printList(tree.head);

    }

    private void BinaryTree2DoubleLinkedList(Node root) {
        if(root == null){
            return;
        }

        BinaryTree2DoubleLinkedList(root.left);

        if(prev == null){
            head = root;
        }else{
            prev.right = root;
            root.left = prev;
        }
        prev = root;

        BinaryTree2DoubleLinkedList(root.right);
    }

    void printList(Node node)
    {
        while (node != null)
        {
            System.out.print(node.key + " ");
            node = node.right;
        }
    }
}
