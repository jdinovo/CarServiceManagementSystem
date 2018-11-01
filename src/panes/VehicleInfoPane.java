package panes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class VehicleInfoPane {

    //Strings for the map
    String vinNumMap = "";
    String brandMap = "";
    String modelMap = "";
    String yearMap = "";
    String kilometersMap = "";

    /**
     * @author Chris Dias
     * @date 10.31.2018
     * @version 1.0
     *
     * A function that creates the Vehicle Information part of the GUI
     * of NewWorkOrder to be used in the New Work Order tab
     */
    public GridPane VehicleInfoGui() {

        Text textfieldIncomplete = new Text("");
        textfieldIncomplete.setVisible(false);

        //GridPane that contains the entire UI for the Vehicle Info Part of NewWorkOrder
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(20);
        grid.setHgap(20);

        /**
         * These are the TextFields that will be asked for
         * in the vehicle information part of the work order:
         * @vinNum vin number
         * @brand Brand of vehicle
         * @Model model of vehicle
         * @year year of vehicle
         * @kilometers kilometers of vehicle
         */
        //Vin num textfield
        Label vinNumText = new Label("VIN Number:");
        vinNumText.setFont(Font.font("Times New Roman", 16));
        GridPane.setConstraints(vinNumText, 0, 0);
        grid.getChildren().add(vinNumText);

        TextField vinNum = new TextField();
        vinNum.setMaxWidth(300);
        vinNum.setAlignment(Pos.TOP_CENTER);
        GridPane.setConstraints(vinNum, 1, 0);
        grid.getChildren().add(vinNum);

        //Brand textfield
        Label brandText = new Label("Brand:");
        brandText.setFont(Font.font("Times New Roman", 16));
        GridPane.setConstraints(brandText, 0, 1);
        grid.getChildren().add(brandText);

        TextField brand = new TextField();
        brand.setMaxWidth(300);
        brand.setAlignment(Pos.TOP_CENTER);
        GridPane.setConstraints(brand, 1, 1);
        grid.getChildren().add(brand);

        //Model Text
        Label modelText = new Label("Model:");
        modelText.setFont(Font.font("Times New Roman", 16));
        GridPane.setConstraints(modelText, 0, 2);
        grid.getChildren().add(modelText);

        TextField model = new TextField();
        model.setMaxWidth(300);
        model.setAlignment(Pos.TOP_CENTER);
        GridPane.setConstraints(model, 1, 2);
        grid.getChildren().add(model);

        //Year Text
        Label yearText = new Label("Year:");
        yearText.setFont(Font.font("Times New Roman", 16));
        GridPane.setConstraints(yearText, 0, 3);
        grid.getChildren().add(yearText);

        TextField year = new TextField();
        year.setMaxWidth(300);
        year.setAlignment(Pos.TOP_CENTER);
        GridPane.setConstraints(year, 1, 3);
        grid.getChildren().add(year);

        //Email
        Label kilometersText = new Label("Kilometers:");
        kilometersText.setFont(Font.font("Times New Roman", 16));
        GridPane.setConstraints(kilometersText, 0, 4);
        grid.getChildren().add(kilometersText);

        TextField kilometers = new TextField();
        kilometers.setMaxWidth(300);
        kilometers.setAlignment(Pos.TOP_CENTER);
        GridPane.setConstraints(kilometers, 1, 4);
        grid.getChildren().add(kilometers);

        /**
         * When the next button is pressed, save the textfield answers
         * into the Map strings.
         */
        Button nextButton = new Button("Next");
        GridPane.setConstraints(nextButton, 1, 5);
        nextButton.setOnMouseClicked(e->{

            //If none of the textfields are empty, save the answers into the string
            if (!vinNum.getText().isEmpty() && !brand.getText().isEmpty() &&
                    !model.getText().isEmpty() && !year.getText().isEmpty() &&
                    !kilometers.getText().isEmpty()) {
                vinNumMap = vinNum.getText();
                brandMap = brand.getText();
                modelMap = model.getText();
                yearMap = year.getText();
                kilometersMap = kilometers.getText();

                textfieldIncomplete.setVisible(false);
                grid.getChildren().remove(textfieldIncomplete);
                System.out.println("2nd page complete");

                //Continue to the Service Info Pane

            } else {
                // If one of the textfields are empty, let the user know
                textfieldIncomplete.setText("You have an empty textfield");
                GridPane.setConstraints(textfieldIncomplete, 1, 6);
                textfieldIncomplete.setFill(Color.RED);

                //Only add to the screen if the text is not visible
                if (!textfieldIncomplete.isVisible()) {
                    grid.getChildren().add(textfieldIncomplete);
                }
                textfieldIncomplete.setVisible(true);
            }

        });
        grid.getChildren().add(nextButton);

        return grid;
    }

}
