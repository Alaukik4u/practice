package wrapper;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {
    Map<Integer, Cache> map = new HashMap<>();
    Deque<Integer> deque = new LinkedList<>();
    int CAPACITY = 4;

    /*
        while we put in map there will be three conditions
        1. map is full capacity
        2. key present in map
        3. key absent from map

       */
    public void put(int key, int value){
        if(map.entrySet().size() == CAPACITY){
            deque.removeLast();
        }else if(null !=map.get(key)){
            deque.remove(key);
        }
        Cache cache = new Cache(key, value);
        deque.addFirst(key);
        map.put(key, cache);
    }


    /*
       while we get from map there will be condition
       1. key present in map
       2. key absent from map

      */
    public Cache getItemFromCache(int key){
        if(null != map.get(key)){
            deque.remove(key);
            deque.addFirst(key);
            return map.get(key);
        }else{
            System.out.println("wrong key entered");
        }
        return null;
    }


    public static void main(String[] args) {
        LRUCache cache = new LRUCache();

        cache.put(1,5);
        cache.put(4,5);
        cache.put(3,5);
        cache.put(2,5);
        for(Integer i : cache.deque){
            System.out.print(i + " ");
        }
        System.out.println();
        cache.getItemFromCache(4);

        System.out.println("Entries after calling cache items");
        for(Integer i : cache.deque){
            System.out.print(i + " ");
        }
        System.out.println();
    }

}


@Data
class Cache {
    int key;
    int value;

    public Cache(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
