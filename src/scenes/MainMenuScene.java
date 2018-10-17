package scenes;

import javafx.scene.Scene;
import main.Construct;
import panes.MainMenuPane;

/**
 * 
 * @author James DiNovo
 * @date 17.10.2018
 * @version 1.0
 * 
 * Scene that launches main menu
 *
 */
public class MainMenuScene extends Scene {

	/**
	 * 
	 * @author James DiNovo
	 * @date 17.10.2018
	 * @version 1.0
	 * 
	 * Constructor for MainMenuScene which sets MainMenuPane
	 *
	 */
	public MainMenuScene() {
		super(new MainMenuPane(), Construct.SCREEN_WIDTH, Construct.SCREEN_HEIGHT);
	}
	
}
