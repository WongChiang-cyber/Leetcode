package SinglePattern;

public class Singleton_DCL {
    private static volatile Singleton_DCL singletonDCL;
    public Integer key;
    public String val;
    private Singleton_DCL(){}

    public static Singleton_DCL getInstance(){
        if(singletonDCL ==null){
            synchronized (Singleton_DCL.class){
                if(singletonDCL ==null){
                    singletonDCL = new Singleton_DCL();
                }
            }
        }
        return singletonDCL;
    }
}
