package tabs;

import javafx.scene.control.Tab;
import panes.CustomerInfoPane;


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
	//Implementing the GUI panes to add into the tabs
	private CustomerInfoPane customerInfoPane = new CustomerInfoPane();
	
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
		this.setContent(customerInfoPane.CustomerInfoGui());
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
}
