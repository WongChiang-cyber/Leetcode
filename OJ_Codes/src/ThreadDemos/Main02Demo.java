package ThreadDemos;

import java.util.concurrent.*;

public class Main02Demo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableDemo01 c1 = new CallableDemo01(1,2);
        CallableDemo01 c2 = new CallableDemo01(3,4);
        ExecutorService service = Executors.newFixedThreadPool(2);
        Future f = service.submit(c1);
        System.out.println("sum="+f.get().toString());
        Future f2 = service.submit(c2);
        System.out.println("sum="+f2.get().toString());
        service.shutdown();
    }
}
