import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

/**
 * a tool that draws
 * @author Nitant Dandekar
 * @version 1
 */
public class PencilTool implements Tool {
    private double currentX;
    private double currentY;
    private static final String TOOL_NAME = "Pencil";

    /**
     * on press, get the first position
     * @param e the press MouseEvent
     * @param g the GraphicsContext to draw with
     */
    public void onPress(MouseEvent e, GraphicsContext g) {
        currentX = e.getX();
        currentY = e.getY();
    }

    /**
     * on drag, update position and draw more
     * @param e the drag MouseEvent
     * @param g the GraphicsContext to draw with
     */
    public void onDrag(MouseEvent e, GraphicsContext g) {
        g.strokeLine(currentX, currentY, e.getX(), e.getY());

        currentX = e.getX();
        currentY = e.getY();
    }

    /**
     * on release, do nothing
     * @param e the release MouseEvent
     * @param g the GraphicsContext to draw with
     */
    public void onRelease(MouseEvent e, GraphicsContext g) {

    }

    /**
     * get the name of the tool
     * @return the name of the tool
     */
    public String getName() {
        return TOOL_NAME;
    }
}
