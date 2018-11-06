package scenes;

import javafx.scene.Scene;
import main.Construct;
import panes.LoginPane;

/**
 *
 * @author James DiNovo
 * @date 05.11.2018
 * @version 1.0
 *
 * LoginScene holds LoginPane
 *
 */
public class LoginScene extends Scene {

    /**
     *
     * @author James DiNovo
     * @date 05.11.2018
     * @version 1.0
     *
     * Constructor for LoginScene
     *
     */
    public LoginScene() {
        super(new LoginPane(), Construct.SCREEN_WIDTH, Construct.SCREEN_HEIGHT);
    }
}
