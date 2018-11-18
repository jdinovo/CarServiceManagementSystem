package panes;

import database.Database;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import tabs.EditCustInfoTab;
import tabs.LoginTab;
import tabs.NewWorkOrderTab;
import tabs.StatisticsTab;

/**
 *
 * MainMenuPane is the pane that launches from MainMenuScene
 *
 * @author James DiNovo
 * @date 17.10.2018
 * @version 1.2
 *
 */
public class MainMenuPane extends BorderPane {
	
	/**
	 *
	 * Constructor for MainMenuPane contains GUI
	 * GUI contains a menubar that opens tabs
	 *
	 * @author James DiNovo
	 * @date 17.10.2018
	 * @version 1.2
	 *
	 */
	public MainMenuPane() {

		//access db
		Database db = Database.getInstance();

		//create menuBar
		MenuBar menu = new MenuBar();

		//create menu choices
		Menu fileMenu = new Menu("File");
		Menu editMenu = new Menu("Edit");
		Menu statsMenu = new Menu("Statistics");
		Menu settingsMenu = new Menu("Settings");

		//creating tabPane
		TabPane tabPane = new TabPane();

		
		//Create MenuItems for the 'File' Tab
		MenuItem newWork = new MenuItem("New Work Order");
		newWork.setOnAction(e-> {
			NewWorkOrderTab newWorkTab = NewWorkOrderTab.getInstance();
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
			EditCustInfoTab editInfoTab = EditCustInfoTab.getInstance();
			if(!tabPane.getTabs().contains(editInfoTab)) {
				tabPane.getTabs().add(editInfoTab);

			}
		});

		//Create MenuItem for the 'Statistics' Tab
		MenuItem serviceCharts = new MenuItem("Service Charts");
		serviceCharts.setOnAction(e-> {
			StatisticsTab statsTab = StatisticsTab.getInstance();
			if(!tabPane.getTabs().contains(statsTab)) {
				tabPane.getTabs().add(statsTab);

			}
		});

		//Create MenuItem for the 'Login' Tab
		MenuItem dbLogin = new MenuItem("Database Settings");
		dbLogin.setOnAction(e-> {
			LoginTab loginTab = LoginTab.getInstance();
			if(!tabPane.getTabs().contains(loginTab)) {
				tabPane.getTabs().add(loginTab);

			}
		});
		
		//adding menu items to menus
		fileMenu.getItems().addAll(newWork, openWork, closeWork);
		editMenu.getItems().addAll(editCustInfo);
		statsMenu.getItems().add(serviceCharts);
		settingsMenu.getItems().add(dbLogin);
		
		//adding menus to menubar
		menu.getMenus().addAll(fileMenu, editMenu, statsMenu, settingsMenu);
		
		//adding menubar and tabpane to pane
		this.setTop(menu);
		this.setCenter(tabPane);
		
	}

}
