package panes;

import database.DBConst;
import database.Login;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import main.Main;
import scenes.MainMenuScene;

import java.util.HashMap;

import static main.Const.BODY_FONT;
import static main.Const.HEADER_FONT;

/**
 *
 * LoginPane Contains GUI for DB login
 *
 * @author James DiNovo
 * @date 05.11.2018
 * @version 1.0
 *
 */
public class LoginPane extends BorderPane {
    private Text error = new Text("");

    /**
     *
     * Constructor for LoginTab
     *
     * @author James DiNovo
     * @date 05.11.2018
     * @version 1.0
     *
     */
    public LoginPane() {
            HashMap<String, String> loginHash = new HashMap<>(4);

            Login login = new Login();

            error.setVisible(false);

            VBox box = new VBox();

            Text header = new Text("Database Login Credentials");
            header.setFont(HEADER_FONT);

            /*
             * @dbName database Name
             * @dbUser database username
             * @dbPass database password
             */

            Label dbLocText = new Label("Database Host:");
            dbLocText.setFont(BODY_FONT);

            TextField dbLoc = new TextField();
            dbLoc.setMaxWidth(300);
            dbLoc.setText(DBConst.getDbHost());

            Label dbNameText = new Label("Database Name:");
            dbNameText.setFont(BODY_FONT);

            TextField dbName = new TextField();
            dbName.setMaxWidth(300);
            dbName.setText(DBConst.getDbName());

            Label dbUserText = new Label("Username:");
            dbUserText.setFont(BODY_FONT);


            TextField dbUser = new TextField();
            dbUser.setMaxWidth(300);
            dbUser.setText(DBConst.getDbUser());

            Label dbPassText = new Label("Password:");
            dbPassText.setFont(BODY_FONT);

            PasswordField dbPass = new PasswordField();
            dbPass.setMaxWidth(300);
            dbPass.setText(DBConst.getDbPass());

            Button loginButton = new Button("Login");
            loginButton.setPrefSize(100, 50);
            loginButton.setOnAction(e -> {
                error.setVisible(false);

                if (!dbLoc.getText().trim().isEmpty() && !dbName.getText().trim().isEmpty() && !dbUser.getText().trim().isEmpty() && !dbPass.getText().trim().isEmpty()) {
                    loginHash.put("DB_HOST", dbLoc.getText().trim());
                    loginHash.put("DB_NAME", dbName.getText().trim());
                    loginHash.put("DB_USER", dbUser.getText().trim());
                    loginHash.put("DB_PASS", dbPass.getText().trim());

                    if(login.test(loginHash.get("DB_HOST"), loginHash.get("DB_NAME"), loginHash.get("DB_USER"), loginHash.get("DB_PASS"))) {
                        DBConst.setDbHost(loginHash.get("DB_HOST"));
                        DBConst.setDbName(loginHash.get("DB_NAME"));
                        DBConst.setDbUser(loginHash.get("DB_USER"));
                        DBConst.setDbPass(loginHash.get("DB_PASS"));

                        login.save();
                        Main.window.setScene(new MainMenuScene());

                    } else {
                        alert("Invalid Database Credentials");
                    }

                } else {
                    alert("Everything must be filled out.");
                }
            });

            box.setAlignment(Pos.CENTER);
            box.setSpacing(10);
            box.getChildren().addAll(header, dbLocText, dbLoc, dbNameText, dbName, dbUserText, dbUser, dbPassText, dbPass, loginButton, error);

            this.setCenter(box);

    }

    /**
     *  changes and displays alert message
     *  @author James DiNovo
     *  @date 02.12.2018
     *
     * @param msg
     */
    private void alert(String msg) {
        error.setText(msg);
        error.setFill(Color.RED);
        error.setVisible(true);
    }
}
