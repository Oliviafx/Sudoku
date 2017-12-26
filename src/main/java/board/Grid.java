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
import java.util.HashMap;
import java.util.Scanner;

public class Grid {
    private HashMap<String, boolean[]> checker = new HashMap<String, boolean[]>();
    private HashMap<Point, Integer> solvedTiles = new HashMap<Point, Integer>();
    private int[][] grid = new int[9][9];

    public Grid() {
        //initialize arrays for the checker
        for(int i = 0; i < 9; i++){
            String rowName = "row"+i;
            String colName = "col"+i;
            String blockName = "block"+i;
            checker.put(rowName, new boolean[9]);
            checker.put(colName, new boolean[9]);
            checker.put(blockName, new boolean[9]);
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
        try {
            Scanner sc = new Scanner(f);
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                String[] eachTile = line.split("\\s+"); //this should be length 3
                assert(eachTile.length == 3);
                Point tileCoord = new Point(Integer.parseInt(eachTile[0]),Integer.parseInt(eachTile[1]));
                solvedTiles.put(tileCoord, Integer.parseInt(eachTile[2]));
                grid[Integer.parseInt(eachTile[0])][Integer.parseInt(eachTile[1])] = Integer.parseInt(eachTile[2]);
            }

            System.out.println(Arrays.toString(grid));

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }
    }



    //todo check if this is actually needed based off implementation
    /**
     * Checks to make sure the Sodoku invariant is held
     *
     * @return false if there are no repeats, true if there is a repeat
     */
    public boolean checkForRepeats(Tile t){
        int row = t.getCoord().getRow();
        int col = t.getCoord().getCol();

        int[] nearbyrows = getNearbyRows(t);
        int[] nearbycols = getNearbyCols(t);

        boolean check1 = checker.get("row"+nearbyrows[0])[nearbyrows[0]];
        boolean check2 = checker.get("row"+nearbyrows[1])[nearbyrows[1]];
        boolean check3 = checker.get("col"+nearbycols[0])[nearbycols[0]];
        boolean check4 = checker.get("col"+nearbycols[1])[nearbycols[1]];

        return (check1||check2||check3||check4);
    }

    public void solve(){
        pencilingIn();

    }

    public void crossHatching(Tile t){

    }

    public void pencilingIn(){
        //do this at the beginning of solving
        for(int r = 0; r < 9; r++){
            for(int c = 0; c < 9; c++){
                //how to get a tile with these coordinates??
            }
        }
    }

    //todo fix this lmao
    public void printGrid(int[][] input){
        StringBuilder info = new StringBuilder();
        //loop through the rows
        for(int r = 0; r < 9; r++){
            for(int c = 0; c < 9; c++){
                info.append(input[r][c]);
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

        System.out.println(info.toString());
    }

    public int[] determineSameBlock(int value){
        int[] nearby;

        switch(value){
            case 0:case 3:case 6:
                nearby = new int[]{value + 1, value+2};
                break;
            case 1:case 4:case 7:
                nearby = new int[]{value-1, value+1};
                break;
            case 2:case 5:case 8:
                nearby = new int[]{value-2, value-1};
                break;
            default:
                nearby = new int[2];
                break;
        }

        return nearby;

    }

    public int[] getNearbyRows(Tile t){
        return determineSameBlock(t.getCoord().getRow());
    }

    public int[] getNearbyCols(Tile t){
        return determineSameBlock(t.getCoord().getCol());
    }


    public static void main(String[] args){
        Grid g = new Grid();
        g.grid[0][0] = 1;
        g.grid[5][6] = 7;
        g.grid[2][3] = 4;

        g.printGrid(g.grid);

    }
}
