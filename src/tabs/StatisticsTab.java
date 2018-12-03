package tabs;

import javafx.animation.FadeTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Side;
import javafx.scene.chart.*;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.util.Duration;
import javafx.util.StringConverter;
import tables.VehiclesTable;
import tables.WorkordersTable;

import java.util.Collections;

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
	private static BorderPane pane;
	private static PieChart chart = new PieChart();

	private static NumberAxis xAxis = new NumberAxis();
	private static CategoryAxis yAxis = new CategoryAxis();
	private static NumberAxis yAxisM = new NumberAxis();
	private static CategoryAxis xAxisM = new CategoryAxis();

	private static BarChart<String, Number> bchart = new BarChart<>(yAxis, xAxis);
	private static BarChart<String, Number> bMonthChart = new BarChart<>(xAxisM, yAxisM);

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
		/**
		 * @Author Dorian Harusha
		 * @Date 11.28.2018
		 */
		this.setText("Statistics");

		final Label prompt = new Label();
		prompt.setText("Choose a chart: ");
		prompt.setPadding(new Insets(5, 5, 0, 0));

		final ComboBox chartComboBox = new ComboBox();
		chartComboBox.getItems().addAll(
				"Open/Closed Work Orders",
				"Work Orders per Month",
				"Vehicles Serviced"
		);
		chartComboBox.setValue("Open/Closed Work Orders");
		chart.setVisible(true);
		bchart.setVisible(false);
		bMonthChart.setVisible(false);
		FadeTransition fade = new FadeTransition(Duration.millis(500), chart);
		fade.setFromValue(0);
		fade.setToValue(1);
		fade.setCycleCount(1);
		fade.setAutoReverse(false);
		fade.play();

		chartComboBox.valueProperty().addListener(new ChangeListener<String>() {
			@Override public void changed(ObservableValue ov, String t, String t1) {
				if (chartComboBox.getValue().equals("Open/Closed Work Orders")) {
					FadeTransition fade = new FadeTransition(Duration.millis(500), chart);
					fade.setFromValue(0);
					fade.setToValue(1);
					fade.setCycleCount(1);
					fade.setAutoReverse(false);
					fade.play();
					pane.setCenter(generateChart());
					chart.setVisible(true);
					bchart.setVisible(false);
					bMonthChart.setVisible(false);
				} else if (chartComboBox.getValue().equals("Vehicles Serviced")) {
					FadeTransition fade = new FadeTransition(Duration.millis(500), bchart);
					fade.setFromValue(0);
					fade.setToValue(1);
					fade.setCycleCount(1);
					fade.setAutoReverse(false);
					fade.play();
					pane.setCenter(generateBarChart());
					bchart.setVisible(true);
					chart.setVisible(false);
					bMonthChart.setVisible(false);

				} else if (chartComboBox.getValue().equals("Work Orders per Month")) {
					FadeTransition fade = new FadeTransition(Duration.millis(500), bMonthChart);
					fade.setFromValue(0);
					fade.setToValue(1);
					fade.setCycleCount(1);
					fade.setAutoReverse(false);
					fade.play();
					bMonthChart.setVisible(true);
					pane.setCenter(generateMonthBarChart());
					bchart.setVisible(false);
					chart.setVisible(false);


				}
			}
		});

		// Fixes duplication issue *read below for more info*
		//bchart.getData().addAll(series1);

		HBox hBox = new HBox(prompt, chartComboBox);
		hBox.setPadding(new Insets(15, 12, 15, 12));

		pane = new BorderPane();
		pane.setTop(hBox);
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
	 * @return PieChart
	 */
	public static PieChart generateChart() {
		WorkordersTable table = new WorkordersTable();

		int closed = table.getClosedWorkordersCount();
		int open = table.getOpenWorkordersCount();

		chart.setTitle("Open vs Closed Work Orders");
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

	/**
	 * @Author Dorian Harusha
	 * @Date 11.29.2018
	 * @return BarChart
	 */
	public static BarChart generateBarChart() {
		VehiclesTable vehiclesTable = new VehiclesTable();

		bchart.setTitle("Vehicles Serviced By Brand");
		xAxis.setLabel("# Serviced");
		xAxis.setTickLength(1);
		xAxis.setMinorTickVisible(false);
		xAxis.setTickUnit(1);
		xAxis.setAutoRanging(false);
		xAxis.setLabel("Brands");

		XYChart.Series series1 = new XYChart.Series();

		series1.setName("2018");

		series1.getData().add(new XYChart.Data("BMW", vehiclesTable.getVehiclesWorkedOnCount("BMW")));
		series1.getData().add(new XYChart.Data("TOYOTA"  , vehiclesTable.getVehiclesWorkedOnCount("TOYOTA")));
		series1.getData().add(new XYChart.Data("NISSAN"  , vehiclesTable.getVehiclesWorkedOnCount("NISSAN")));
		series1.getData().add(new XYChart.Data("CHRYSLER", vehiclesTable.getVehiclesWorkedOnCount("CHRYSLER")));
		series1.getData().add(new XYChart.Data("JEEP", vehiclesTable.getVehiclesWorkedOnCount("JEEP")));
		series1.getData().add(new XYChart.Data("AUDI"  , vehiclesTable.getVehiclesWorkedOnCount("AUDI")));
		series1.getData().add(new XYChart.Data("VOLKSWAGEN"  , vehiclesTable.getVehiclesWorkedOnCount("VOLKSWAGEN")));
		series1.getData().add(new XYChart.Data("PORSCHE", vehiclesTable.getVehiclesWorkedOnCount("PORSCHE")));
		series1.getData().add(new XYChart.Data("SUBARU", vehiclesTable.getVehiclesWorkedOnCount("SUBARU")));
		series1.getData().add(new XYChart.Data("DODGE", vehiclesTable.getVehiclesWorkedOnCount("DODGE")));
		series1.getData().add(new XYChart.Data("FORD"  , vehiclesTable.getVehiclesWorkedOnCount("FORD")));
		series1.getData().add(new XYChart.Data("HONDA"  , vehiclesTable.getVehiclesWorkedOnCount("HONDA")));
		series1.getData().add(new XYChart.Data("CHEVROLET", vehiclesTable.getVehiclesWorkedOnCount("CHEVROLET")));

		xAxis.setUpperBound(vehiclesTable.getMaxVehicle());

		bchart.setData(FXCollections.observableArrayList(series1));
		//bchart.getData().addAll(series1);

		return bchart;
	}

	/**
	 * @author James DiNovo
	 * @date 12.02.2018
	 * @return BarChart
	 */
	public static BarChart generateMonthBarChart() {
		WorkordersTable workordersTable = new WorkordersTable();

		bMonthChart.setTitle("Work Orders per Month");
		yAxisM.setLabel("# Serviced");
		xAxisM.setLabel("Month");

		yAxisM.setTickLength(1);
		yAxisM.setMinorTickVisible(false);

		yAxisM.setTickUnit(1);
		yAxisM.setAutoRanging(false);

//		bMonthChart.setCategoryGap(10);

		XYChart.Series series1 = new XYChart.Series();

		series1.setName("2018");

		series1.getData().add(new XYChart.Data("January", workordersTable.getMonthWorkorders(1, 2018)));
		series1.getData().add(new XYChart.Data("February"  , workordersTable.getMonthWorkorders(2, 2018)));
		series1.getData().add(new XYChart.Data("March"  , workordersTable.getMonthWorkorders(3, 2018)));
		series1.getData().add(new XYChart.Data("April", workordersTable.getMonthWorkorders(4, 2018)));
		series1.getData().add(new XYChart.Data("May", workordersTable.getMonthWorkorders(5, 2018)));
		series1.getData().add(new XYChart.Data("June"  , workordersTable.getMonthWorkorders(6, 2018)));
		series1.getData().add(new XYChart.Data("July"  , workordersTable.getMonthWorkorders(7, 2018)));
		series1.getData().add(new XYChart.Data("August", workordersTable.getMonthWorkorders(8, 2018)));
		series1.getData().add(new XYChart.Data("September", workordersTable.getMonthWorkorders(9, 2018)));
		series1.getData().add(new XYChart.Data("October", workordersTable.getMonthWorkorders(10, 2018)));
		series1.getData().add(new XYChart.Data("November"  , workordersTable.getMonthWorkorders(11, 2018)));
		series1.getData().add(new XYChart.Data("December"  , workordersTable.getMonthWorkorders(12, 2018)));

		yAxisM.setUpperBound(WorkordersTable.getMaxWork());

		bMonthChart.setData(FXCollections.observableArrayList(series1));
		//bchart.getData().addAll(series1);

		return bMonthChart;
	}
}

