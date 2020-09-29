package FactoryPattern;

public class Circle implements Shape{

    final private float redis;

    Circle(float redis){
        this.redis = redis;
    }

    @Override
    public void draw() {
        System.out.println("draw a circle");
    }

    @Override
    public String getInfo() {
        return "redis="+redis;
    }
}
