package CoperatePrintA_Z_ThreadName;

public class RunPrint implements Runnable{

    private static char character = 'A';
    private static int i = 0;

    @Override
    public void run() {
        int id = Integer.parseInt(Thread.currentThread().getName());
        synchronized (this){
            while(i<=26){
                if(i%3==id-1){
                    if(i!=26)
                        System.out.println(Thread.currentThread().getName()+(character++));
                    else
                        System.out.println("finish");
                    i++;
                    this.notifyAll();
                }else{
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
