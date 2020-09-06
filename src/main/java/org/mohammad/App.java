package org.mohammad;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {
    public static void main(String[] args) {
        launch();
    }

//   const Varibles
    public static final double WIDTH = 800;
    public static final double HEIGHT = 800;

    @Override
    public void start(Stage stage) {

        BorderPane root = new BorderPane();

        //middle of app contains convas
        Canvas canvas = new Canvas(WIDTH - 200, HEIGHT - 100);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // top contains Toolbar
        MenuBar menuBar = getMenuBar();
        // canvas drawing
        draw(gc);
        // left Items
        VBox leftVobx = getVbox();

        root.setTop(menuBar);
        root.setCenter(canvas);
        root.setLeft(leftVobx);




        Scene scene = new Scene(root, WIDTH, HEIGHT);
        scene.getStylesheets().add("Main.css");
        stage.setScene(scene);
        stage.show();
    }

    /** erstellt die Menubar oben am bildschirm*/
    private MenuBar getMenuBar() {
        MenuBar menuBar = new MenuBar();

    //              FILE MENU
        Menu fileMenu = new Menu("File");
        MenuItem newFileItem = new MenuItem("New");
        Menu openPrevItem = new Menu("Open Previus");
        MenuItem saveItem = new MenuItem("Save");
        MenuItem saveAsItem = new MenuItem("Save as");
        MenuItem exitItem = new MenuItem("Exit");

        fileMenu.getItems().addAll(newFileItem , openPrevItem , saveItem, saveAsItem, exitItem);


    //              TOOLS Menu
        Menu toolsMenu = new Menu("Tools");

    //              Filter Menu
        Menu filterMenu = new Menu("Filter");

    //              HELP Menu
        Menu helpMenu = new Menu("Help");


    //              EXIT Menu
        Menu exitMenu = new Menu("Exit");



        menuBar.getMenus().addAll(fileMenu, toolsMenu, filterMenu, helpMenu, exitMenu);
        return menuBar;
    }


    /**das mittle von App, Canvas*/
    private void draw(GraphicsContext gc) {
//        Hinterground
        gc.setFill(Color.BLACK);
        gc.fillRect(0,0,WIDTH, HEIGHT);


        gc.setFill(Color.rgb(255,255,255));
        String text = "this is the first Canvas";
        gc.setFont(Font.font("Arial", 20));
        gc.fillText(text, gc.getCanvas().getWidth()/3 -5, 20);


        gc.getCanvas().addEventHandler(MouseEvent.MOUSE_DRAGGED, e->{

            gc.setFill(Color.WHITE);
            gc.fillRect((e.getX() ), (e.getY()) , 5, 5);
        });


    }


    /**left Items von App*/
    private VBox getVbox() {
        VBox vbox = new VBox(5);


        ColorPicker colorPicker = new ColorPicker(Color.WHITE);
        colorPicker.setTranslateY(35.0);
        vbox.getChildren().addAll(colorPicker);

        return vbox;
    }




}