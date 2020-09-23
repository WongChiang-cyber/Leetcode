package ThreadDemos;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main01Demo {
    public static void main(String[] args) {
        Runnable r = new RunnableDemo01();
        ExecutorService service = Executors.newFixedThreadPool(2);
        Thread t1 = new Thread(r);
        t1.start();

        //使用线程池的第一种方式 利用runnable接口
        service.submit(r);
        service.submit(r);
        service.submit(r);

        service.shutdown();
    }


}
