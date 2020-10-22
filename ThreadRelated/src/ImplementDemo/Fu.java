package ImplementDemo;

public abstract class Fu {
    static {
        System.out.println("class Fu is loaded");
    }
    public abstract void methodA();
    public abstract void methodB();
    public final void method(){
        System.out.println("call final method of Fu");
    }
    public void methodC(){
        System.out.println("this is method C of Fu");
    }

}

