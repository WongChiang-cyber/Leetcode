package Practice;

public class ObjectDemo {

    private  static Integer a;

    public static void main(String[] args) {
        a = 10;
        func(a);
        System.out.println(a);
    }

    public static void func(Integer a){
        a = 11;
    }
}
