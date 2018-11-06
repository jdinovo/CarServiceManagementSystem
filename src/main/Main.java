package main;
import database.DBConst;
import javafx.application.Application;
import javafx.stage.Stage;
import scenes.LoginScene;
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
		if(DBConst.loginLoad()) {
			window.setScene(new MainMenuScene());
		} else {
			window.setScene(new LoginScene());
		}
		window.setTitle("Car Service Management System");
		window.setResizable(false);
		window.centerOnScreen();
		window.show();
	}

}
