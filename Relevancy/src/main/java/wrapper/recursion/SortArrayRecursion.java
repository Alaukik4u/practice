package wrapper.recursion;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayList;
import java.util.List;

import static wrapper.stack.MAH.printArray;

public class SortArrayRecursion {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(7);
        list.add(5);
        list.add(6);
        printArray(list);
        sortArrayWithRecursion(list);
        printArray(list);
    }

    private static void sortArrayWithRecursion(List<Integer> list) {
        if(list.size() == 0){
            return;
        }

        Integer value = list.get(list.size()-1);
        list.remove(list.size()-1);

        sortArrayWithRecursion(list);
        insert(list, value);

    }

    private static void insert(List<Integer> list, Integer value) {

        if(list.size()==0 || list.get(list.size()-1) <= value){
            list.add(value);
            return;
        }

        Integer value1 = list.get(list.size()-1);
        list.remove(list.size()-1);
        insert(list, value);
        list.add(value1);
    }
}
