package ImplementDemo;

public interface MyInterface {
    final int final_value = 0;
    static int static_value = 1;
    static final int static_final_value = 2;
    public abstract void methodA();
    public abstract void methodB();
    default void default_method(){
        System.out.println("call default method in MyInterface");
    }
}
