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

    boolean isOver(){ //https://stackoverflow.com/questions/32770321/connect-4-check-for-a-win-algorithm
        //Check Horizontal
        for (int j = 0; j<board.size() -1; j++ ){
            ArrayList<Integer> row = board.get(j);
            for(int y = 0; y < row.size() - 3; y++){
                if (row.get(y) == 1 && row.get(y+1) == 1 &&row.get(y+2) == 1 && row.get(y+3) == 1){
                    return true;
                }   
                //System.out.println(row.get(y));
            }
        }

        // horizontalCheck 
        /* 
        int player = 1;
        for (int j = 0; j<board.size() ; j++ ){
            ArrayList<Integer> row = board.get(j);
            for (int i = 0; i<row.size() - 2; i++){
                
                if (row.get(j) == player && row.get(j+1) == player &&row.get(j+2) == player && row.get(j+3) == player){
                    return true;
                }           
            }
        }
        */
        
        return false;
    }

}
