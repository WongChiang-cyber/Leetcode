package CoperatePrint1_5_fairLock;

import java.util.concurrent.locks.ReentrantLock;

public class RunPrint implements Runnable{
    public static int num = 0;
    public static ReentrantLock lock;
    RunPrint(ReentrantLock l){
        lock = l;
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.lock();
            System.out.println("Thread:"+Thread.currentThread().getName()+" "+num++);
            lock.unlock();
        }
    }
}
