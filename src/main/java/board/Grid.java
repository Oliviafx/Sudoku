/**
 * The Sodoku Grid - the full board
 *
 * Created by Olivia on 7/28/2017.
 */
package main.java.board;
import main.java.archived.Point;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
//import java.util.Scanner;

public class Grid {
    private int n = 9;
    Tile[][] grid = new Tile[n][n];

    public Grid() {
        for(int r = 0; r < 9; r++){
            for(int c = 0; c < 9; c++){
                grid[r][c] = new Tile();
            }
        }

    }

    /**
     * A file will be in the following format:
     *  <number> <number> <number>
     *      Where the first number is the Tile's row,
     *      the second number is the Tile's column,
     *      and the third number is the Tile's value (0-9)
     *
     * This method will also set up the input in grid
     *
     * @param f
     */
    public void readInput(File f){
        /*
        try {
            Scanner sc = new Scanner(f);
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                String[] eachTile = line.split("\\s+"); //this should be length 3
                assert(eachTile.length == 3);
                Point tileCoord = new Point(Integer.parseInt(eachTile[0]),Integer.parseInt(eachTile[1]));
            }

            System.out.println(Arrays.toString(grid));

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }
        */
    }


    /*
    public int bruteForce(int r, int c){
        Tile t = grid[r][c];
        boolean[] options = t.getOptions();
        for(int i = 0; i < options.length; i++){
            if(options[i]){
                t = new Tile(i+1, false);
                //set other options to not allow this one?

                break; //maybe instead of breaking just return recursively here?
            }
        }

        return 0; //placeholder return to just get it to stop screaming


    }
    */

    /**
     * A function that determines if the board is solvable
     *
     * Uses brute force.
     *
     * This function has the side effect of changing
     * the internal array of the grid object to the
     * solved array.
     *
     * @param r The row of the tile
     * @param c The column of the tile
     * @return true if the grid is solvable
     */
    public boolean isSolvable(int r, int c){

        //out of bounds
        if(r >= n){
            return true; //all tiles in the board have been solved
        }

        Tile t = grid[r][c];

        //if value is set, go to next value
        if(t.isValueSet()){
            return isSolvable(r+((c+1)/n), (c+1)%n);
        }

        //set options
        boolean[] options = t.getOptions();
        //figure out options for this
        // tile based off row, col, block

        //row & col
        for(int i = 0; i < n; i++){
            //row
            if(grid[r][i].getValue() != 0){
                options[grid[r][i].getValue()-1] = false;
            }

            //col
            if(grid[i][c].getValue() != 0) {
                options[grid[i][c].getValue() - 1] = false;
            }

        }

        //block
        //?????
        int startRow = 3 * (r / 3);
        int startCol = 3 * (c / 3);
        for(int row = startRow; row < startRow + 3; row++){
            for(int col = startCol; col < startCol + 3; col++){
                Tile inspect = grid[row][col];
                if(inspect.getValue() != 0){
                    options[inspect.getValue()-1] = false;
                }
            }
        }


        //time for some cray cray
        for(int i = 0; i< options.length; i++){
            if(options[i]){
                grid[r][c] = new Tile(i+1, false);
                if(isSolvable(r+((c+1)/n), (c+1)%n)){
                    return true;
                }
            }
        }

        return false; //placeholder
    }



    public void solve(){
        pencilingIn();

    }

    /**
     * looking @ rows & cols
     * to determine if something
     * is possible
     * @param t
     */
    public void crossHatching(Tile t){
        int value = t.getValue();

        //determine if any of the

    }

    /**
     *  The penciling in method involves
     *  crossing off options that are
     *  no longer possible for a tile
     */
    public void pencilingIn(){
        //determine options
    }


    public String toString(){
        StringBuilder info = new StringBuilder();

        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[r].length; c++){
                Tile t = grid[r][c];
                info.append(t.getValue()).append(" ");

                if(c % 3 == 2){
                    info.append(" ");
                }
            }
            if(r % 3 == 2){
                info.append("\n");
            }
            info.append("\n");
        }

        return info.toString();
    }




    public static void main(String[] args){
        Grid g = new Grid();
        g.grid[0][0] = new Tile(3);
        g.grid[0][2] = new Tile(6);
        g.grid[0][6] = new Tile(8);
        g.grid[0][8] = new Tile(9);

        g.grid[1][2] = new Tile(2);
        g.grid[1][5] = new Tile(9);

        g.grid[2][2] = new Tile(5);
        g.grid[2][5] = new Tile(6);
        g.grid[2][7] = new Tile(2);

        g.grid[3][1] = new Tile(2);
        g.grid[3][4] = new Tile(7);
        g.grid[3][8] = new Tile(3);

        g.grid[4][3] = new Tile(1);
        g.grid[4][5] = new Tile(5);

        g.grid[5][0] = new Tile(1);
        g.grid[5][4] = new Tile(2);
        g.grid[5][7] = new Tile(8);

        g.grid[6][1] = new Tile(4);
        g.grid[6][3] = new Tile(5);
        g.grid[6][6] = new Tile(2);

        g.grid[7][3] = new Tile(4);
        g.grid[7][6] = new Tile(1);

        g.grid[8][0] = new Tile(8);
        g.grid[8][2] = new Tile(3);
        g.grid[8][6] = new Tile(6);
        g.grid[8][8] = new Tile(5);

        System.out.println(g.toString());

        System.out.println("Solving... \n\n\n");

        boolean isSolvable = g.isSolvable(0,0);


        System.out.println(g.toString());


        System.out.println("isSolvable: " + isSolvable);


    }
}
