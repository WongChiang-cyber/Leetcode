package Productor_and_customer_BLockingQueue;

import java.util.concurrent.BlockingQueue;

public class RunProductor implements Runnable{
    private BlockingQueue<String> queue;
    RunProductor(BlockingQueue<String> queue){
        this.queue = queue;
    }
    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            queue.add(Thread.currentThread().getName());
            System.out.println("生产者正在生产"+Thread.currentThread().getName()+" "+i);
        }
    }
}
