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

    private int width;
    public final void setWidth(int widthIn) { width = widthIn; }
    public final int getWidth() { return width; }

    private int height;
    public final void setHeight(int heightIn) { height = heightIn; }
    public final int getHeight() { return height; }

    private int positionx;
    public final void setPositionX(int positionXIn) { positionx = positionXIn; }
    public final int getPositionX() { return positionx; }
    
    private int positiony;
    public final void setPositionY(int positionYIn) { positiony = positionYIn; }
    public final int getPositionY() { return positiony; }

    abstract public double CalcArea();
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

}



public class ShapesStep1 {
    public static void main(String[] args) {
        System.out.println("ShapesStep1...");

        Rectangle myRectangle = new Rectangle(5, 3);

        double area = myRectangle.CalcArea();
        System.out.format("Area = %f\n", area);

    }

}