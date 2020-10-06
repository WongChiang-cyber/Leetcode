package CoperatePrintA_Z_ThreadName;

public class RunDemo {
    public static void main(String[] args) {
        Runnable r = new RunPrint();
        Thread t1 = new Thread(r,"1");
        Thread t2 = new Thread(r,"2");
        Thread t3 = new Thread(r,"3");
        t1.start();
        t2.start();
        t3.start();
    }
}
