package AbstractFactoryPattern;

public class ColorFactory implements AbstractFactory{

    @Override
    public Shape createShape(String type) {
        return null;
    }

    @Override
    public Color createColor(String type) {
        if(type.equals("Red"))
            return new Red();
        else if(type.equals("Green"))
            return new Green();
        else
            return null;
    }
}
