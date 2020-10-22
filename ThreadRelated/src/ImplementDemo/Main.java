package ImplementDemo;

/**
 * @Description:
 * 结论1：抽象父类/继承接口中可以存在同名的函数，但是返回值必须相同，否则编译不能够通过
 * 结论2：static语句块在class类对象载入时将会调用，载入类对象的时机可以是使用类对象中的静态值/new 一个对象实例
 *       非static 语句块在每次创建对象实例时进行调用，根据书写的位置依次执行，最后执行自定义的constructor
 * 结论3：无论是父类引用/子类引用/孙子类引用，都使用就近原则，以实际调用的constructor为准，采用new出的类中重写的方法
 * 结论4：以final修饰的父类方法不能重写，只能调用
 * 结论5：接口中的final变量不可以直接在实现类中进行使用（某个实现接口的实现类的方法中，不能访问他继承的接口中的final值，因为此时接口没有实例化），
 *          需要使用，采用Interface i = new 实现类()，i。final_val进行访问。
 * @Param:
 * @return:
 * @Author: WongChiang
 * @Date: 2020/10/20
 */
public class Main {
    public static void main(String[] args) {
        Fu f = new Zi();
        Zi z = new Zi();
        Sun s = new Sun();
        z.method();
        s.method();
        f.methodC();
        z.methodC();
        s.methodC();
        s.default_method();
    }
}
