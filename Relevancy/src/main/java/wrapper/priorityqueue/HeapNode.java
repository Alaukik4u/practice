package wrapper.priorityqueue;

import lombok.Data;

@Data
public class HeapNode {
    int key;
    int value;

    public HeapNode(int key, int value){
        this.key = key;
        this.value = value;
    }
}
