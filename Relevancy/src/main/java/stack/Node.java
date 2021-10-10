package stack;

import lombok.Data;

@Data
class Node{
    int value;
    int index;

    public Node(int value, int index){
        this.value = value;
        this.index = index;
    }
}
