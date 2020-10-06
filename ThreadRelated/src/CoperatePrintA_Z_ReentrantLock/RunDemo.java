package CoperatePrintA_Z_ReentrantLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class RunDemo {
    public static void main(String[] args) {
        ReentrantLock lock =new ReentrantLock();
        Condition conditionA = lock.newCondition();
        Condition conditionB = lock.newCondition();
        Condition conditionC = lock.newCondition();
        Runnable A = new RunPrint(lock,conditionA,conditionB);
        Runnable B = new RunPrint(lock,conditionB,conditionC);
        Runnable C = new RunPrint(lock,conditionC,conditionA);
        Thread t1 = new Thread(A,"1");
        Thread t2 = new Thread(B,"2");
        Thread t3 = new Thread(C,"3");
        t1.start();
        t2.start();
        t3.start();
    }
}
