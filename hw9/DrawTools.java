import java.util.HashMap;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

/**
 * drawing tools for Sketch
 * @author Nitant Dandekar
 * @version 1
 */
public class DrawTools {
    private Canvas canvas;
    private HashMap<String, Tool> tools;
    private HashMap<String, ToggleButton> toolToggleButtons;
    private ToggleGroup toolToggleGroup;
    private HBox toolTogglesDisplay;

    /**
     * create a set of tools
     * @param  canvas canvas the tools will operate on
     */
    public DrawTools(Canvas canvas) {
        this.canvas = canvas;

        this.tools = new HashMap<>();
        this.toolToggleButtons = new HashMap<>();
        this.toolToggleGroup = new ToggleGroup();
        this.toolTogglesDisplay = new HBox();

        this.canvas.setOnMouseDragged(this::onDrag);
        this.canvas.setOnMousePressed(this::onPress);
        this.canvas.setOnMouseReleased(this::onRelease);
    }

    /**
     * add a tool
     * @param tool  the tool
     * @param label the label on the tool's button
     */
    public void addTool(Tool tool, String label) {
        ToggleButton button = new ToggleButton(label);
        button.setUserData(tool.getName());

        tools.put(tool.getName(), tool);
        toolToggleButtons.put(tool.getName(), button);
        toolToggleGroup.getToggles().add(button);
        toolTogglesDisplay.getChildren().add(button);
    }

    /**
     * add a tool
     * @param tool the tool
     * @param icon the icon on the tool's button
     */
    public void addTool(Tool tool, Image icon) {
        ImageView image = new ImageView(icon);
        image.setFitWidth(32);
        image.setFitHeight(32);

        ToggleButton button = new ToggleButton("", image);
        button.setUserData(tool);

        tools.put(tool.getName(), tool);
        toolToggleButtons.put(tool.getName(), button);
        toolToggleGroup.getToggles().add(button);
        toolTogglesDisplay.getChildren().add(button);
    }

    /**
     * gets the buttons for the tools
     * @return the buttons
     */
    public HBox getButtons() {
        return toolTogglesDisplay;
    }

    /**
     * action to be performed when mouse is dragged on canvas
     * @param event the mouse event for the drag
     */
    private void onDrag(MouseEvent event) {
        Toggle toolToggle = toolToggleGroup.getSelectedToggle();

        if (toolToggle != null) {
            String toolName = (String) toolToggle.getUserData();
            tools.get(toolName).onDrag(event, canvas.getGraphicsContext2D());
        }
    }

    /**
     * action to be performed when mouse is pressed on canvas
     * @param event the mouse event for the press
     */
    private void onPress(MouseEvent event) {
        Toggle toolToggle = toolToggleGroup.getSelectedToggle();

        if (toolToggle != null) {
            String toolName = (String) toolToggle.getUserData();
            tools.get(toolName).onPress(event, canvas.getGraphicsContext2D());
        }
    }

    /**
     * action to be performed when mouse is released on canvas
     * @param event the mouse event for the release
     */
    private void onRelease(MouseEvent event) {
        Toggle toolToggle = toolToggleGroup.getSelectedToggle();

        if (toolToggle != null) {
            String toolName = (String) toolToggle.getUserData();
            tools.get(toolName).onRelease(event, canvas.getGraphicsContext2D());
        }
    }
}
