package Productor_and_customer_reentrantLock.Productor_and_customer_synchronized;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockingQueue {
    private int size;
    private int capacity;
    private int idx;
    private Queue<DataClass> queue;
    private ReentrantLock lock;
    private Condition notFull,notEmpty;

    MyBlockingQueue(int capacity,ReentrantLock lock){
        this.capacity = capacity;
        this.size = 0;
        this.idx = 0;
        queue = new LinkedList<>();
        this.lock = lock;
        this.notEmpty = lock.newCondition();
        this.notFull = lock.newCondition();
    }

    public void put() throws InterruptedException {
        lock.lock();
        try{
            while(size == capacity){
                notFull.await();
            }
            queue.add(new DataClass(idx,Thread.currentThread().getName()));
            System.out.println(Thread.currentThread().getName()+"正在生产产品"+idx);
            size++;
            idx++;
            notEmpty.signalAll();
        }finally {
            lock.unlock();
        }

    }

    public DataClass get() throws InterruptedException {
        lock.lock();
        try{
            while(size==0){
                notEmpty.await();
            }
            DataClass res = queue.poll();
            System.out.println(Thread.currentThread().getName()+"正在消费产品"+res.key+" 生产者"+res.val);
            size--;
            notFull.signalAll();
            return res;
        }finally {
            lock.unlock();
        }

    }

}


