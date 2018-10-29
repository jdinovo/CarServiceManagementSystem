package tabs;

import javafx.scene.control.Tab;


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
	}
	
	/**
	 * 
	 * @author James DiNovo
	 * @date 29.10.2018
	 * @version 1.0
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
}
