package AbstractFactoryPattern;

public class shapeFactory implements AbstractFactory{
    @Override
    public Shape createShape(String type) {
        if(type.equals("Square")){
            return new Square();
        }else if(type.equals("Circle")){
            return new Circle();
        }else
            return null;
    }

    @Override
    public Color createColor(String type) {
        return null;
    }
}
