package tabs;

import javafx.scene.control.Tab;

/**
 * 
 * @author James DiNovo
 * @date 29.10.2018
 * @version 1.0
 * 
 * Statistics is a tab that contains the GUI for viewing service statistics
 * It is a singleton class
 *
 */
public class StatisticsTab extends Tab {
	
	private static StatisticsTab tab;

	/**
	 * 
	 * @author James DiNovo
	 * @date 29.10.2018
	 * @version 1.0
	 * 
	 * Statistics private constructor
	 *
	 */
	private StatisticsTab() {
		this.setText("Statistics");
		this.setOnClosed(e-> {
			tab = null;
		});
	}
	
	/**
	 * 
	 * @author James DiNovo
	 * @date 29.10.2018
	 * @version 1.0
	 * @return StatisticsTab()
	 * 
	 * Statistics getInstance method
	 *
	 */
	public static StatisticsTab getInstance() {
		if(tab == null) {
			tab = new StatisticsTab();
		}
		return tab;
	}
}
