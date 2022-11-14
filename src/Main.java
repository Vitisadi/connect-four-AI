


import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;
//https://commons.wikimedia.org/wiki/Category:PNG_chess_pieces/Standard_transparent



public class Main extends PApplet {
    ArrayList<ArrayList<Piece>> board = new ArrayList<ArrayList<Piece>>();



    public static PApplet processing;
    public void settings () {
        size(800, 800);
    }

    public void setup() {
        processing = this;
    }

    public void draw() {
        background(255,0,0);
        drawBoard();
        for (ArrayList<Piece> yList : board) {
            for (Piece piece : yList) {
                if (piece != null ){
                    piece.display();
                }
            }
        }
    }

    public void mousePressed(){
        Coordinate coordinate = findMouseLocation();
        
    }

    public static void main(String[] args) {
        PApplet.main("Main");
    }

    void drawBoard(){
        
    }



    Coordinate findMouseLocation(){ //ar[0] = x & ar[1] = y
        Coordinate coordinate = new Coordinate(mouseX / 100, 7 - mouseY / 100);

        if (coordinate.x >7 || coordinate.y < 0) {
            return null;
        }
        return coordinate;
    }

    
}


