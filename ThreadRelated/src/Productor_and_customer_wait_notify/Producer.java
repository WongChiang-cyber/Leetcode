package Productor_and_customer_wait_notify;

import java.util.Queue;

public class Producer implements Runnable{
    private final Queue<String> queue;
    private final int capacity;
    private final int ROUND = 10;

    Producer(int capacity,Queue<String> queue){
        this.capacity = capacity;
        this.queue = queue;
    }

    public void product() {
        synchronized (queue){
            while (queue.size()==capacity){
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            queue.add(Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getName() +
                    "正在生产");
            queue.notifyAll();
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < ROUND; i++) {
            product();
        }
    }
}
