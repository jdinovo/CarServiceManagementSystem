package tabs;

import javafx.scene.control.Tab;
import panes.LoginPane;

/**
 *
 * LoginTab is a tab that contains the GUI for setting Database Login info
 * It is a singleton class
 *
 * @author James DiNovo
 * @date 05.11.2018
 * @version 1.0
 *
 */
public class LoginTab extends Tab {
    private static LoginTab tab;

    /**
     *
     * Constructor for LoginTab
     *
     * @author James DiNovo
     * @date 05.11.2018
     * @version 1.0
     *
     */
    private LoginTab() {
        this.setText("Database Settings");
        this.setContent(new LoginPane());
        this.setOnCloseRequest(e-> {
            tab = null;
        });

    }

    /**
     *
     * Login getInstance method
     *
     * @author James DiNovo
     * @date 05.11.2018
     * @version 1.0
     * @return LoginTab()
     *
     */
    public static LoginTab getInstance() {
        if(tab == null) {
            tab = new LoginTab();
        }
        return tab;
    }
}
