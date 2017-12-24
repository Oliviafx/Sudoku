package main.java.board;

/**
 * The coordinates for each tile
 *
 * Should have each r and c value range from 0-8
 *
 * Created by Olivia on 7/28/2017.
 */
public class Point {
    private int row;
    private int col;

    public Point(int row, int col){
        this.row = row;
        this.col = col;
    }

    public int getRow(){
        return row;
    }

    public int getCol(){
        return col;
    }
}
