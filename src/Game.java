import java.util.ArrayList;


public class Game {
    ArrayList<ArrayList<Integer>> board = new ArrayList<ArrayList<Integer>>(); //0 = empty / 1 = player / 2 = computer

    Game(){ //Constructor
        createEmptyBoard();
    }

    void createEmptyBoard(){
        for(int row = 0; row < 6; row++){
            ArrayList<Integer> rowList  = new ArrayList<>();
            for(int column = 0; column < 7; column++){
                rowList.add(0);
            }
            board.add(rowList);
        }
    }

    void getWinningRow(){
        //If 4 in a row is found return a list of 4 "Coordinates" (Another class)
        //If none is found return an empty list
    }
}
