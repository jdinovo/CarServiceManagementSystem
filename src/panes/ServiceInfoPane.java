package panes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ServiceInfoPane {

    //Strings for the map
    String issueMap = "";
    String servicesMap = "";

    /**
     * @author Chris Dias
     * @date 10.31.2018
     * @version 1.0
     *
     * A function that creates the Service Information part of the GUI
     * of NewWorkOrder to be used in the New Work Order tab
     */
    public HBox ServiceInfoGui() {

        Text textfieldIncomplete = new Text("");
        textfieldIncomplete.setVisible(false);

        //HBox that contains the entire UI for the Service Info Part of NewWorkOrder
        HBox box = new HBox();

        /**
         * These are the TextFields that will be asked for
         * in the vehicle information part of the work order:
         * @issue text area that explains the issue the customer is having with their car
         * @service A series of services that the tech chooses to place in the work order
         */
        //Vin num textfield
        Label issueText = new Label("In detail, please write the issue the customer is having with their vehicle:");
        issueText.setFont(Font.font("Times New Roman", 16));

        TextArea issue = new TextArea();
        issue.setMaxWidth(300);
        issue.setMaxSize(300,300);
        issue.setWrapText(true);

        box.getChildren().addAll(issueText, issue);


        /**
         * When the next button is pressed, save the textfield answers
         * into the Map strings.
         * The next screen ends up being the current issue screen.
         */
        Button nextButton = new Button("Next");
        GridPane.setConstraints(nextButton, 1, 5);
        nextButton.setOnMouseClicked(e->{

            //If none of the textfields are empty, save the answers into the string
            if (!issue.getText().isEmpty()) {

                textfieldIncomplete.setVisible(false);
                box.getChildren().remove(textfieldIncomplete);
                System.out.println("3rd page complete");

                // Finished the work order, opens the current issue tab

            } else {
                // If one of the textfields are empty, let the user know
                textfieldIncomplete.setText("You have an empty textfield");
                textfieldIncomplete.setFill(Color.RED);

                //Only add to the screen if the text is not visible
                if (!textfieldIncomplete.isVisible()) {
                    box.getChildren().add(textfieldIncomplete);
                }
                textfieldIncomplete.setVisible(true);
            }

        });
        box.getChildren().add(nextButton);

        return box;
    }

}
