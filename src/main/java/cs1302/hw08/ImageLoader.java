package cs1302.hw08;

import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.Priority;

public class ImageLoader extends VBox {
    /** The container for the url textfield and the load image button */
    HBox urlLayer;
    TextField url;
    Button loadButton;

    /** The container for the loaded image */
    ImageView imgView;

    /** A default image which loads when the application starts */
    private static final String DEFAULT_IMG =
        "http://cobweb.cs.uga.edu/~mec/cs1302/gui/default.png";

    /** Default height and width for Images */
    private static final int DEF_HEIGHT = 500;
    private static final int DEF_WIDTH = 500;

    public ImageLoader() {
        super();
        urlLayer = new HBox(8);
        imgView = new ImageView();
        loadButton = new Button("Load");
        url = new TextField("https://");

        // Connect the components in the scene graph
        this.getChildren().addAll(urlLayer, imgView);
        urlLayer.getChildren().addAll(url, loadButton);
        HBox.setHgrow(url, Priority.ALWAYS);

        // load the default image
        Image defaultImage = new Image(DEFAULT_IMG);

        // add the image to the imageview
        imgView.setImage(defaultImage);

        loadButton.setOnAction(e -> this.loadImage(e));

    } // ImageLoader

    /**
     * Students will provide javadoc comments here.
     *
     * @param e source event
     */
    private void loadImage(ActionEvent e) {
        try {
            Image newImg = new Image(url.getText(), DEF_HEIGHT, DEF_WIDTH, false, false);
            imgView.setImage(newImg);
        } catch(IllegalArgumentException iae) {
            System.out.println("The supplied URL is invalid");
        } // try
    } // loadImage

} // ImageLoader
