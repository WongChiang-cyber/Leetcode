package Productor_and_customer_reentrantLock.Productor_and_customer_synchronized;

import java.util.concurrent.locks.ReentrantLock;

public class TestDemo {
    public static void main(String[] args) {
        ReentrantLock lock =new ReentrantLock();
        MyBlockingQueue queue = new MyBlockingQueue(10,lock);
        Runnable runCustomer = new Customer(queue);
        Runnable runProductor = new Productor(queue);

        Thread[] threads = new Thread[4];
        for (int i = 0; i < threads.length; i++) {
            if((i&1)==1)
                threads[i] = new Thread(runCustomer);
            else
                threads[i] = new Thread(runProductor);
            threads[i].start();
        }
    }
}
