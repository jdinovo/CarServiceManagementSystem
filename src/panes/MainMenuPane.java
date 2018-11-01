package panes;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import tabs.NewWorkOrderTab;
import tabs.StatisticsTab;

/**
 * 
 * @author James DiNovo
 * @date 17.10.2018
 * @version 1.2
 * 
 * MainMenuPane is the pane that launches from MainMenuScene
 *
 */
public class MainMenuPane extends BorderPane {

	/**
	 * 
	 * @author James DiNovo
	 * @date 17.10.2018
	 * @version 1.2
	 * 
	 * Constructor for MainMenuPane contains GUI
	 * GUI contains a menubar that opens tabs
	 *
	 */
	public MainMenuPane() {

		//Implementing the GUI panes to add into the tabs
		CustomerInfoPane customerInfoPane = new CustomerInfoPane();

		//create menuBar
		MenuBar menu = new MenuBar();
		
		//create menu choices
		Menu fileMenu = new Menu("File");
		Menu editMenu = new Menu("Edit");
		Menu statsMenu = new Menu("Statistics");
		
		//creating tabPane
		TabPane tabPane = new TabPane();
		
		//create tabs
		NewWorkOrderTab newWorkTab = NewWorkOrderTab.getInstance();
		StatisticsTab statsTab = StatisticsTab.getInstance();
		
		//creating menu items and adding event listeners to them
		MenuItem newWork = new MenuItem("New Invoice");
		newWork.setOnAction(e-> {
			//if tab is not already open
			if(!tabPane.getTabs().contains(newWorkTab)) {
				tabPane.getTabs().add(newWorkTab);

				//Execute the function to bring the GUI to the NewWorkOrderTab
				newWorkTab.setContent(customerInfoPane.CustomerInfoGui());

			}
		});
		MenuItem loadWork = new MenuItem("Load Invoice");
		loadWork.setOnAction(e-> {
			
		});
		MenuItem editWork = new MenuItem("Edit Invoice");
		editWork.setOnAction(e-> {
			
		});
		MenuItem serviceTables = new MenuItem("Service History");
		serviceTables.setOnAction(e-> {
			if(!tabPane.getTabs().contains(statsTab)) {
				tabPane.getTabs().add(statsTab);
			}
		});
		MenuItem serviceCharts = new MenuItem("Service Charts");
		serviceCharts.setOnAction(e-> {
			
		});
		
		//adding menu items to menus
		fileMenu.getItems().addAll(newWork, loadWork);
		editMenu.getItems().addAll(editWork);
		statsMenu.getItems().addAll(serviceTables, serviceCharts);
		
		//adding menus to menubar
		menu.getMenus().addAll(fileMenu, editMenu, statsMenu);
		
		//adding menubar and tabpane to pane
		this.setTop(menu);
		this.setCenter(tabPane);
		
	}

}
