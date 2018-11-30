package scenes;

import javafx.scene.Scene;
import main.Construct;
import panes.MainMenuPane;

/**
 *
 * Scene that launches main menu
 *
 * @author James DiNovo
 * @date 17.10.2018
 * @version 1.0
 *
 */
public class MainMenuScene extends Scene {

	/**
	 *
	 * Constructor for MainMenuScene which sets MainMenuPane
	 *
	 * @author James DiNovo
	 * @date 17.10.2018
	 * @version 1.0
	 *
	 */
	public MainMenuScene() {
		super(new MainMenuPane(), Construct.SCREEN_WIDTH, Construct.SCREEN_HEIGHT);
		this.getStylesheets().add("/styles/Main.css");
	}
	
}
