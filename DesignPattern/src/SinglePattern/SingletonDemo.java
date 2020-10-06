package SinglePattern;

public class SingletonDemo {
    public static void main(String[] args) {
        Singleton_DCL singletonDCL = Singleton_DCL.getInstance();
        singletonDCL.key = 10;
        singletonDCL.val = "val";

        Singleton_Inner singleton_inner = Singleton_Inner.getInstance();
        Singleton_Inner.key = 100;
        Singleton_Inner.value = 20;
    }
}
