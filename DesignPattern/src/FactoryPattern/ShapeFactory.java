package FactoryPattern;

public class ShapeFactory {
    public static Shape getShape(String shapeName){
        if(shapeName==null)
            return null;
        else if(shapeName.equals("Circle")){
            return new Circle(0);
        }else if(shapeName.equals("Square")){
            return new Square(0,0);
        }else if(shapeName.equals("Triangle")){
            return new Triangle(0,0,0);
        }else
            return null;
    }

}
