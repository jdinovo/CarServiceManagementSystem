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
		
		//Create MenuItems for the 'File' Tab
		MenuItem newWork = new MenuItem("New Work Order");
		newWork.setOnAction(e-> {
			//if tab is not already open
			if(!tabPane.getTabs().contains(newWorkTab)) {
				tabPane.getTabs().add(newWorkTab);

			}
		});
		MenuItem openWork = new MenuItem("Open Work Orders");
		openWork.setOnAction(e-> {
			
		});
		MenuItem closeWork = new MenuItem("Closed Work Orders");
		closeWork.setOnAction(e-> {

		});

		//Create MenuItems for the 'Edit' Tab
		MenuItem editCustInfo = new MenuItem("Edit Customer Information");
		editCustInfo.setOnAction(e-> {

		});

		//Create MenuItem for the 'Statistics' Tab
		MenuItem serviceCharts = new MenuItem("Service Charts");
		serviceCharts.setOnAction(e-> {
			
		});
		
		//adding menu items to menus
		fileMenu.getItems().addAll(newWork, openWork, closeWork);
		editMenu.getItems().addAll(editCustInfo);
		statsMenu.getItems().add(serviceCharts);
		
		//adding menus to menubar
		menu.getMenus().addAll(fileMenu, editMenu, statsMenu);
		
		//adding menubar and tabpane to pane
		this.setTop(menu);
		this.setCenter(tabPane);
		
	}

}
