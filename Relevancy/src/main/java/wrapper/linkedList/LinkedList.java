package wrapper.linkedList;

class LinkedList {
    int value;
    LinkedList next;

    public LinkedList(int data) {
        this.value = data;
    }

    public static int findLength(LinkedList head){
        int i=0;
        while(head != null){
            head = head.next;
            i++;
        }
        System.out.println("length of the list is ::" + i);
        return i;
    }
}
