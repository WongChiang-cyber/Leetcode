package CoperatePrint1_5_ThreadName;

public class RunPrint implements Runnable{

    private static int num = 0;

    @Override
    public void run() {
        int id = Integer.parseInt(Thread.currentThread().getName());
        synchronized (this){
            try{
                while(num<100){
                    if(num%5 == id-1){
                        System.out.println("Thread "+Thread.currentThread().getName()+" "+num++);
                        this.notifyAll();
                    }else
                        this.wait();
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }
    }
}
