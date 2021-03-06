import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

/**
 * a tool that draws empty rectangles
 * @author Nitant Dandekar
 * @version 1
 */
public class StrokeRectangleTool implements Tool {
    private double startX;
    private double startY;
    private double endX;
    private double endY;
    private static final String TOOL_NAME = "StrokeRectangle";

    /**
     * on press, grab a position for the first corner
     * @param e the press MouseEvent
     * @param g the GraphicsContext to draw with
     */
    public void onPress(MouseEvent e, GraphicsContext g) {
        startX = e.getX();
        startY = e.getY();
        endX = e.getX();
        endY = e.getY();
    }

    /**
     * on drag, grab a position for the opposing corner
     * @param e the drag MouseEvent
     * @param g the GraphicsContext to draw with
     */
    public void onDrag(MouseEvent e, GraphicsContext g) {
        endX = e.getX();
        endY = e.getY();
    }

    /**
     * on release, draw the line with the coordinates we gathered earlier
     * @param e the release MouseEvent
     * @param g the GraphicsContext to draw with
     */
    public void onRelease(MouseEvent e, GraphicsContext g) {
        double topLeftX = startX < endX ? startX : endX;
        double topLeftY = startY < endY ? startY : endY;
        double bottomRightX = startX < endX ? endX : startX;
        double bottomRightY = startY < endY ? endY : startY;

        g.strokeRect(topLeftX, topLeftY, bottomRightX - topLeftX
            , bottomRightY - topLeftY);
    }

    /**
     * get the name of the tool
     * @return the name of the tool
     */
    public String getName() {
        return TOOL_NAME;
    }
}
