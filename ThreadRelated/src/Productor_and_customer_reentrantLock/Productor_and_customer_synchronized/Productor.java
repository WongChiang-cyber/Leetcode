package Productor_and_customer_reentrantLock.Productor_and_customer_synchronized;

public class Productor implements Runnable{

    public MyBlockingQueue queue;

    Productor(MyBlockingQueue queue){
        this.queue = queue;
    }

    @Override
    public void run(){
        for (int i = 0; i < 20; i++) {
            try {
                queue.put();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
