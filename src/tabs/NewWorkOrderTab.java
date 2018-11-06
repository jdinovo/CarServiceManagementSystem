package tabs;

import javafx.scene.control.Tab;
import panes.NewWorkOrderPane;


/**
 * 
 * @author James DiNovo
 * @date 29.10.2018
 * @version 1.0
 * 
 * NewWorkOrderTab is a tab that contains the GUI for creating a new work order
 * It is a singleton class
 *
 */
public class NewWorkOrderTab extends Tab {
	
	private static NewWorkOrderTab tab;
	
	/**
	 * 
	 * @author James DiNovo
	 * @date 29.10.2018
	 * @version 1.0
	 * 
	 * Constructor for NewWorkOrderTab
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
	 * @author James DiNovo
	 * @date 29.10.2018
	 * @version 1.0
	 * @return NewWorkOrder()
	 * 
	 * NewWorkOrderTab getInstance method
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
