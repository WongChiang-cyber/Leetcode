package Productor_and_customer_BLockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class TestDemo {
    public static void main(String[] args) {

        BlockingQueue<String> queue = new LinkedBlockingDeque<>();
        RunCustomer r1 = new RunCustomer(queue);
        RunProductor r2 = new RunProductor(queue);
        new Thread(r2).start();
        new Thread(r2).start();
        new Thread(r2).start();
        new Thread(r1).start();
        new Thread(r1).start();
        new Thread(r1).start();
    }
}
