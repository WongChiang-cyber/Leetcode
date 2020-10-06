package CoperatePrint1_5_synchronized_block;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        PrintClass print = new PrintClass();
        Runnable r1 = new RunA(print);
        Runnable r2 = new RunB(print);
        Runnable r3 = new RunC(print);
        Runnable r4 = new RunD(print);
        Runnable r5 = new RunE(print);
        Thread t1 = new Thread(r1,"1");
        Thread t2 = new Thread(r2,"2");
        Thread t3 = new Thread(r3,"3");
        Thread t4 = new Thread(r4,"4");
        Thread t5 = new Thread(r5,"5");
        t1.start();
        //Thread.sleep(500);
        t2.start();
        //Thread.sleep(500);
        t3.start();
        //Thread.sleep(500);
        t4.start();
        //Thread.sleep(500);
        t5.start();
    }
}
class RunA implements Runnable{
    PrintClass print;
    RunA(PrintClass print){
        this.print = print;
    }
    @Override
    public void run() {
        print.print1();
    }
}
class RunB implements Runnable{
    PrintClass print;
    RunB(PrintClass print){
        this.print = print;
    }
    @Override
    public void run() {
        print.print2();
    }
}
class RunC implements Runnable{
    PrintClass print;
    RunC(PrintClass print){
        this.print = print;
    }
    @Override
    public void run() {
        print.print3();
    }
}
class RunD implements Runnable{
    PrintClass print;
    RunD(PrintClass print){
        this.print = print;
    }
    @Override
    public void run() {
        print.print4();
    }
}
class RunE implements Runnable{
    PrintClass print;
    RunE(PrintClass print){
        this.print = print;
    }
    @Override
    public void run() {
        print.print5();
    }
}