
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Piece {
    final static int MAX_Y = 7;
    final static int MIN_Y = 0;
    final static int MAX_X = 7;
    final static int MIN_X = 0;

    boolean white;
    int x;
    int y;


    Piece(boolean white, int x, int y){
        this.white = white;
        this.x = x;
        this.y = y;
    }

    void display() {
    }

    public String getNotation() {
        return (char) ('a' + x) + "" + (y + 1);
    }

    boolean checkWhite(){
        return white;
    }

    boolean isValidMove (Coordinate from, Coordinate to, ArrayList<ArrayList<Piece>> chessBoardPieces) {
        return from != null && to != null;
    }

    List<Coordinate> findValidMoves (Coordinate from, ArrayList<ArrayList<Piece>> chessBoardPieces){
        return Collections.emptyList();
    }

    @Override
    public String toString() {
        return "Piece{" +
                "white=" + white +
                '}';
    }

//    public boolean inCheck(){
//        return true;
//    }

    //    Integer[] getLocation(){
//        Integer[] locationCoordinates = new Integer[2];
//        locationCoordinates[0] = x;
//        locationCoordinates[1] = y;
//        return locationCoordinates;    }
}
