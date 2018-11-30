package tabs;

import javafx.scene.control.Tab;
import panes.ClosedWorkOrderPane;

/**
 * ClosedWorkOrderTab is a GUI for and uses a singleton to load and delete instances
 *
 * @author Chris Dias
 * @version 1.0
 * @since 11/25/2018
 */
public class ClosedWorkOrderTab extends Tab {

    private static ClosedWorkOrderTab tab;

    /**
     * Constructor for ClosedWorkOrderTab
     *
     * @author Chris Dias
     * @version 1.0
     * @since 11/25/2018
     */
    private ClosedWorkOrderTab() {
        this.setText("Closed Work Orders");

        this.setContent(new ClosedWorkOrderPane());
        this.setOnClosed(e-> {
            tab = null;
        });
    }

    /**
     * getInstance opens the tab
     *
     * @author Chris Dias
     * @version 1.0
     * @since 11/25/2018
     */
    public static ClosedWorkOrderTab getInstance() {
        if(tab == null) {
            tab = new ClosedWorkOrderTab();
        }
        return tab;
    }

    public static void closeInstance() {
        if (tab != null) {
            tab.getTabPane().getTabs().remove(tab);
            tab = null;
        }
    }



}
