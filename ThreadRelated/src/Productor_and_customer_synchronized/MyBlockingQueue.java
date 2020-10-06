package Productor_and_customer_synchronized;

import java.util.LinkedList;
import java.util.Queue;

public class MyBlockingQueue {
    private int size;
    private int capacity;
    private int idx;
    private Queue<DataClass> queue;

    MyBlockingQueue(int capacity){
        this.capacity = capacity;
        this.size = 0;
        this.idx = 0;
        queue = new LinkedList<>();
    }

    public synchronized void put() throws InterruptedException {
        while(size == capacity){
            this.wait();
        }
        queue.add(new DataClass(idx,Thread.currentThread().getName()));
        System.out.println(Thread.currentThread().getName()+"正在生产产品"+idx);
        size++;
        idx++;
        this.notifyAll();
    }

    public synchronized DataClass get() throws InterruptedException {
        while(size==0){
            this.wait();
        }
        DataClass res = queue.poll();
        System.out.println(Thread.currentThread().getName()+"正在消费产品"+res.key+" 生产者"+res.val);
        size--;
        this.notifyAll();
        return res;
    }

}


