package tabs;

import javafx.scene.control.Tab;
import panes.CreditsPane;

/**
 *
 * Credits is a tab that contains the GUI for attributing credits
 * It is a singleton class
 *
 * @author James DiNovo
 * @date 28.11.2018
 * @version 1.0
 *
 */
public class CreditsTab extends Tab {
    private static CreditsTab tab;

    /**
     *
     * Constructor for CreditsTab
     *
     * @author James DiNovo
     * @date 28.11.2018
     * @version 1.0
     *
     */
    private CreditsTab() {
        this.setText("Credits");
        this.setContent(new CreditsPane());
        this.setOnCloseRequest(e-> {
            tab = null;
        });

    }

    /**
     *
     * CreditsTab getInstance method
     *
     * @author James DiNovo
     * @date 28.11.2018
     * @version 1.0
     * @return LoginTab()
     *
     */
    public static CreditsTab getInstance() {
        if(tab == null) {
            tab = new CreditsTab();
        }
        return tab;
    }
}
