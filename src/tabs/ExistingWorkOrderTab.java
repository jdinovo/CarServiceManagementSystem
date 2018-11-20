package tabs;

import javafx.scene.control.Tab;
import panes.ExistingCustNewWorkOrderPane;

/**
 *
 * ExistingWorkOrderTab is a tab that contains the GUI for creating a existing work order
 * It is a singleton class
 *
 * @author James DiNovo
 * @date 19.11.2018
 * @version 1.0
 *
 */
public class ExistingWorkOrderTab extends Tab {

        private static ExistingWorkOrderTab tab;

        /**
         *
         * Constructor for ExistingWordOrderTab
         *
         * @author James DiNovo
         * @date 19.11.2018
         * @version 1.0
         *
         */
        private ExistingWorkOrderTab() {
            this.setText("New Work Order");
            this.setContent(new ExistingCustNewWorkOrderPane());
            this.setOnClosed(e-> {
                tab = null;
            });
        }

        /**
         *
         * ExistingWordOrderTab getInstance method
         *
         * @author James DiNovo
         * @date 19.11.2018
         * @version 1.0
         * @return NewWorkOrder()
         *
         */
        public static ExistingWorkOrderTab getInstance() {
            if(tab == null) {
                tab = new ExistingWorkOrderTab();
            }
            return tab;
        }

        public static ExistingWorkOrderTab closeInstance() {
            if (tab != null) {
                tab.getTabPane().getTabs().remove(tab);
            }
            return tab;
        }
}
