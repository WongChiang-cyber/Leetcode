package CoperatePrint1_5_synchronized_block;

public class PrintClass {

    private static volatile Integer num = 1;
    private final int PRINT_ROUND = 3;

    public void print1(){
        for (int i = 0; i < PRINT_ROUND; i++) {
            synchronized (this){
                try{
                    while(num!=1){
                        this.wait();
                    }
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("Thread"+Thread.currentThread().getName()+" "+num);
                num = 2;
                this.notifyAll();
            }
        }
    }
    public void print2(){
        for (int i = 0; i < PRINT_ROUND; i++) {
            synchronized (this){
                try{
                    while(num!=2){
                        this.wait();
                    }
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("Thread"+Thread.currentThread().getName()+" "+num);
                num = 3;
                this.notifyAll();
            }
        }
    }
    public void print3(){
        for (int i = 0; i < PRINT_ROUND; i++) {
            synchronized (this){
                try{
                    while(num!=3){
                        this.wait();
                    }
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("Thread"+Thread.currentThread().getName()+" "+num);
                num = 4;
                this.notifyAll();
            }
        }
    }
    public void print4(){
        for (int i = 0; i < PRINT_ROUND; i++) {
            synchronized (this){
                try{
                    while(num!=4){
                        this.wait();
                    }
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("Thread"+Thread.currentThread().getName()+" "+num);
                num = 5;
                this.notifyAll();
            }
        }
    }
    public void print5(){
        for (int i = 0; i < PRINT_ROUND; i++) {
            synchronized (this){
                try{
                    while(num!=5){
                        this.wait();
                    }
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("Thread"+Thread.currentThread().getName()+" "+num);
                num = 1;
                this.notifyAll();
            }
        }
    }
}
