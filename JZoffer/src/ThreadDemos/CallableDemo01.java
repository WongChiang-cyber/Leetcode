package ThreadDemos;

import java.util.concurrent.Callable;

public class CallableDemo01 implements Callable {

    private int x = 3;
    private int y = 4;

    CallableDemo01(){
    }

    CallableDemo01(int x,int y){
        this.x = x;
        this.y = y;
    }
    @Override
    public Integer call() throws Exception {
        return x+y;
    }
}
