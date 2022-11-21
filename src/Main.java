import processing.core.PApplet;

import java.util.ArrayList;

//https://commons.wikimedia.org/wiki/Category:PNG_chess_pieces/Standard_transparent



public class Main extends PApplet {
    Game game = new Game();
    Computer computer = new Computer();
    boolean helperChip = true; //True = enabled / False = disables - Grey helper chip to show where moving
    //boolean gameEnded = true;
    //boolean playerWin = false;



    public static PApplet processing;
    public void settings () {
        size(750, 650);
    }

    public void setup() {
        processing = this;
        //game.status = Status.COMPUTER_WIN;
    }

    public void draw() {
        background(50, 162, 168);
        drawBoard();
        if(Status.ACTIVE != game.status){ //If game not active
            drawEnding();
        }
    }

    public void mousePressed(){
        //Prevent interaction on end of game
        if(Status.ACTIVE != game.status){
            return;
        }


        int mouseColumn = findMouseLocation();

        //Add User Chip
        if (mouseColumn == -1){
            return;
        }

        for(int y = game.board.size() - 1; y >= 0; y--){ //Loop backwards (Start from bottom)
            ArrayList<Integer> row = game.board.get(y);
            if(row.get(mouseColumn) == 0){
                //Moves happen here
                row.set(mouseColumn, 1);
                if(game.isOver()){
                    game.status = Status.PLAYER_WIN;
                    return;
                } 
                Computer.move(game);
                if(game.isOver()){
                    game.status = Status.COMPUTER_WIN;
                    return;
                }
                return;
            }
        }
    }

    public static void main(String[] args) {
        PApplet.main("Main");
    }

    void drawEnding(){
        textAlign(CENTER);
        textSize(75);
        fill(0);

        if(game.status == Status.COMPUTER_WIN){
            text("You lose!", width/2, 100);
        } 
        else if(game.status == Status.PLAYER_WIN){
            text("You Win!", width/2, 100);
        }
        else if(game.status == Status.DRAW){
            text("Draw!", width/2, 100);
        }
        else { //In theory should never get here
            text("An error occured", width/2, 100);
        }
    }

    void drawBoard(){
        //Chips
        int mouseColumn = findMouseLocation();
        boolean mouseColumnDrawn = false;
        for (int y = game.board.size() - 1; y >= 0; y--) { //Loop backwards (Start from bottom)
            ArrayList<Integer> row = game.board.get(y);
            for (int x = 0; x < row.size(); x++) {
                int value = row.get(x);
                if (value == 0){ //Neutral
                    if(mouseColumn == x && !mouseColumnDrawn && helperChip && game.status == Status.ACTIVE){
                        fill(188, 212, 195);
                        mouseColumnDrawn = true;
                    } else {
                        fill(255);
                    }
                } else if(value == 1){ //Player
                    fill(218, 224, 20);
                } else { //Computer
                    fill(181, 11, 39);
                }

                ellipse(75 + x * 100, 75 + y * 100, 90, 90);
            }

            
        }

        if(game.status != Status.ACTIVE) return;

        //Tint
        if (mouseColumn == -1){
            return;
        }
        int bound = 75 - 50 + 100 * mouseColumn;
        fill(255, 50);
        noStroke();
        rect(bound, 0, 100, height, 10);
        stroke(1);
    }
    
    void setupBoard(){
        for(int row = 0; row < 6; row++){
            ArrayList<Integer> rowList  = new ArrayList<>();
            for(int column = 0; column < 7; column++){
                rowList.add(0);
            }
            game.board.add(rowList);
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


