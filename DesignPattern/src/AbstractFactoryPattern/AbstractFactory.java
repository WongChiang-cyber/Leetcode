package AbstractFactoryPattern;

public interface AbstractFactory {
    public Shape createShape(String type);
    public Color createColor(String type);
}
