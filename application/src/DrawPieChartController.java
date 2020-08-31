import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.event.ActionEvent;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.control.TextField;


public class DrawPieChartController {
    
    @FXML
    private TextField numberEventsTextField;
    @FXML
    private Canvas canvas;
    @FXML
    void drawShapesButtonPressed(ActionEvent event) {
        GraphicsContext gc = canvas.getGraphicsContext2D();

        double centerY = canvas.getWidth()/2;
        double centerX = canvas.getHeight()/2;
        double canvasWidth = canvas.getWidth();
        double canvasHeight = canvas.getHeight();


            int n = Integer.parseInt(numberEventsTextField.getText());
            // Polygon and circle 1
            Color color1 = Color.LIGHTGREEN;
            Color color2 = Color.LIGHTBLUE;
            double radius1 = canvasHeight / 3;

            HistogramLetters EmmaHL = new HistogramLetters();

            EmmaHL.fileProcessor();
            EmmaHL.printLettersCount();
            EmmaHL.calculateProbabilityOfEvents();

            EmmaHL.printProbabilityOfEvents();

            Circle circle1 = new Circle(centerX, centerY, color2, radius1);

            System.out.println("Number of events input from GUI: " + numberEventsTextField.getText());
            circle1.draw(gc, 2 * radius1, 2 * radius1);

            PieChart PieChart1 = new PieChart(centerX, centerY, Color.BLUE, radius1, n,
                    EmmaHL.calculateProbabilityOfEvents(), EmmaHL.getTypesOfEvents());
            PieChart1.draw(gc, canvasWidth, canvasHeight);
            PieChart1.addLegend(gc, canvasWidth, canvasHeight);


    }
}
