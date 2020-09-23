public class PrintOddEven {
    public static void main(String[] args) {
        Counter counter = new Counter();
        new Thread(new PrintOdd(counter)).start();
        new Thread(new PrintEven(counter)).start();
    }
}

class PrintOdd implements Runnable {
    public Counter counter;
    public PrintOdd(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        while (counter.val <= 100) {
            synchronized(counter) {
                if (counter.isOdd) {
                    System.out.println(counter.val);
                    counter.val++;
                    counter.isOdd = !counter.isOdd;
                    //很重要，要去唤醒打印偶数的线程
                    counter.notify();
                }
                try {
                    counter.wait();
                } catch (InterruptedException e) {}
            }
        }
    }
}
class PrintEven implements Runnable {
    public Counter counter;
    public PrintEven(Counter counter) {
        this.counter = counter;
    }
    @Override
    public void run() {
        while (counter.val <= 100) {
            synchronized (counter) {
                if (!counter.isOdd) {
                    System.out.println(counter.val);
                    counter.val++;
                    counter.isOdd = !counter.isOdd;
                    counter.notify();
                }
                try {
                    counter.wait();
                } catch (InterruptedException e) {}
            }
        }
    }
}
