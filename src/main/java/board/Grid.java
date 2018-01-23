/**
 * The Sodoku Grid - the full board
 *
 * Created by Olivia on 7/28/2017.
 */
package main.java.board;

import java.io.File;


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
    private boolean isSolvable(int r, int c){

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
        boolean[] options = getOptions(r, c);


        //time for some cray cray
        for(int i = 0; i< options.length; i++){
            if(options[i]){
                //grid[r][c] = new Tile(i+1, false);
                t.setValue(i+1);


                if(isSolvable(r+((c+1)/n), (c+1)%n)){
                    return true;
                }
            }
        }

        return false; //placeholder
    }

    public boolean solve(){
        return isSolvable(0, 0);
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


    private boolean[] getOptions(int r, int c){
        Tile t = grid[r][c];
        boolean[] options = new boolean[n];

        //initialize all possible to true
        for(int i = 0; i < n; i++){
            options[i] = true;
        }

        //row & col
        for(int i = 0; i < n; i++){
            //row
            if( i < c || grid[r][i].isValueSet() ){
                options[grid[r][i].getValue()-1] = false;
            }

            //col
            if(i < r || grid[i][c].isValueSet()) {
                options[grid[i][c].getValue() - 1] = false;
            }

        }

        //block
        int startRow = 3 * (r / 3);
        int startCol = 3 * (c / 3);
        for(int row = startRow; row < startRow + 3; row++){
            for(int col = startCol; col < startCol + 3; col++){
                Tile inspect = grid[row][col];
                if( row < r || ( row == r  && col < c ) || inspect.isValueSet()){
                    options[inspect.getValue()-1] = false;
                }
            }
        }


        return options;

    }

    public static void main(String[] args){
        Grid g = new Grid();

        int[][] values = { {0, 0, 9, 0, 1, 0, 0, 0, 0},
                {7, 0, 0, 0, 0, 4, 8, 0, 6},
                {0, 0, 0, 0, 0, 0, 7, 0, 1},
                {1, 0, 0, 8, 9, 0, 0, 0, 0},
                {0, 2, 0, 0, 5, 0, 0, 3, 0},
                {0, 0, 0, 0, 4, 6, 0, 0, 8},
                {5, 0, 2, 0, 0, 0, 0, 0, 0},
                {4, 0, 1, 6, 0, 0, 0, 0, 7},
                {0, 0, 0, 0, 3, 0, 5, 0, 0}


        };

        for(int r = 0; r < g.n; r++){
            for(int c = 0; c < g.n; c++){
                int val = values[r][c];
                if(val != 0){
                    g.grid[r][c] = new Tile(val);
                }
            }
        }


        System.out.println(g.toString());

        System.out.println("Solving... \n\n\n");

        boolean isSolvable = g.solve();


        System.out.println(g.toString());


        System.out.println("isSolvable: " + isSolvable);


    }
}
