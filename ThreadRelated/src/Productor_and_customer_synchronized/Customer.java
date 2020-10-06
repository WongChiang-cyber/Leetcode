package Productor_and_customer_synchronized;

public class Customer implements Runnable{
    public MyBlockingQueue queue;

    Customer(MyBlockingQueue queue){
        this.queue = queue;
    }

    @Override
    public void run(){
        for (int i = 0; i < 20; i++) {
            try {
                queue.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
