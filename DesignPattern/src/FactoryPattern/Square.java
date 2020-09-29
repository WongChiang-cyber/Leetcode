package FactoryPattern;

public class Square implements Shape{

    final private float width;
    final private float height;

    Square(float width,float height){
        this.height = height;
        this.width = width;
    }

    @Override
    public void draw() {
        System.out.println("draw a square");
    }

    @Override
    public String getInfo() {
        return "width="+width+"height="+height;
    }
}
