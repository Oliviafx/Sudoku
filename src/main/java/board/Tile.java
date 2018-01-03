package main.java.board;


/**
 * Created by Olivia on 7/28/2017.
 */
public class Tile {

    private int value;
    private boolean[] options = new boolean[9]; //initializes false
    private int n = options.length;
    private boolean guaranteed;

    /**
     * This constructor is used on set up
     * value auto set to 0
     */
    public Tile(){
        value = 0;
        for(int i = 0; i < n; i++){
            options[i] = true;
        }
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
        options[value-1] = true;
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

    public boolean[] getOptions(){
        return options;
    }

    /**
     * Sets an option to true
     *
     * setOption(3) states that this tile
     *  can possibly be 3
     *
     * @param index the value that is valid,
     *              a value from 1-9
     */
    public void setOption(int index){
        options[index-1] = true;
    }

    /**
     * Sets an option to false, usually
     * after getting the actual value
     *
     * deleteOption(3) removes 3 from being
     *  a valid option
     *
     * @param index the value that is no
     *              longer valid, a value
     *              from 1-9
     */
    public void deleteOption(int index){
        options[index-1] = false;
    }

    /**
     * Sets all values in options to false
     * besides the one at index-1
     * @param index
     */
    public void valueFound(int index){
        for(int i = 0; i < n; i++){
            options[i] = (i == value - 1);
        }
    }

    public boolean isValueSet(){
        return guaranteed;
    }


}
