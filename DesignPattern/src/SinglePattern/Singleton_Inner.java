package SinglePattern;

public class Singleton_Inner {

    public static int key;
    public static int value;

    private Singleton_Inner(){}

    private static class SingletonHolder{
        private static Singleton_Inner instance = new Singleton_Inner();
    }

    public static Singleton_Inner getInstance(){
        return SingletonHolder.instance;
    }

}
