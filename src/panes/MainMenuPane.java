package panes;

import database.Database;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import main.Construct;
import tabs.*;

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
		Menu fileMenu = new Menu();
		Menu editMenu = new Menu();
		Menu statsMenu = new Menu();
		Menu settingsMenu = new Menu();

		ImageView carImage = new ImageView(new Image("/graphics/carService.png"));
		carImage.setFitHeight(500);
		carImage.setFitWidth(500);

		carImage.setX(265);
		carImage.setY(150);

		//creating tabPane
		TabPane tabPane = new TabPane();
		tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.ALL_TABS);
		
		//Create MenuItems for the 'File' Tab
		MenuItem newWork = new MenuItem("New Work Order");
		newWork.setOnAction(e-> {
			carImage.setVisible(false);
			ExistingWorkOrderTab newWorkTab = ExistingWorkOrderTab.getInstance();
			//if tab is not already open
			if(!tabPane.getTabs().contains(newWorkTab) && !tabPane.getTabs().contains(NewWorkOrderTab.getInstance())) {
				tabPane.getTabs().add(newWorkTab);
				tabPane.getSelectionModel().select(newWorkTab);
			} else if(tabPane.getTabs().contains(NewWorkOrderTab.getInstance())){
				tabPane.getSelectionModel().select(NewWorkOrderTab.getInstance());
			} else {
				tabPane.getSelectionModel().select(newWorkTab);
			}
		});
		MenuItem openWork = new MenuItem("Open Work Orders");
		openWork.setOnAction(e-> {
			carImage.setVisible(false);
			OpenWorkOrderTab openWorkOrderTab = OpenWorkOrderTab.getInstance();

			//if tab is not already open
			if(!tabPane.getTabs().contains(openWorkOrderTab) && !tabPane.getTabs().contains(OpenWorkOrderTab.getInstance())) {
				tabPane.getTabs().add(openWorkOrderTab);
				tabPane.getSelectionModel().select(openWorkOrderTab);
			} else if(tabPane.getTabs().contains(OpenWorkOrderTab.getInstance())){
				tabPane.getSelectionModel().select(OpenWorkOrderTab.getInstance());
			} else {
				tabPane.getSelectionModel().select(openWorkOrderTab);
			}
		});
		MenuItem closeWork = new MenuItem("Closed Work Orders");
		closeWork.setOnAction(e-> {
			carImage.setVisible(false);
			ClosedWorkOrderTab closedWorkOrderTab = ClosedWorkOrderTab.getInstance();

			//if tab is not already open
			if(!tabPane.getTabs().contains(closedWorkOrderTab) && !tabPane.getTabs().contains(ClosedWorkOrderTab.getInstance())) {
				tabPane.getTabs().add(closedWorkOrderTab);
				tabPane.getSelectionModel().select(closedWorkOrderTab);
			} else if(tabPane.getTabs().contains(ClosedWorkOrderTab.getInstance())){
				tabPane.getSelectionModel().select(ClosedWorkOrderTab.getInstance());
			} else {
				tabPane.getSelectionModel().select(closedWorkOrderTab);
			}
		});

		//Create MenuItems for the 'Edit' Tab
		MenuItem editCustInfo = new MenuItem("Edit Customer Information");
		editCustInfo.setOnAction(e-> {
			carImage.setVisible(false);
			EditCustInfoTab editInfoTab = EditCustInfoTab.getInstance();
			if(!tabPane.getTabs().contains(editInfoTab)) {
				tabPane.getTabs().add(editInfoTab);
				tabPane.getSelectionModel().select(editInfoTab);
			} else {
				tabPane.getSelectionModel().select(editInfoTab);
			}
		});

		//Create MenuItem for the 'Statistics' Tab
		MenuItem serviceCharts = new MenuItem("Service Charts");
		serviceCharts.setOnAction(e-> {
			carImage.setVisible(false);
			StatisticsTab statsTab = StatisticsTab.getInstance();
			if(!tabPane.getTabs().contains(statsTab)) {
				tabPane.getTabs().add(statsTab);
				tabPane.getSelectionModel().select(statsTab);
			} else {
				tabPane.getSelectionModel().select(statsTab);
			}
		});

		//Create MenuItem for the 'Login' Tab
		MenuItem dbLogin = new MenuItem("Database Settings");
		dbLogin.setOnAction(e-> {
			carImage.setVisible(false);
			LoginTab loginTab = LoginTab.getInstance();
			if(!tabPane.getTabs().contains(loginTab)) {
				tabPane.getTabs().add(loginTab);
				tabPane.getSelectionModel().select(loginTab);
			} else {
				tabPane.getSelectionModel().select(loginTab);
			}
		});

		//Create MenuItem for the 'Credits' Tab
		MenuItem credits = new MenuItem("Credits");
		credits.setOnAction(e-> {
			carImage.setVisible(false);
			CreditsTab creditsTab = CreditsTab.getInstance();
			if(!tabPane.getTabs().contains(creditsTab)) {
				tabPane.getTabs().add(creditsTab);
				tabPane.getSelectionModel().select(creditsTab);
			} else {
				tabPane.getSelectionModel().select(creditsTab);
			}
		});

		
		//adding menu items to menus
		fileMenu.getItems().addAll(newWork, openWork, closeWork);
		editMenu.getItems().addAll(editCustInfo);
		statsMenu.getItems().add(serviceCharts);
		settingsMenu.getItems().addAll(dbLogin, credits);

		ImageView settings = new ImageView(new Image("/graphics/settings.png"));
		settings.setFitWidth(24);
		settings.setFitHeight(24);

		ImageView stats = new ImageView(new Image("/graphics/stats.png"));
		stats.setFitWidth(24);
		stats.setFitHeight(24);

		ImageView file = new ImageView(new Image("/graphics/file.png"));
		file.setFitWidth(24);
		file.setFitHeight(24);

		ImageView edit = new ImageView(new Image("/graphics/edit.png"));
		edit.setFitWidth(24);
		edit.setFitHeight(24);

		fileMenu.setGraphic(file);
		editMenu.setGraphic(edit);
		settingsMenu.setGraphic(settings);
		statsMenu.setGraphic(stats);

		tabPane.getSelectionModel().selectedItemProperty().addListener((ov, oldTab, newTab) -> {
			if(tabPane.getTabs().size() < 1) {
				carImage.setVisible(true);
			}
		});
		
		//adding menus to menubar
		menu.getMenus().addAll(fileMenu, editMenu, statsMenu, settingsMenu);
		
		//adding menubar and tabpane to pane
		this.getChildren().add(carImage);
		this.setTop(menu);
		this.setCenter(tabPane);
		
	}

}
