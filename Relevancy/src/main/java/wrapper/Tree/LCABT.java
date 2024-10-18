package wrapper.Tree;

public class LCABT {
    Node root;
    boolean v1 = false,v2=false;

    public static void main(String args[])
    {
        LCABT tree = new LCABT();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.right.right = new Node(8);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        Node lca = tree.findLCAUtils(tree.root, 4, 5);
        if (lca != null)
            System.out.println("LCA(4, 5) = " + lca.key);
        else
            System.out.println("Keys are not present");

        Node lca1 = tree.findLCAUtils(tree.root,4, 8);
        if (lca1 != null)
            System.out.println("LCA(4, 8) = " + lca1.key);
        else
            System.out.println("Keys are not present");
    }

    private Node findLCAUtils(Node root, int n1, int n2) {
        v1 = false;
        v2=false;
        Node lca = findLCA(root,n1,n2);
        if(v1 && v2){
            return lca;
        }

        return null;
    }

    private Node findLCA(Node root, int n1, int n2) {
        if(root == null){
            return null;
        }
        Node temp = null;

        if(root.key == n1){
            v1=true;
            temp= root;
        }

        if(root.key == n2){
            v2=true;
            temp= root;
        }

        Node lcaleft = findLCA(root.left, n1, n2);
        Node lcaright = findLCA(root.right, n1, n2);

        if(temp !=null ){
            return temp;
        }

        if(lcaleft !=null && lcaright!=null){
            return root;
        }

        return lcaleft!=null? lcaleft: lcaright;
    }
}
