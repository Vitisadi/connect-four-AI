


import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;
//https://commons.wikimedia.org/wiki/Category:PNG_chess_pieces/Standard_transparent



public class Main extends PApplet {
    ArrayList<ArrayList<Integer>> board = new ArrayList<ArrayList<Integer>>(); //0 = empty / 1 = player / 2 = computer
    PImage board_image;



    public static PApplet processing;
    public void settings () {
        size(750, 650);
    }

    public void setup() {
        processing = this;
        setupBoard();
    }

    public void draw() {
        background(50, 162, 168);
        drawBoard();
    }

    public void mousePressed(){
        int coordinate = findMouseLocation();
        print(coordinate);
    }

    public static void main(String[] args) {
        PApplet.main("Main");
    }

    void drawBoard(){
        for (int y = 0; y < board.size(); y++) {
            ArrayList<Integer> row = board.get(y);
            for (int x = 0; x < row.size(); x++) {
                int value = row.get(x);
                if (value == 0){ //Neutral
                    fill(255);
                } else if(value == 1){ //Player
                    fill(218, 224, 20);
                } else { //Computer
                    fill(181, 11, 39);
                }
                ellipse(75 + x * 100, 75 + y * 100, 90, 90);
            }

            //Tint here
        }
    }

    void setupBoard(){
        for(int row = 0; row < 6; row++){
            ArrayList<Integer> rowList  = new ArrayList<>();
            for(int column = 0; column < 7; column++){
                rowList.add(0);
            }
            board.add(rowList);
        }
    }


    Integer findMouseLocation(){ //75 - 45 + 100 * (0), 75 + 45 + 100 * 0
        for(int column = 0; column < 7; column++){
            int lowBound = 75 - 50 + 100 * column;
            int highBound = 75 + 50 + 100 * column;
            if (mouseX > lowBound && mouseX < highBound){
                return column;
            }
        }
        return -1;
    }

    
}


