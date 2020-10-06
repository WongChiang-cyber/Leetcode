package CoperatePrintA_Z_ReentrantLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class RunPrint implements Runnable{

    private static char character = 'A';
    private static int i = 0;
    private ReentrantLock lock;
    private Condition pre_condition,next_condition;

    RunPrint(ReentrantLock lock,Condition pre_condition,Condition next_condition){
        this.lock = lock;
        this.pre_condition = pre_condition;
        this.next_condition = next_condition;
    }

    @Override
    public void run() {
        while(i<26){
            lock.lock();
            try{
                next_condition.signalAll();
                pre_condition.await();
                System.out.println(Thread.currentThread().getName()+character++);
                i++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
