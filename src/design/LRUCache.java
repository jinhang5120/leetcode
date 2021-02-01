package design;

import java.util.*;

class LRUCache {
    Map<Integer,Integer> map = new HashMap<>();
    List<Integer> list = new LinkedList<>();
    int size = 0;
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Iterator<Integer> it = list.iterator();
            while(it.hasNext()){
                int i = it.next();
                if(i==key){
                    it.remove();
                    break;
                }
            }
            list.add(key);
            return map.get(key);
        }else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.put(key,value);
            Iterator<Integer> it = list.iterator();
            while(it.hasNext()){
                int i = it.next();
                if(i==key){
                    it.remove();
                    break;
                }
            }
            list.add(key);
        }else if(size<capacity){
            list.add(key);
            map.put(key,value);
            size++;           
        }else{
            map.remove(list.get(0));
            list.remove(0);
            list.add(key);
            map.put(key,value);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */