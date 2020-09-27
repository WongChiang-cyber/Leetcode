package LeetCode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Objects;
import java.util.TreeSet;

public class LFUCache {
    HashMap<Integer,Node> map;
    int time;
    TreeSet<Node> treeSet;
    final int capacity;
    int size;

    public LFUCache(int capacity) {
        this.map = new HashMap<>();
        this.time = 0;
        this.treeSet = new TreeSet<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.freq==o2.freq?o1.time-o2.time:o1.freq-o2.freq;
            }
        });
        size = 0;
        this.capacity = capacity;
    }

    public int get(int key) {
        time++;
        if(capacity==0)
            return -1;
        if(!map.containsKey(key))
            return -1;
        Node node = map.get(key);
        node.freq++;
        node.time=time;
        treeSet.add(node);
        map.put(key,node);
        return node.val;
    }

    public void put(int key, int value) {
        time++;
        if(capacity==0)
            return;
        if(!map.containsKey(key)){
            if(capacity==size){
                System.out.println("put first:"+treeSet.first().key);
                map.remove(treeSet.first().key);
                treeSet.remove(treeSet.first());
                size--;
            }
            size++;
            Node node = new Node(key,value,time,1);
            treeSet.add(node);
            map.put(key,node);
        }else{
            Node node = map.get(key);
            node.val = value;
            node.freq++;
            node.time=time;
            treeSet.add(node);
            map.put(key,node);
        }
    }

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        System.out.println(cache.get(1));
        cache.put(3,3);
        System.out.println(cache.get(2));
    }

}
class Node{
    int key,val;
    int time;
    int freq;

    public Node(int key, int val, int time, int freq) {
        this.key = key;
        this.val = val;
        this.time = time;
        this.freq = freq;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return this.freq==node.freq && this.time==node.time;
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }

}

