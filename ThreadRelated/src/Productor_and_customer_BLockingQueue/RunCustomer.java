package Productor_and_customer_BLockingQueue;

import java.util.concurrent.BlockingQueue;

public class RunCustomer implements Runnable{

    private BlockingQueue<String> queue;
    RunCustomer(BlockingQueue<String> queue){
        this.queue = queue;
    }
    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            queue.remove();
            System.out.println("消费者正在消费 "+i);
        }
    }
}
