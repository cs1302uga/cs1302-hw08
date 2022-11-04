package cs1302.hw08;

import javafx.application.Application;

/**
 * A simple driver application to launch the CSCI 1302 Image App.
 */
public class ImageDriver {

    /**
     * The main entry point of the application.
     *
     * @param args the command-line arguments to the application.
     */
    public static void main(String[] args) {
        try {
            Application.launch(ImageApp.class, args);
        } catch (Exception e) {
            System.err.println(e);
            e.printStackTrace();
            System.err.println("Likely due to X11 timeout. Logout and log back in...");
            System.exit(1);
        } // try
    } // main

} // ImageDriver
