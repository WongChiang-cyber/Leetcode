package Productor_and_customer_wait_notify;

import java.util.LinkedList;
import java.util.Queue;

public class TestDemo {

    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        Producer p1 = new Producer(3,queue);
        Producer p2 = new Producer(3,queue);
        Producer p3 = new Producer(3,queue);
        Customer c1 = new Customer(3,queue);
        Customer c2 = new Customer(3,queue);
        Customer c3 = new Customer(3,queue);

        Thread t1 = new Thread(p1,"1");
        Thread t2 = new Thread(p2,"2");
        Thread t3 = new Thread(p3,"3");

        Thread t4 = new Thread(c1,"4");
        Thread t5 = new Thread(c2,"5");
        Thread t6 = new Thread(c3,"6");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
    }
}
