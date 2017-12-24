/**
 * The Sodoku Grid - the full board
 *
 * Created by Olivia on 7/28/2017.
 */
package main.java.board;
import java.util.HashMap;

public class Grid {
    private HashMap<String, boolean[]> checker = new HashMap<String, boolean[]>();


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
        printGrid();
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
    public void printGrid(){
        StringBuilder info = new StringBuilder();
        //loop through the rows
        for(int i = 0; i < 9; i++){
            info.append(i);
            info.append(" ");
            if(i == 2 || i == 5 || i == 8){
                info.append("\n");
            }
        }

       // System.out.println(info.toString());
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
}
