import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

public class PieChart extends Circle {
    private int n;    // number of events
    private double[] probabilityOfEvents;
    private double[] centralAngleOfSegments;
    private char[] typesOfEvents;
    private Color[] colorList = {Color.BLUE, Color.BROWN,Color.PURPLE,
            Color.ORANGE,Color.STEELBLUE,Color.DARKVIOLET,Color.LIGHTCORAL,
            Color.DARKSALMON,Color.DARKGOLDENROD, Color.DARKOLIVEGREEN,
            Color.DARKBLUE,Color.DARKSLATEGRAY,Color.LAWNGREEN,
            Color.DARKORANGE,Color.VIOLET,Color.BLUEVIOLET,Color.PURPLE,
            Color.BLACK,Color.CHOCOLATE,Color.DARKGREY, Color.DARKOLIVEGREEN,
            Color.DARKKHAKI,Color.DARKORANGE,Color.CORNSILK,Color.DARKMAGENTA,
            Color.BLANCHEDALMOND};

    // constructor
    public PieChart(double x, double y, Color strokeColor, double radius,int n,
                    double[] probabilityOfEvents, char[] typesOfEvents){
        super(x,y,strokeColor,radius);
        this.n = n;
        this.probabilityOfEvents = probabilityOfEvents;
        this.typesOfEvents = typesOfEvents;
    }

    private void calculateCentralAngleOfSegment(){
        centralAngleOfSegments = new double[n];
//        sort(probabilityOfEvents);
        for(int i = 0; i < n; i++) {
            centralAngleOfSegments[i] = Math.toDegrees(2 * Math.PI * probabilityOfEvents[i]);
        }
    }

    // draw method
    @Override
    public void draw(GraphicsContext gc, double width, double height) {
        calculateCentralAngleOfSegment();

        double startAngle = 90;
        for (int i = 0; i < 20; i++){
            // Fill arc
            gc.setFill(colorList[i]);
            gc.strokeArc(getX() - getRadius(),getY()-getRadius(),getRadius()*2,
                    getRadius()*2,startAngle,-centralAngleOfSegments[i],ArcType.ROUND);
            gc.fillArc(getX() - getRadius(),getY()-getRadius(),getRadius()*2,
                    getRadius()*2,startAngle,-centralAngleOfSegments[i],ArcType.ROUND);


            // update startAngle for next event
            startAngle = startAngle -  centralAngleOfSegments[i];
        }

        for (int i = 20; i < 26; i++) {
            // Fill arc
            gc.setFill(colorList[20]);
            gc.fillArc(getX() - getRadius(), getY() - getRadius(), getRadius() * 2,
                    getRadius() * 2, startAngle, -centralAngleOfSegments[i], ArcType.ROUND);

            // update startAngle for next event
            startAngle = startAngle - centralAngleOfSegments[i];
        }


    }

    public  void addLegend(GraphicsContext gc, double width, double height){
        calculateCentralAngleOfSegment();

        gc.setFont(new javafx.scene.text.Font(9.5));

        double startAngle = 90;

        for (int i = 0; i < 20; i++){

            if(probabilityOfEvents[i] < 0.01 ){
                continue;
            }
            gc.setFill(colorList[i]);
            if(startAngle >= 0 && startAngle <=90){
                gc.fillText(String.valueOf(typesOfEvents[i]) +": " +
                                String.valueOf(Math.round(probabilityOfEvents[i]*10000.0)/10000.0),
                        width/2 + 1.1*getRadius()*Math.cos(Math.toRadians(startAngle)) + 2 ,
                        height/2 - 1.1*getRadius()*Math.sin(Math.toRadians(startAngle))  - 2);
            }
            else if(startAngle >= -90 && startAngle <= 0){
                gc.fillText(String.valueOf(typesOfEvents[i]) +": " +
                                String.valueOf(Math.round(probabilityOfEvents[i]*10000.0)/10000.0),
                        width/2 + 1.1*getRadius()*Math.cos(Math.toRadians(startAngle)) + 2 ,
                        height/2 - 1.1*getRadius()*Math.sin(Math.toRadians(startAngle)) + 2);
            }
            else if(startAngle >= -180 && startAngle <=-90){
                gc.fillText(String.valueOf(typesOfEvents[i]) +": " +
                                String.valueOf(Math.round(probabilityOfEvents[i]*10000.0)/10000.0),
                        width/2 + 1.2*getRadius()*Math.cos(Math.toRadians(startAngle ) )  ,
                        height/2 - 1.2*getRadius()*Math.sin(Math.toRadians(startAngle )) );
            }
            else if (startAngle >= -270 && startAngle <=-180){
                gc.fillText(String.valueOf(typesOfEvents[i]) +": " +
                                String.valueOf(Math.round(probabilityOfEvents[i]*10000.0)/10000.0),
                        width/2 + 1.2*getRadius()*Math.cos(Math.toRadians(startAngle ) )   ,
                        height/2 - 1.2*getRadius()*Math.sin(Math.toRadians(startAngle )) );
            }
            startAngle = startAngle -  (centralAngleOfSegments[i]);
        }

        gc.setFill(colorList[20]);
        double probabilityOfEventsRestOfEvents = 0;
        for(int i = 20; i <= 25;i++) {
            probabilityOfEventsRestOfEvents += probabilityOfEvents[i];
        }
        gc.fillText("Rest of Events" + ": " +
                        String.valueOf(Math.round(probabilityOfEventsRestOfEvents * 10000.0) / 10000.0),
                width / 2 + 1.2 * getRadius() * Math.cos(Math.toRadians(startAngle)),
                height / 2 - 1.2 * getRadius() * Math.sin(Math.toRadians(startAngle)));

    }

    public void sort(double A[]) {
        int n = A.length;
        for (int i=1; i<n; ++i)
        {
            double key = A[i];
            int j = i-1;

            while (j>=0 && A[j] < key)
            {
                A[j+1] = A[j];
                j = j-1;
            }
            A[j+1] = key;
        }
    }

}
