import java.util.Random;
import java.util.ArrayList;


public class Computer {
    Computer(){ //Constructor

    }


    static void move(Game game){
        Random rand = new Random();
        int selectedColumn = rand.nextInt(7); //Random column
        for(int y = game.board.size() - 1; y >= 0; y--){ //Loop backwards (Start from bottom)
            ArrayList<Integer> row = game.board.get(y);
            if(row.get(selectedColumn) == 0){
                row.set(selectedColumn, 2);
                return;
            }
        }

        move(game); //remove later
    }
}
