package main.java.board;

import main.java.board.Point;

/**
 * Created by Olivia on 7/28/2017.
 */
public class Tile {
    private Point coord;
    private int val, row, col, block;
    private boolean fill;

    public Tile(Point coordinate, int value, int row, int column, int block, boolean filled){
        coord = coordinate;
        val = value;
        this.row = row;
        col = column;
        this.block = block;
        fill = filled;
    }

    public Tile(int row, int column, int value){
        val = value;
        this.row = row;
        col = column;
        fill = value == 0? false : true;
    }

    public Point getCoord(){
        return coord;
    }

    public int getVal(){
        return val;
    }

    public void setVal(int value){
        val = value;
        fill = true;
    }

    public boolean isEmpty(){
        if(val != 0){
            fill = true;
        }else{
            fill = false;
        }

        return fill;
    }



}
