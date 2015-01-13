import javafx.application.Application;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * a paint application named PaintFX
 * @author Nitant Dandekar
 * @version 1
 */
public class PaintFX extends Application {
    /**
     * launches the application
     * @param args arguments to the application
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * starts the application
     * @param primaryStage primary stage
     */
    @Override
    public void start(Stage primaryStage) {
        Pane main = new Pane();
        primaryStage.setScene(new Scene(main));
        primaryStage.setTitle("PaintFX");

        Canvas canvas = new Canvas(512, 512);
        main.getChildren().add(canvas);
        canvas.widthProperty().bind(main.widthProperty());
        canvas.heightProperty().bind(main.heightProperty());

        Stage controlsStage = new Stage();
        HBox controls = new HBox(5);
        Button clearCanvas = new Button("clear");
        HBox controlSettings = new HBox();
        TextField lineWidth = new TextField("1.0");
        ColorPicker colorPicker = new ColorPicker(Color.BLACK);
        clearCanvas.setOnAction(event -> {
                canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth()
                    , canvas.getHeight());
            });
        lineWidth.setOnAction(event -> {
                double width;

                try {
                    width = Double.parseDouble(lineWidth.getText());
                } catch (NumberFormatException e) {
                    width = canvas.getGraphicsContext2D().getLineWidth();
                    lineWidth.setText(Double.toString(width));
                }

                canvas.getGraphicsContext2D().setLineWidth(width);
            });
        colorPicker.setOnAction(event -> {
                canvas.getGraphicsContext2D().setStroke(colorPicker.getValue());
                canvas.getGraphicsContext2D().setFill(colorPicker.getValue());
            });
        controlsStage.setScene(new Scene(controls));
        controlsStage.setTitle("PaintFX");
        controls.getChildren().add(clearCanvas);
        controls.getChildren().add(controlSettings);
        controlSettings.getChildren().add(lineWidth);
        controlSettings.getChildren().add(colorPicker);

        DrawTools drawTools = new DrawTools(canvas);
        controls.getChildren().add(drawTools.getButtons());

        drawTools.addTool(new PencilTool(), "Pencil");
        drawTools.addTool(new LineTool(), "Line");
        drawTools.addTool(new StrokeRectangleTool(), "Rectangle");
        drawTools.addTool(new FilledRectangleTool(), "Filled Rectangle");
        drawTools.addTool(new StrokeOvalTool(), "Oval");
        drawTools.addTool(new FilledOvalTool(), "Filled Oval");

        primaryStage.show();
        controlsStage.show();

        controlsStage.setResizable(false);
    }
}
