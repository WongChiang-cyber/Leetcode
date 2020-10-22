package Productor_and_customer_wait_notify;

import java.util.Queue;

public class Customer implements Runnable{
    private final Queue<String> queue;
    private final int capacity;
    private final int ROUND = 10;

    Customer(int capacity,Queue<String> queue){
        this.queue = queue;
        this.capacity = capacity;
    }

    public void consume(){
        synchronized (queue){
            while(queue.isEmpty()) {
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            String s = queue.poll();
            System.out.println(Thread.currentThread().getName()+
                    "正在消费 "+s+"的产品");
            queue.notifyAll();
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < ROUND; i++) {
            consume();
        }
    }
}
