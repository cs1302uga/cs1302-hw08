# cs1302-hw08

![Approved for: Spring 2021](https://img.shields.io/badge/Approved%20for-Spring%202021-success)

> The only way to get rid of temptation is to yield to it.
> **-- Oscar Wilde, _The Picture of Dorian Gray_**

This class exercise explores creating graphical user interfaces (GUIs) using the JavaFX library. Students
will create an interactive, tabbed GUI that loads images (one per tab) from a specified URL. The program 
supports images in BMP, GIF, JPEG, and PNG formats. Students will need to create custom JavaFX components 
by extending (inheriting from) existing JavaFX components. 

## Course-Specific Learning Outcomes

* **LO2.e:** (Partial) Utilize existing generic methods, interfaces, and classes in a software solution.
* **LO7.a:** (Partial) Design and implement a graphical user interface in a software project.

## References and Prerequisites

* [CSCI 1302 JavaFX Tutorial](https://github.com/cs1302uga/cs1302-tutorials/blob/master/javafx/javafx.md)
* [CSCI 1302 JavaFX Custom Component Tutorial](https://github.com/cs1302uga/cs1302-tutorials/blob/master/components/components.md)
* [JavaFX 11 Bookmarks](https://github.com/cs1302uga/cs1302-tutorials/blob/master/javafx/javafx-bookmarks.md)
* [JavaFX 11 API Documentation](https://openjfx.io/javadoc/11/)

## Questions

In your notes, clearly answer the following questions. These instructions assume that you are 
logged into the Odin server. 

**NOTE:** For each step, please provide in your notes the full command that you typed to make the related 
action happen along with an explanation of why that command worked. Some commands require multiple options. 
It is important to not only recall what you typed but also why you typed each of them. If context is necessary 
(e.g., the command depends on your present working directory), then please note that context as well.
You won't need to submit your notes in your final submission. However, if done properly, your exercise notes 
will serve as a helpful study guide for the exam.

### Getting Started

1. Use Git to clone the repository for this exercise onto Odin into a subdirectory called `cs1302-hw08`:

   ```
   $ git clone --depth 1 https://github.com/cs1302uga/cs1302-hw08.git
   ```

1. Change into the `cs1302-hw08` directory that was just created and look around. There should be
   multiple Java files contained within the directory structure. To see a listing of all of the 
   files under the `src` subdirectory, use the `find` command as follows:
   
   ```
   $ find src
   ```

## Exercise Steps

### Checkpoint 1 Steps

In this checkpoint, you will focus on creating the basic GUI layout for the `ImageApp`. Don't worry about
adding functionality to the button just yet.  At the end of the checkpoint, your GUI should look like the
following image:

<img src="https://github.com/cs1302uga/cs1302-ce19/blob/master/ScreenShot.png?raw=true" width=300>

1. Consider the following containment heirarchy:

   ```
                                        --|
                         Stage            |
                           |              |
                         Scene            |
          |--              |              |
          |               VBox            | Overall
          |               / \             | Containment
   Scene  |              /   \            | Hierarchy
   Graph  |            HBox  ImageView    |
          |            / \                |
          |           /   \               |
          |    TextField  Button          |
          |--                           --|
   ```
   
   Each node corresponds to an object of some class under the 
   [`javafx`](https://openjfx.io/javadoc/11/)
   package. The diagram for the scene graph assumes that child nodes
   are added to their parents in a left-to-right order. For example,
   the `HBox` and `ImageView` objects are added to the collection of
   child nodes for the `VBox` object in that order.
   
1. **Compile and run the starter code without any errors or warnings.**
   Specify `bin` as the default package for your compiled code.
   
   * If you have trouble running the starter code, then consult the 
     [CSCI 1302 JavaFX Tutorial](https://github.com/cs1302uga/cs1302-tutorials/blob/master/javafx/javafx.md).
     
1. The contents of the scene represent part of the state of your application.
   As such, the variables that we use to refer to those objects should be
   instance variables of your class. Don't add the instance variables yet. First, consult the 
   [API Documentation](https://openjfx.io/javadoc/11/) and 
   [referenced bookmarks](https://github.com/cs1302uga/cs1302-tutorials/blob/master/javafx/javafx-bookmarks.md)
   to determine the **import statements** that are needed, then add them to
   the file for your `ImageApp` class. **Recompile before continuing.** 
   
1. Stage and commit your changes.

1. Now, for each object in the scene graph, declare an **instance variable** 
   of the appropriate type with a good name. Do not create the objects here!
   
1. In the `start` method, construct the objects for the scene graph in
   a top-down fashion, assigning their references to the instance variables
   that you just declared. 
   
   1. Consult the 
      [API Documentation](https://openjfx.io/javadoc/11/) and 
      for each class to see what constructors are available.
      
   1. Try to make the text content of visible nodes match the screenshot.
      
   1. For the `ImageView` object, we would like for you to create a separate
      [`Image`](https://openjfx.io/javadoc/11/javafx.graphics/javafx/scene/image/Image.html)
      object and use the 
      [`ImageView(Image)`](https://openjfx.io/javadoc/11/javafx.graphics/javafx/scene/image/ImageView.html#%3Cinit%3E(javafx.scene.image.Image)) constructor. 
      The URL string that you should provide to the `Image` constructor is:
   
      ```
      "http://cobweb.cs.uga.edu/~mec/cs1302/gui/default.png"
      ```
      
      **NOTE:** Do not use the `ImageView` constructor that directly takes a URL string.
      If you do, then it will make it potentially more difficult to change the image
      in a later step.
  
   1. Add any child nodes to their parent's 
      collection of children using `getChildren().add`. 
      
   1. **Recompile and run.**

1. Make sure your code passes the `checkstyle` audit, then stage and commit all changes.

1. If you completed the steps correctly, your app should look similar to
   the screenshot provided above. Congratulations on a good looking app!
   
<hr/>

![CP](https://img.shields.io/badge/Just%20Finished%20Checkpoint-1-success?style=for-the-badge)

<hr/>

### Checkpoint 2 Steps

Now that you have your app looking good, let's make it do stuff!

1. In the `start` method of your `ImageApp` class, declare a variable
   of type `EventHandler<ActionEvent>` called `loadHandler`, then assign
   to it, using a lambda expression, an implementation of
   `EventHandler<ActionEvent>` that prints out the text of the
   `TextField` to standard output (i.e., the terminal).
   **Recompile before continuing.**
   
   * Take special care that you import the correct `ActionEvent` class,
     as a quick Internet search may recommend the wrong one!
     Consult the 
    [API Documentation](https://openjfx.io/javadoc/11/) and 
    [referenced bookmarks](https://github.com/cs1302uga/cs1302-tutorials/blob/master/javafx/javafx-bookmarks.md)
     to determine the import statements that are needed.
     
1. Once your app is able to print the text from the `TextField` to 
   standard output, ammend the code so that is also creates an `Image`
   object using the supplied URL, then sets the `image` propery of
   the `ImageView` using the appropriated setter method.
   **Recompile before continuing.**
   
   * Here are some URLs to try when testing your program:
   
     * `http://csweb.cs.uga.edu/~mec/cs1302/gui/pikachu.png`
     * `http://csweb.cs.uga.edu/~mec/cs1302/gui/brad.jpg`
     * `http://csweb.cs.uga.edu/~mec/cs1302/gui/SuccessKid.jpg`
   
   * **We will check this:** 
     Your program should not crash when supplied invalid input. Use
     exception handling, as needed, to make the experience nicer
     for the user. While we will explore creating popup windows
     and dialogs in the future, it is sufficient to print a friendly
     error message to standard output instead of letting the
     program crash or display a stack trace.
     
1. Make sure your code passes the `checkstyle` audit, then stage and commit all changes.

1. If you completed the steps correctly, your app should not only look 
   similar to the screenshot provided above, but it has the desired
   functionality. Congratulations on a good looking, functional app!
        
<hr/>

![CP](https://img.shields.io/badge/Just%20Finished%20Checkpoint-2-success?style=for-the-badge)

<hr/>

# CE 20 Starts Here. Make it CP 3

1. Copy over your work from the `src/cs1302/gui` directory of `cs1302-components`
   (from the [CSCI 1302 JavaFX Custom Component Tutorial](https://github.com/cs1302uga/cs1302-tutorials/blob/master/components/components.md))
   into the `src/cs1302/ce21` directory of `cs1302-ce21` and update the package
   statements accordingly (i.e., make sure the package is `cs1302.ce21`). 
   **You should create `src/cs1302/ce21` if it does not exist.**
   
1. If you did not finish 
   [CSCI 1302 JavaFX Custom Component Tutorial](https://github.com/cs1302uga/cs1302-tutorials/blob/master/components/components.md), 
   then finish that work in the code you just copied over. Remember, in the custom
   component tutorial, you used custom components to reduce the containment heirarchy from this:
   
   ```
                                                             --|
                         Stage                                 |
                           |                                   |
                         Scene                                 |
          |--              |                                   |
          |               HBox                                 |
          |                |\                                  |
          |                | \------------------\              |
          |                |                    |              |
          |               VBox                 VBox            | Overall
          |               / \                  / \             | Containment
   Scene  |              /   \                /   \            | Hierarchy
   Graph  |            HBox  ImageView      HBox  ImageView    |
          |            / \                  / \                |
          |           /   \                /   \               |
          |    TextField  Button    TextField  Button          |
          |--                                                --|
   ```   
   
   to something like this:
   
   ```
                                                             --|
                         Stage                                 |
                           |                                   |
                         Scene                                 |
          |--              |                                   | Overall
          |               HBox                                 | Containment
   Scene  |                |\                                  | Hierarchy
   Graph  |                | \------------------\              |
          |                |                    |              |
          |           ImageLoader          ImageLoader         |
          |--                                                --|
   ```
   
1. **Compile and run your code without any errors or warnings,
   make sure it passes a `checkstyle` audit, 
   then stage and commit your changes.**
   
1. Tag your commit so that it's easier to checkout at a later
   point in time:
   
   ```
   $ git tag tutorial
   ```
   
   [Tagging](https://git-scm.com/book/en/v2/Git-Basics-Tagging) allows us
   to give the commit a more convenient name to a commit than its
   hexademical checksum.

<hr/>

![CP](https://img.shields.io/badge/Just%20Finished%20Checkpoint-1-success?style=for-the-badge)

<hr/>

### Checkpoint 2 Steps

1. Now, read the class-level API documentation for the
   [`TilePane`](https://openjfx.io/javadoc/11/javafx.graphics/javafx/scene/layout/TilePane.html)
   class, then adapt your code to replace the highest `HBox` in the 
   containment hiearchy with a `TilePane` object.
   
   * The `TilePane` object's `prefColumns` should be set to `4` using the appropriate setter
     method.
     
   * The `TilePane` object should have four `ImageLoader` objects as its children.
   
   Here is the corresponding containment hierarchy for what is expected:
   
   ```
                                                             --|
                              Stage                            |
                                |                              |
                              Scene                            |
          |--                   |                              | Overall
          |                 TilePane                           | Containment
   Scene  |                    /|\                             | Hierarchy
   Graph  |          /--------/ | \--------\                   |
          |         /          / \          \                  |
          |      ImageLoader  /   \        ImageLoader         |
          |                  /     \                           |
          |        ImageLoader     ImageLoader                 |
          |--                                                --|
   ```
   
1. **Compile and run your code without any errors or warnings,
   make sure it passes a `checkstyle` audit, 
   then stage and commit your changes.**
   
1. Now, increase the number of `ImageLoader` objects to `8`. This
   should be easy if you used a loop.
   
1. Commit these changes then tag your commit so that it's easier to checkout 
   at a later point in time:
   
   ```
   $ git tag tilepane
   ```
      
<hr/>

![CP](https://img.shields.io/badge/Just%20Finished%20Checkpoint-2-success?style=for-the-badge)

<hr/>

### Checkpoint 3 Steps

1. Now, read the class-level API documentation for the
   [`TabPane`](https://openjfx.io/javadoc/11/javafx.controls/javafx/scene/control/TabPane.html)
   and [`Tab`](https://openjfx.io/javadoc/11/javafx.controls/javafx/scene/control/Tab.html)
   classes, then adapt your code to replace the `TilePane` in the 
   containment hiearchy with a `TabPane` object.
    
   * The `TabPane` object should have four `Tab` objects, each containing an `ImageLoader` object
     as its child.
   
   Here is the corresponding containment hierarchy for what is expected:
   
   ```
                                                             --|
                              Stage                            |
                                |                              |
                              Scene                            |
          |--                   |                              | Overall
          |                  TabPane                           | Containment
   Scene  |                    /|\                             | Hierarchy
   Graph  |          /--------/ | \--------\                   |
          |        Tab          |          Tab                 |
          |        /           / \           \                 |
          |     ImageLoader  Tab Tab         ImageLoader       |
          |                  /     \                           |
          |        ImageLoader     ImageLoader                 |
          |--                                                --|
   ```
   
1. **Compile and run your code without any errors or warnings,
   make sure it passes a `checkstyle` audit, 
   then stage and commit your changes.**
   
1. Tag your commit so that it's easier to checkout at a later
   point in time:
   
   ```
   $ git tag tabpane
   ```

1. View the condensed, graphical version of your Git log.
   Since you tagged each relevant commit with a name, you
   can go back in time by checking out those commits more
   easily. For example,
   
   ```
   $ git checkout tutorial
   $ rm -rf bin/*
   ```
   
   Then, compile and run to see what your exercise looked like
   at that point in time!

<hr/>

![CP](https://img.shields.io/badge/Just%20Finished%20Checkpoint-3-success?style=for-the-badge)

<hr/>

### Submission Steps

**Each student needs to individually submit their own work.**

1. Create a plain text file called `SUBMISSION.md` directly inside the `cs1302-hw08`
   directory with the following information:

   1. Your name and UGA ID number
  
   Here is an example of the contents of `SUBMISSION.md`.
   
   ```
   Sally Smith (811-000-999)
   ```

1. Change directories to the parent of `cs1302-hw08` (e.g., `cd ..` from `cs1302-hw08`). If you would like
   to make a backup tar file, the instructions are in the submissions steps for [hw01](https://github.com/cs1302uga/cs1302-hw01).
   We won't repeat those steps here and you can view them as optional.
   
1. Use the `submit` command to submit this exercise to `csci-1302`:
   
   ```
   $ submit cs1302-hw08 csci-1302
   ```
   
   Read the output of the submit command very carefully. If there is an error while submitting, then it will displayed 
   in that output. Additionally, if successful, the `submit` command creates a new receipt file in the directory you 
   submitted. The receipt file begins with rec and contains a detailed list of all files that were successfully submitted. 
   Look through the contents of the rec file and always remember to keep that file in case there is an issue with your submission.

   **Note:** You must be on Odin to submit.

<hr/>

![CP](https://img.shields.io/badge/Just%20Finished-Submission-success?style=for-the-badge)

<hr/>

[![License: CC BY-NC-ND 4.0](https://img.shields.io/badge/License-CC%20BY--NC--ND%204.0-lightgrey.svg)](http://creativecommons.org/licenses/by-nc-nd/4.0/) [![License: CC BY-NC 4.0](https://img.shields.io/badge/Instructor%20License-CC%20BY--NC%204.0-lightgrey.svg)](http://creativecommons.org/licenses/by-nc/4.0/)

<small>
Copyright &copy; Michael E. Cotterell, Bradley J. Barnes, and the University of Georgia.
This work is licensed under 
a <a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/">Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License</a> to students and the public and licensed under
a <a rel="license" href="http://creativecommons.org/licenses/by-nc/4.0/">Creative Commons Attribution-NonCommercial 4.0 International License</a> to instructors at institutions of higher education.
The content and opinions expressed on this Web page do not necessarily reflect the views of nor are they endorsed by the University of Georgia or the University System of Georgia.
</small>
