import java.util.ArrayList;



public class Game {
    ArrayList<ArrayList<Integer>> board = new ArrayList<ArrayList<Integer>>(); //0 = empty / 1 = player / 2 = computer
    Status status;    

    Game(){ //Constructor
        createEmptyBoard();
        status = Status.ACTIVE;
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
        for (int j = 0; j<board.size(); j++ ){
            ArrayList<Integer> row = board.get(j);
            for(int y = 0; y < row.size() - 3; y++){
                if (row.get(y) == 1 && row.get(y+1) == 1 &&row.get(y+2) == 1 && row.get(y+3) == 1){
                    return true;
                }   
                //System.out.println(row.get(y));
            }
        }

        //Check Vertical
        for (int r = 0; r<board.size() - 3 ; r++ ){
            for (int c = 0; c<board.get(r).size(); c++){
                if (board.get(r).get(c) == 1 && board.get(r+1).get(c) == 1 && board.get(r+2).get(c) == 1 && board.get(r+3).get(c) == 1){
                    return true;
                }           
            }
        }

        //Check Ascending Diagonal
        for (int r = 3; r<board.size(); r++){
            for (int c = 0; c<board.get(r).size() - 3; c++){
                if (board.get(r).get(c) == 1 && board.get(r-1).get(c+1) == 1 && board.get(r-2).get(c+2) == 1 && board.get(r-3).get(c+3) == 1){
                    return true;
                }
            }
        }

        //Check Descending Diagonal
        for (int r = 3; r<board.size(); r++){
            for (int c = 3; c<board.get(r).size(); c++){
                if (board.get(r).get(c) == 1 && board.get(r-1).get(c-1) == 1 && board.get(r-2).get(c-2) == 1 && board.get(r-3).get(c-3) == 1){
                    return true;
                }
            }
        }
        
        return false;
    }

}
