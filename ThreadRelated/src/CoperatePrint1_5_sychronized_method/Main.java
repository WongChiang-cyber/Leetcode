package CoperatePrint1_5_sychronized_method;

public class Main{
    public static void main(String[] args) throws Exception{
        PrintClass print = new PrintClass();
        Runnable r0 = new Run(print,0);
        Runnable r1 = new Run(print,1);
        Runnable r2 = new Run(print,2);
        Runnable r3 = new Run(print,3);
        Runnable r4 = new Run(print,4);
        Runnable r5 = new Run(print,5);
        Thread t0 = new Thread(r0,"0");
        Thread t1 = new Thread(r1,"1");
        Thread t2 = new Thread(r2,"2");
        Thread t3 = new Thread(r3,"3");
        Thread t4 = new Thread(r4,"4");
        Thread t5 = new Thread(r5,"5");
        t0.start();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}

class PrintClass {
    public int num = 0;
    public void print(){
        System.out.println("Thread"+Thread.currentThread().getName()+" "+num);
    }
}
class Run implements Runnable{

    final PrintClass print;
    final int NUM;
    final static int ROUND = 3;

    Run(PrintClass print,int num){
        this.print = print;
        this.NUM = num;
    }
    @Override
    public void run() {
        for (int i = 0; i < ROUND; i++) {
            synchronized (print){
                while (print.num !=NUM){
                    try {
                        print.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                print.print();
                print.num=(print.num+1)%6;
                print.notifyAll();
            }
        }
    }
}
