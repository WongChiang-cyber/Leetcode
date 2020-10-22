package ImplementDemo;


public class Zi extends Fu implements MyInterface,MyInterface2{

    static {
        System.out.println("class Zi is loaded");
    }
    {
        System.out.println("this is no static block in Zi #1");
    }

    static int static_value = 10;

    @Override
    public void methodA() {

    }
    @Override
    public void methodB() {

    }

    Zi(){
        System.out.println("use Zi constructor");
    }

    {
        System.out.println("this is no static block in Zi #2");
    }

    @Override
    public void methodC(){
        System.out.println("this is method C of Zi");
    }

}
