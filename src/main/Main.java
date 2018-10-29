package main;
import javafx.application.Application;
import javafx.stage.Stage;
import scenes.MainMenuScene;

/**
 * 
 * @author James DiNovo
 * @date 17.10.2018
 * @version 1.0
 * 
 * Launches the application and switches between scenes
 *
 */
public class Main extends Application {
	
	public static Stage window;

	/**
	 * 
	 * @author James DiNovo
	 * @date 17.10.2018
	 * @version 1.0
	 * 
	 * Launches Application
	 *
	 */
	public static void main(String[] args) {
		Application.launch(args);
	}

	/**
	 * 
	 * @author James DiNovo
	 * @date 17.10.2018
	 * @version 1.0
	 * 
	 * Switches between Scenes
	 *
	 */
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		
		window.setScene(new MainMenuScene());
		window.setTitle("Car Service Management System");
		window.centerOnScreen();
		window.show();
	}

}
