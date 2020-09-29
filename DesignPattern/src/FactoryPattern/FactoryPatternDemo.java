package FactoryPattern;

public class FactoryPatternDemo {
    public static void main(String[] args) {
        Shape square = ShapeFactory.getShape("Square");
        System.out.println(square.getInfo());
        
    }
}
