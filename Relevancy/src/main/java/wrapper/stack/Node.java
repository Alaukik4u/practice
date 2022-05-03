package wrapper.stack;

import lombok.Data;

@Data
class Node{
    int value;
    int index;
    int min;
    int max;

    public Node(int value, int index){
        this.value = value;
        this.index = index;
    }

    public Node(int value, int min, int max) {
        this.value = value;
        this.min = min;
        this.max = max;
    }
}
