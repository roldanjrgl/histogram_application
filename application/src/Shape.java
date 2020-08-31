import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

public class Shape {

    // instance variable
    private double x;
    private double y;
    private Color strokeColor;

    //constructor
    Shape(double x, double y, Color strokeColor){
        this.x = x;
        this.y = y;
        this.strokeColor = strokeColor;
    }

    // get methods
    double getX(){ return this.x; }

    double getY(){
        return this.y;
    }

    Color getColor(){
        return this.strokeColor;
    }

    // set methods
    public void setX(double x){ this.x  = x;
    }

    public void setY(double y){
        this.y  = y;
    }

    public void setColor(Color strokeColor){
        this.strokeColor  = strokeColor;
    }


    // shift methods
    public void shiftX(double deltaX){
        this.x = this.x + deltaX;
    }

    public void shiftY(double deltaY){
        this.y = this.y + deltaY;
    }


    // toString method
    @Override
    public String toString(){
        return String.format("%s: %n%s %.1f%n%s %.1f%n%s%s",
                "shape","x:",getX(),"y:",getY(),"color: ",getColor());
    }

    // draw method
    public void draw(GraphicsContext gc, double canvasWidth, double canvasHeight){
        // set the color for the current arc
        gc.setFill(strokeColor);

        gc.fillRect(x - canvasWidth/2,y - canvasHeight/2,canvasWidth,canvasHeight);
    }
}
