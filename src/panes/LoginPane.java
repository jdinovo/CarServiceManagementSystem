package panes;

import database.DBConst;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import main.Main;
import scenes.MainMenuScene;

import java.util.HashMap;

/**
 *
 * @author James DiNovo
 * @date 05.11.2018
 * @version 1.0
 *
 * LoginPane Contains GUI for DB login
 *
 */
public class LoginPane extends BorderPane {

    /**
     *
     * @author James DiNovo
     * @date 05.11.2018
     * @version 1.0
     *
     * Constructor for LoginTab
     *
     */
    public LoginPane() {
            HashMap<String, String> login = new HashMap<>(3);

            Text error = new Text("");
            error.setVisible(false);

            VBox box = new VBox();

            Text header = new Text("Database Login Credentials");
            header.setFont(Font.font("Times New Roman", 20));

            /*
             * @dbName database Name
             * @dbUser database username
             * @dbPass database password
             */

            Label dbNameText = new Label("Database Name:");
            dbNameText.setFont(Font.font("Times New Roman", 16));

            TextField dbName = new TextField();
            dbName.setMaxWidth(300);
            dbName.setText(DBConst.getDbName());

            Label dbUserText = new Label("Username:");
            dbUserText.setFont(Font.font("Times New Roman", 16));


            TextField dbUser = new TextField();
            dbUser.setMaxWidth(300);
            dbUser.setText(DBConst.getDbUser());

            Label dbPassText = new Label("Password:");
            dbPassText.setFont(Font.font("Times New Roman", 16));

            PasswordField dbPass = new PasswordField();
            dbPass.setMaxWidth(300);
            dbPass.setText(DBConst.getDbPass());

            Button loginButton = new Button("Login");
            loginButton.setPrefSize(100, 50);
            loginButton.setOnAction(e -> {

                login.put("DB_NAME", dbName.getText().trim());
                login.put("DB_USER", dbUser.getText().trim());
                login.put("DB_PASS", dbPass.getText().trim());

                if (!login.get("DB_NAME").isEmpty() && !login.get("DB_USER").isEmpty() && !login.get("DB_PASS").isEmpty()) {
                    DBConst.setDbName(login.get("DB_NAME"));
                    DBConst.setDbUser(login.get("DB_USER"));
                    DBConst.setDbPass(login.get("DB_PASS"));

                    DBConst.loginSave();
                    Main.window.setScene(new MainMenuScene());

                } else {
                    error.setText("Everything must be filled out.");
                    error.setFill(Color.RED);
                    error.setVisible(true);
                }
            });

            box.setAlignment(Pos.CENTER);
            box.setSpacing(10);
            box.getChildren().addAll(header, dbNameText, dbName, dbUserText, dbUser, dbPassText, dbPass, loginButton, error);

            this.setCenter(box);

    }
}
