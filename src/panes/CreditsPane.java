package panes;

import javafx.geometry.Pos;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import main.Const;
import main.Construct;

/**
 *
 * CreditsPane references sources for all images and graphics used within the app
 *
 * @author James DiNovo
 * @date 28.11.2018
 * @version 1.0
 *
 */
public class CreditsPane extends BorderPane {


    /**
     * public constructor for CreditsPane
     *
     * @author James DiNovo
     * @date 02.12.2018
     */
    public CreditsPane() {

        final WebView browser = new WebView();
        final WebEngine webEngine = browser.getEngine();
        

        //Create multiple hyperlinks - one for each source

        // Open browser and dislay page
        Hyperlink source1 = new Hyperlink();
        final String site1 = "https://pixabay.com/en/oil-garage-service-engine-99220/";
        source1.setText(site1);
        source1.setOnAction(e-> {
            webEngine.load(site1);
        });
        //label
        Hyperlink source2 = new Hyperlink();
        final String site2 = "https://github.com/google/material-design-icons/blob/master/editor/drawable-hdpi/ic_insert_drive_file_black_48dp.png";
        source2.setText(site2);
        source2.setOnAction(e-> {
            webEngine.load(site2);
        });

        Hyperlink source3 = new Hyperlink();
        final String site3 = "https://github.com/google/material-design-icons/blob/master/image/drawable-hdpi/ic_edit_black_48dp.png";
        source3.setText(site3);
        source3.setOnAction(e-> {
            webEngine.load(site3);
        });

        Hyperlink source4 = new Hyperlink();
        final String site4 = "https://github.com/google/material-design-icons/blob/master/action/svg/design/ic_assessment_48px.svg";
        source4.setText(site4);
        source4.setOnAction(e-> {
            webEngine.load(site4);
        });

        Hyperlink source5 = new Hyperlink();
        final String site5 = "https://github.com/google/material-design-icons/blob/master/action/svg/design/ic_settings_48px.svg";
        source5.setText(site5);
        source5.setOnAction(e-> {
            webEngine.load(site5);
        });



        //Create font for the links
        source1.setFont(Const.HEADER_FONT);
        source2.setFont(Const.HEADER_FONT);
        source3.setFont(Const.HEADER_FONT);
        source4.setFont(Const.HEADER_FONT);
        source5.setFont(Const.HEADER_FONT);

        //Add a vbox with all the texts and add them to the scene
        VBox box = new VBox();
        box.setAlignment(Pos.CENTER);
        box.setPrefSize(Construct.SCREEN_WIDTH, Construct.SCREEN_HEIGHT);
        box.setSpacing(10);
        box.getChildren().addAll(source1, source2, source3, source4, source5, browser);

        this.setCenter(box);


    }
}
