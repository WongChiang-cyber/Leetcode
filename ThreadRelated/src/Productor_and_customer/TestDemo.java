package Productor_and_customer;

public class TestDemo {
    public static void main(String[] args) {
        MyBlockingQueue queue = new MyBlockingQueue(10);
        Runnable runCustomer = new Customer(queue);
        Runnable runProductor = new Productor(queue);

        Thread[] threads = new Thread[3];
        for (int i = 0; i < threads.length; i++) {
            if((i&1)==1)
                threads[i] = new Thread(runCustomer);
            else
                threads[i] = new Thread(runProductor);
            threads[i].start();
        }
    }

}
