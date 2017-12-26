package main.java.gui;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Dialog;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.net.URL;

/**
 * Created by Olivia on 12/23/2017.
 */
public class GUI extends Application{

    private Window window;

    private Canvas canvas;

    private double x;
    private double y;
    private double tileWidth = 86.6;
    private double startX = tileWidth;
    private double startY = tileWidth;


    public static void main(final String[] args){
        Application.launch();
    }

    @Override
    public void start(final Stage stage){
        final URL r = getClass().getResource("grid.fxml");
        if(r == null){
            System.out.println("No FXML resource found.");
        }

        try {
            final Parent node = FXMLLoader.load(r);
            final Scene scene = new Scene(node);
            stage.setTitle("Sudoku");
            stage.setScene(scene);
            stage.sizeToScene();
            window = stage;

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void draw(){
        GraphicsContext gc = canvas.getGraphicsContext2D();
    }

    @FXML
    public void aboutSudoku(){
        Dialog<String> info = new Dialog<String>();
        info.setGraphic(null);
        Window window = info.getDialogPane().getScene().getWindow();
       // window.setOnCloseRequest(event -> window.hide());

        info.setTitle("Sudoku v1.0");
        info.setHeaderText("Welcome to Sudoku Version 1.0!");
        info.setContentText("You are currently exploring Sudoku v1.0!" + "\n\n"
            + "Here are some tips to help you get started:" + "\n\n\t"
                +"1. If you want to reset something"
                +"\n\n\nThis is a project by Olivia Xiang"
        );

        if(!info.isShowing()) info.show();

    }

}
