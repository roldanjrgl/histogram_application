import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

public class Circle extends Shape {
    private double radius;
    // constructor
    public Circle(double x, double y, Color strokeColor, double radius){
        super(x,y,strokeColor);
        this.radius = radius;
    }
    // area method
    public double getArea() {
        return Math.PI * radius * radius;
    }
    // perimeter method
    public double getPerimeter(){
        return 2*Math.PI*radius;
    }

    // return radius method
    public double getRadius(){ return this.radius; }

    // toString method
    @Override
    public String toString(){
       return String.format("%s %s%n%s%.1f%n%s%.1f", "circle",
               super.toString(),"radius: ",radius,"area: ", getArea());
    }
    // draw method
    @Override
    public void draw(GraphicsContext gc,double width, double height) {
        // set the color for the current arc
        gc.setFill(super.getColor());

        // Draw circle
        gc.strokeOval(super.getX() - width/2,super.getY()- height/2,2*radius,2*radius);
    }
}
