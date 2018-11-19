package tabs;

import javafx.scene.control.Tab;
import panes.NewWorkOrderPane;


/**
 *
 * NewWorkOrderTab is a tab that contains the GUI for creating a new work order
 * It is a singleton class
 * 
 * @author James DiNovo
 * @date 29.10.2018
 * @version 1.0
 *
 */
public class NewWorkOrderTab extends Tab {
	
	private static NewWorkOrderTab tab;
	
	/**
	 *
	 * Constructor for NewWorkOrderTab
	 * 
	 * @author James DiNovo
	 * @date 29.10.2018
	 * @version 1.0
	 *
	 */
	private NewWorkOrderTab() {
		this.setText("New Work Order");
		//Execute the function to bring the GUI to the NewWorkOrderTab
		this.setContent(new NewWorkOrderPane());
		this.setOnClosed(e-> {
			tab = null;
		});
	}
	
	/**
	 *
	 * NewWorkOrderTab getInstance method
	 * 
	 * @author James DiNovo
	 * @date 29.10.2018
	 * @version 1.0
	 * @return NewWorkOrder()
	 *
	 */
	public static NewWorkOrderTab getInstance() {
		if(tab == null) {
			tab = new NewWorkOrderTab();
		}
		return tab;
	}

	public static NewWorkOrderTab closeInstance() {
		if (tab != null) {
			tab.getTabPane().getTabs().remove(tab);
		}
		return tab;
	}
}
