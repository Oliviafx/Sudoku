package main.java.archived;

import main.java.board.Grid;

import java.io.File;

/**
 * Created by Olivia on 12/25/2017.
 */
public class Main {
    public static void main(String[] args){
        File f = new File(args[0]);
        System.out.println(f.exists());
        Grid g = new Grid();
        g.readInput(f);
    }
}
