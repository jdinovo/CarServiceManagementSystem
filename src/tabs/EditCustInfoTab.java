package tabs;

import javafx.scene.control.Tab;
import panes.EditCustInfoPane;

/**
 *
 * EditCustInfoTab extends Tab and holds EditCustInfoPane
 * It is a singleton
 *
 * @author James DiNovo
 * @date 17.11.2018
 * @version 1.0
 *
 */
public class EditCustInfoTab extends Tab {
    private static EditCustInfoTab tab;

    /**
     *
     * Constructor for EditCustInfoTab
     *
     * @author James DiNovo
     * @date 17.11.2018
     * @version 1.0
     *
     */
    private EditCustInfoTab() {
        this.setText("Edit Customer Information");
        this.setContent(new EditCustInfoPane());
        this.setOnClosed(e-> {
            tab = null;
        });
    }

    /**
     *
     * gets instance of EditCustInfoTab
     *
     * @author James DiNovo
     * @date 17.11.2018
     * @version 1.0
     * @return EditCustInfoTab()
     *
     */
    public static EditCustInfoTab getInstance() {
        if(tab == null) {
            tab = new EditCustInfoTab();
        }
        return tab;
    }

    public static EditCustInfoTab closeInstance() {
        if (tab != null) {
            tab.getTabPane().getTabs().remove(tab);
        }
        return tab;
    }
}
