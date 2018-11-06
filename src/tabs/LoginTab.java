package tabs;

import javafx.scene.control.Tab;
import panes.LoginPane;

/**
 *
 * @author James DiNovo
 * @date 05.11.2018
 * @version 1.0
 *
 * LoginTab is a tab that contains the GUI for setting Database Login info
 * It is a singleton class
 *
 */
public class LoginTab extends Tab {
    private static LoginTab tab;

    /**
     *
     * @author James DiNovo
     * @date 05.11.2018
     * @version 1.0
     *
     * Constructor for LoginTab
     *
     */
    private LoginTab() {
        this.setText("Database Settings");
        this.setContent(new LoginPane());
    }

    /**
     *
     * @author James DiNovo
     * @date 05.11.2018
     * @version 1.0
     * @return LoginTab()
     *
     * Login getInstance method
     *
     */
    public static LoginTab getInstance() {
        if(tab == null) {
            tab = new LoginTab();
        }
        return tab;
    }
}
