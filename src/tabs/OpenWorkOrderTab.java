package tabs;


import javafx.scene.control.Tab;
import panes.OpenWorkOrderPane;

/**
 * OpenWorkOrderTab is a GUI for and uses a singleton to load and delete instances
 *
 * @author Chris Dias
 * @version 1.0
 * @since 11/13/2018
 */
public class OpenWorkOrderTab extends Tab {

    private static OpenWorkOrderTab tab;

    /**
     *
     * Constructor for OpenWorkOrderTab
     *
     * @author Chris Dias
     * @version 1.0
     * @since 11/24/2018
     *
     */
    private OpenWorkOrderTab() {
        this.setText("Open Work Orders");
        //Execute the function to bring the GUI to the NewWorkOrderTab
        this.setContent(new OpenWorkOrderPane());
        this.setOnClosed(e-> {
            tab = null;
        });
    }

    /**
     *
     * OpenWorkOrderTab getInstance method
     *
     * @author Chris Dias
     * @version 1.0
     * @since 11/13/2018
     * @return OpenWorkOrder()
     *
     */
    public static OpenWorkOrderTab getInstance() {
        if(tab == null) {
            tab = new OpenWorkOrderTab();
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
