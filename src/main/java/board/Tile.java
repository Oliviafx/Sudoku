package main.java.board;


/**
 * Created by Olivia on 7/28/2017.
 */
public class Tile {

    private int value;
    private boolean guaranteed;

    /**
     * This constructor is used on set up
     * value auto set to 0
     */
    public Tile(){
        value = 0;
        guaranteed = false;
    }

    /**
     * This constructor is used on set up
     * Values are set, guaranteed
     *
     * @param value
     */
    public Tile(int value){
        this.value = value;
        guaranteed = true;
    }

    /**
     * This constructor is used when solving
     * values are set, not necessarily guaranteed
     *
     * @param value
     * @param isGuaranteed
     */
    public Tile(int value, boolean isGuaranteed){
        this.value = value;
        guaranteed = isGuaranteed;
    }

    public int getValue(){
        return this.value;
    }

    public void setValue(int val){
        value = val;
    }


    public boolean isValueSet(){
        return guaranteed;
    }


}
