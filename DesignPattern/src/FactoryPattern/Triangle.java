package FactoryPattern;

public class Triangle implements Shape{

    final private float edge1;
    final private float edge2;
    final private float edge3;

    Triangle(float e1,float e2,float e3){
        this.edge1 = e1;
        this.edge2 = e2;
        this.edge3 = e3;
    }

    @Override
    public void draw() {
        System.out.println("draw a triangle");
    }

    @Override
    public String getInfo() {
        return "e1="+edge1+" e2="+edge2+" e3="+edge3;
    }
}
