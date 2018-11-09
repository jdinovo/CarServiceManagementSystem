package tabs;

import javafx.scene.control.Tab;

/**
 *
 * Statistics is a tab that contains the GUI for viewing service statistics
 * It is a singleton class
 *
 * @author James DiNovo
 * @date 29.10.2018
 * @version 1.0
 *
 */
public class StatisticsTab extends Tab {
	
	private static StatisticsTab tab;

	/**
	 *
	 * Statistics private constructor
	 *
	 * @author James DiNovo
	 * @date 29.10.2018
	 * @version 1.0
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
	 * Statistics getInstance method
	 * 
	 * @author James DiNovo
	 * @date 29.10.2018
	 * @version 1.0
	 * @return StatisticsTab()
	 *
	 */
	public static StatisticsTab getInstance() {
		if(tab == null) {
			tab = new StatisticsTab();
		}
		return tab;
	}
}
