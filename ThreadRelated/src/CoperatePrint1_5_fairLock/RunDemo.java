package CoperatePrint1_5_fairLock;

import java.util.concurrent.locks.ReentrantLock;

public class RunDemo {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock(true);
        Runnable r = new RunPrint(lock);
        /*int num = 0;
        try{
            System.out.println("try");
            return;
        }finally {
            num = 1;
            System.out.println(num);
            return;
        }*/
        new Thread(r,"1").start();
        new Thread(r,"2").start();
        new Thread(r,"3").start();
        new Thread(r,"4").start();
        new Thread(r,"5").start();
    }
}
