package SinglePattern;

public class SingletonDemo {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        singleton.key = 10;
        singleton.val = "val";
    }
}
