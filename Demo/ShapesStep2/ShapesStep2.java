import java.util.ArrayList;


abstract class Shape{

    public Shape() {
        this(0,0,0,0);
    }

    public Shape(int widthIn, int heightIn) {
            this(widthIn, heightIn, 0 ,0);
    }


    public Shape(int widthIn, int heightIn, int positionXIn, int positionYIn) {
        
        setWidth(widthIn);
        setHeight(heightIn);
        setPositionX(positionXIn);
        setPositionY(positionYIn);
    }

    
    private int positionx;
    public final void setPositionX(int positionXIn) { positionx = positionXIn; }
    public final int getPositionX() { return positionx; }
    
    private int positiony;
    public final void setPositionY(int positionYIn) { positiony = positionYIn; }
    public final int getPositionY() { return positiony; }

    private int width;
    public final void setWidth(int widthIn) { width = widthIn; }
    public final int getWidth() { return width; }

    private int height;
    public final void setHeight(int heightIn) { height = heightIn; }
    public final int getHeight() { return height; }

    abstract public double CalcArea();
    abstract public double CalcPerimeter();

    public String toString() {
        return String.format("positionX=%d, positionY=%d, width=%d, height=%d", positionx, positiony, width, height);
    }
}

class Rectangle extends Shape{
   
    public Rectangle(int widthIn, int heightIn) {
    super(widthIn, heightIn);
    }


    public Rectangle(){
        this(0,0);
    }


    public double CalcArea() {
        return getWidth() * getHeight();
    }

    public double CalcPerimeter() {
        return (getWidth() * 2) + (getHeight() * 2);
    }

}

class Circle extends Shape {
    private int radius;

    public final void setRadius(int radiusIn) {
        radius = radiusIn;
        setWidth(radiusIn*2);
        setHeight(radiusIn*2);
        }

    public final int getRadius() { return radius; }

    Circle() {
        this(0);
    }

    Circle(int radiusIn) {
        setRadius(radiusIn);

    }

    public String toString() {
        String superToString = super.toString();
        return String.format("%s, radius=%d", superToString, radius);
    }

    public double CalcArea() {
        return Math.PI * radius * radius;
    }

    public double CalcPerimeter() {
        return 2 * Math.PI * radius;
    }
}

public class ShapesStep2 {
    public static void main(String[] args) {
        ArrayList<Shape> shapeList = new ArrayList<Shape>();

        for (int loopCount=1; loopCount<4; loopCount++) {
            shapeList.add(new Circle(loopCount));
            shapeList.add(new Rectangle(10-loopCount, 4));
        }

        for (Shape s: shapeList) {
            System.out.println(s);
            System.out.format("Area = %.1f\n", s.CalcArea());
            System.out.format("Perimeter = %.1f\n", s.CalcPerimeter());

        }

    }

}