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
import java.util.Scanner;

public class Grid {
    Tile[][] grid = new Tile[9][9];

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

    }

    /**
     *  The penciling in method involves
     *  crossing off options that are
     *  no longer possible for a tile
     */
    public void pencilingIn(){

    }


    public String toString(){
        StringBuilder info = new StringBuilder();

        for(int r = 0; r < 9; r++){
            for(int c = 0; c < 9; c++){
                Tile t = grid[r][c];
                info.append(t.getValue());
                info.append(" ");

                if(c == 2 || c == 5 ){
                    info.append("  ");
                }
                if(c == 8){
                    info.append("\n");
                }
            }

            if(r == 2 || r == 5 ){
                info.append("\n");
            }
        }

        return info.toString();
    }




    public static void main(String[] args){
        Grid g = new Grid();
        g.grid[0][0] = new Tile(1);
        g.grid[5][6] = new Tile(7);
        g.grid[2][3] = new Tile(4);

        System.out.println(g.toString());


    }
}
