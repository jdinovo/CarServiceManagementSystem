package main;
import database.Login;
import javafx.application.Application;
import javafx.stage.Stage;
import scenes.LoginScene;
import scenes.MainMenuScene;

/**
 *
 * Launches the application and switches between scenes
 *
 * @author James DiNovo
 * @date 17.10.2018
 * @version 1.0
 *
 */
public class Main extends Application {
	
	public static Stage window;

	/**
	 *
	 * Launches Application
	 *
	 * @author James DiNovo
	 * @date 17.10.2018
	 * @version 1.0
	 *
	 */
	public static void main(String[] args) {
		Application.launch(args);
	}

	/**
	 *
	 * Switches between Scenes
	 * 
	 * @author James DiNovo
	 * @date 17.10.2018
	 * @version 1.0
	 *
	 */
	public void start(Stage primaryStage) throws Exception {
		Login login = new Login();
		window = primaryStage;
		if(login.load()) {
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
