package sample;

import javafx.scene.control.Button;

/**
 * Created by andrewbasore on 6/17/16.
 */
public class Tile {
    /*
    Tile object holds all information for each game tile such as
    coordinates, existence of a mine, and #of adjacent mines as well
    as a button object to display the tile
     */

    int xCoordinate;     //Coordinates use upper-left tile as origin.
    int yCoordinate;
    int numAdjacentMines;
    boolean hasMine = false;
    boolean hasBeenStepped = false;
    Button tileButton = new Button();

    //Constructor stores coordinate information for game tile
    public Tile(int x, int y){
        this.xCoordinate = x;
        this.yCoordinate = y;

    }

    //GameBoard class will call placeMine() to place a mine on this tile
    public void placeMine(){
        hasMine = true;
    }

    //hasMine() returns current value of this.hasMine
    public boolean hasMine(){
        return this.hasMine;
    }

    //Gameboard will perform a calculation, and set this value to the tile object
    public void setNumAdjacentMines(int numAdjacentMines){
        this.numAdjacentMines = numAdjacentMines;
    }

    //Getter method of numAdjacentMines
    public int getNumAdjacentMines(){
        return this.numAdjacentMines;
    }

    //updateButton() reads conditions on the tile and updates the
    //text displayed appropriately.
    private void updateButton(){
        if(this.hasBeenStepped == false){
            this.tileButton.setText(" ");
        }
        else if(this.hasMine == false){
            //if(adjacentmines == 0){
            this.tileButton.setText("__");
            //}
            //else this.tileButton.setText(numAdjacentMines);
        }
        else{
            //Death/fail event happens here
            this.tileButton.setText("*");
        }
    }

    //This function executes whenever a player steps on a tile
    public void step(){
        this.hasBeenStepped = true;
        updateButton();
    }



}
