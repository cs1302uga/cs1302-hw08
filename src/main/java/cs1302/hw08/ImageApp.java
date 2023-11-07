package cs1302.hw08;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;

/**
 * A basic JavaFX 17 program which takes a user specified URL and loads it
 * into an {@code ImageView}.
 *
 */
public class ImageApp extends Application {

    /** The container for the image loader objects. */
    HBox loaderContainer;

    ImageLoader loader1;
    ImageLoader loader2;

    /**
     * Constructs a new image application.
     */
    public ImageApp() {
        System.out.println("2) Creating an instance of the ImageApp Application");

        loaderContainer = new HBox(8);
        loader1 = new ImageLoader();
        loader2 = new ImageLoader();
    } // ImageApp

    @Override
    public void init() {
        System.out.println("3) Executing the init method");

        loaderContainer.getChildren().addAll(loader1, loader2);
    } // init

    /**
     * The entry point for our image viewer application.
     *
     * @param stage A reference to the stage object (window) created by the system.
     */
    public void start(Stage stage) {
        System.out.println("4) Executing the start method");

        // Add the root of the scene graph to the stage.
        Scene scene = new Scene(loaderContainer);

        // Set up the stage and set it to be visible
        stage.setScene(scene);
        stage.setTitle("1302 Image Viewer!");
        stage.sizeToScene();
        stage.show();
    } // start

    @Override
    public void stop() {
        // Won't be used by us. Typically used for application cleanup.

        System.out.println("6) Executing the stop method");
    } // stop

} // ImageApp
