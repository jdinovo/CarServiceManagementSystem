package scenes;

import javafx.scene.Scene;
import main.Construct;
import panes.CustomerInfoPane;


/**
 * @author Chris Dias
 * @date 10.31.2018
 * @version 1.0
 *
 * Scene that launches the New Work Order Pane
 */
public class CustomerInfoScene extends Scene {

    /**
     * @author Chris Dias
     * @date 10.31.2018
     * @version 1.0
     *
     * Construct for new work order scene
     */
    public CustomerInfoScene() {
        super(new CustomerInfoPane(), Construct.SCREEN_WIDTH, Construct.SCREEN_HEIGHT);
    }

}
