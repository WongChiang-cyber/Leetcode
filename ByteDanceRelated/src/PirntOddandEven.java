public class PirntOddandEven {
    public static void main(String[] args) throws InterruptedException {
        Counter c = new Counter();
        Thread t1 = new Thread(new RunEven(c));
        Thread t2 = new Thread(new RunOdd(c));
        t2.start();
        t1.start();
    }
}

class Counter{
    int val = 1;
    boolean isOdd = true;
}

class RunEven implements Runnable{
    public Counter counter;
    public RunEven(Counter c){
        this.counter = c;
    }
    @Override
    public void run() {
        while(counter.val<=100) {
            synchronized (counter){
                if(!counter.isOdd){
                    System.out.println(counter.val);
                    counter.isOdd = !counter.isOdd;
                    counter.val++;
                    counter.notify();
                }
                try {
                    if(counter.val<=100)
                        counter.wait();
                    else
                        return;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class RunOdd implements Runnable{

    public Counter counter;

    public RunOdd(Counter c){
        this.counter = c;
    }
    @Override
    public void run() {
        while(counter.val<=100) {
            synchronized (counter) {
                if (counter.isOdd) {
                    System.out.println(counter.val);
                    counter.val++;
                    counter.isOdd = !counter.isOdd;
                    counter.notify();
                }
                try {
                    if(counter.val<=100)
                    counter.wait();
                    else
                        return;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}