package panes;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;

/**
 * 
 * @author James DiNovo
 * @date 17.10.2018
 * @version 1.0
 * 
 * MainMenuPane is the pane that launches from MainMenuScene
 *
 */
public class MainMenuPane extends BorderPane {

	/**
	 * 
	 * @author James DiNovo
	 * @date 17.10.2018
	 * @version 1.0
	 * 
	 * Constructor for MainMenuPane contains GUI
	 * GUI contains a menubar that opens tabs
	 *
	 */
	public MainMenuPane() {
		MenuBar menu = new MenuBar();
		
		Menu fileMenu = new Menu("File");
		Menu editMenu = new Menu("Edit");
		Menu statsMenu = new Menu("Statistics");
		
		MenuItem newInv = new MenuItem("New Invoice");
		MenuItem loadInv = new MenuItem("Load Invoice");
		MenuItem editInv = new MenuItem("Edit Invoice");
		MenuItem serviceTables = new MenuItem("Service History");
		MenuItem serviceCharts = new MenuItem("Service Charts");
		
		fileMenu.getItems().addAll(newInv, loadInv);
		editMenu.getItems().addAll(editInv);
		statsMenu.getItems().addAll(serviceTables, serviceCharts);
		
		menu.getMenus().addAll(fileMenu, editMenu, statsMenu);
		
		this.setTop(menu);
		
	}

}
