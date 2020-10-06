package CoperatePrint1_5_ThreadName;

public class RunDemo {
    public static void main(String[] args) {
        Runnable r = new RunPrint();
        Thread t1 = new Thread(r,"1");
        Thread t2 = new Thread(r,"2");
        Thread t3 = new Thread(r,"3");
        Thread t4 = new Thread(r,"4");
        Thread t5 = new Thread(r,"5");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
