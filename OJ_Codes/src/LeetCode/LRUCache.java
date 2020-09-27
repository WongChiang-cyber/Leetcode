package LeetCode;

import java.util.HashMap;

public class LRUCache {

    private HashMap<Integer,DLinkedList> map;
    private DLinkedList head;
    private DLinkedList tail;
    final private int capacity;
    private int size;
    public LRUCache(int capacity){
        head = new DLinkedList(-1,-1);
        tail = new DLinkedList(-2,-2);
        map = new HashMap<>(capacity);
        head.next = tail;
        head.pre = null;
        tail.next = null;
        tail.pre = head;
        this.capacity = capacity;
        this.size = 0;
    }

    public int get(int key) {
        if(!map.containsKey(key))
            return -1;
        //移动get访问的指针
        DLinkedList node = map.get(key);
        DLinkedList preNode = node.pre;
        DLinkedList nextNode = node.next;
        preNode.next = nextNode;
        nextNode.pre = preNode;
        //移动到链表首
        node.next = head.next;
        node.pre = head;
        head.next.pre = node;
        head.next = node;
        return node.val;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            //删除相同key的节点
            DLinkedList node = map.get(key);
            DLinkedList preNode = node.pre;
            DLinkedList nextNode = node.next;
            map.remove(node.key);
            preNode.next = nextNode;
            nextNode.pre = preNode;
            node=null;
            size--;
        }else if(this.size==capacity){
            //删除最后一个节点 hash
            DLinkedList node = tail.pre;
            DLinkedList preNode = tail.pre.pre;
            map.remove(node.key);
            //解除连接
            preNode.next = tail;
            tail.pre = preNode;
            node = null;
            size--;
        }
        //将节点放到链表首
        DLinkedList node = new DLinkedList(key,value);
        map.put(key,node);
        size++;
        node.next = head.next;
        node.pre = head;
        head.next.pre = node;
        head.next = node;
    }

    public int size(){
        return size;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(2,1);
        System.out.println(cache.get(2));
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}
