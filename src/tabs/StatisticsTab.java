package tabs;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Side;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;
import tables.WorkordersTable;

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

	/**
	 * @Author Dorian Harusha
	 * @Date 11.25.2018
	 */

	private static StatisticsTab tab;
	public static BorderPane pane;

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
		pane = new BorderPane();
		pane.setCenter(generateChart());
		this.setContent(pane);
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

	/**
	 * @Author Dorian Harusha
	 * @Date 11.25.2018
	 *
	 * Pie chart to display open workorders vs closed workorders percentage
	 *
	 * @return chart
	 */
	public static PieChart generateChart() {
		WorkordersTable table = new WorkordersTable();
		int closed = table.getClosedWorkordersCount();
		int open = table.getOpenWorkordersCount();

		PieChart chart = new PieChart();
		chart.setTitle("Service Charts Statistics");
		chart.setLabelsVisible(true);
		chart.setLabelLineLength(10);

		ObservableList<PieChart.Data> data = FXCollections.observableArrayList(
				new PieChart.Data("Open Workorders:" + open, open),
				new PieChart.Data("Closed Workorders:" + closed, closed)
		);
		chart.setData(data);

		chart.setLegendSide(Side.LEFT);
		return chart;
	}
}
