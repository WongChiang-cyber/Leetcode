package ThreadDemos;

import javax.swing.plaf.TableHeaderUI;
import java.util.Vector;

public class Main03SellTicket {

    public static int ticket = 0;
    static Runnable r;
    public static Object lock;

    public static void main(String[] args) {
        ticket=100;
        lock = new Object();
        r = new Runnable() {
            @Override
            public void run() {
                while(true){
                    synchronized (lock){
                        if(ticket>0){
                            System.out.println(Thread.currentThread().getName()+"正在卖第"+ticket+"张票");
                            ticket--;
                        }else{
                            break;
                        }
                    }

                }
            }
        };

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        Thread t3 = new Thread(r);

        t1.start();
        t2.start();
        t3.start();

        Vector<Integer> v = new Vector<>();
    }
}

