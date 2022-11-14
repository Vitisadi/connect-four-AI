

import processing.core.PImage;

import java.util.ArrayList;

//Main.processing.line(50,50,100,50);
public class Pawn extends Piece {
    private static PImage WHITE_IMAGE;
    private static PImage BLACK_IMAGE;

    Pawn(boolean white, int x, int y) {
        super(white, x, y);
    }

    void display() {
        if (WHITE_IMAGE == null) {
            WHITE_IMAGE = Main.processing.loadImage("assets/wPawn.png");
            BLACK_IMAGE = Main.processing.loadImage("assets/bPawn.png");
        }
        Main.processing.image(white ? WHITE_IMAGE : BLACK_IMAGE, 100 * x, 700 - 100 * y, 100, 100);
    }

    @Override
    boolean isValidMove(Coordinate from, Coordinate to, ArrayList<ArrayList<Piece>> chessBoardPieces) {
        if (!super.isValidMove(from, to, chessBoardPieces)) {
            return false;
        }
        if (white) {
            if (from.y == 1 && to.y == 3 && from.x == to.x && chessBoardPieces.get(to.x).get(to.y) == null) {
                return true;
            } else if (from.x == to.x && from.y == to.y - 1 && chessBoardPieces.get(to.x).get(to.y) == null) {
                return true;
            } else if (from.x == to.x + 1 && from.y == to.y - 1) {
                Piece piece = chessBoardPieces.get(to.x).get(to.y);
                if (piece != null && piece.white != this.white)
                    return true;
            } else if (from.x == to.x - 1 && from.y == to.y - 1) {
                Piece piece = chessBoardPieces.get(to.x).get(to.y);
                if (piece != null && piece.white != this.white)
                    return true;
            }
        } else {
            if (from.y == 6 && to.y == 4 && from.x == to.x && chessBoardPieces.get(to.x).get(to.y) == null) {
                return true;
            } else if (from.x == to.x && from.y == to.y + 1 && chessBoardPieces.get(to.x).get(to.y) == null) {
                return true;
            } else if (from.x == to.x + 1 && from.y == to.y + 1) {
                Piece piece = chessBoardPieces.get(to.x).get(to.y);
                if (piece != null && piece.white != this.white)
                    return true;
            } else if (from.x == to.x - 1 && from.y == to.y + 1) {
                Piece piece = chessBoardPieces.get(to.x).get(to.y);
                if (piece != null && piece.white != this.white)
                    return true;
            }
        }
        return  false;
    }

//    public boolean isCaptured(){
//
//    }

    public String getNotation() {
        return "P" + super.getNotation();
    }

    @Override
    public String toString() {
        return "Pawn {" + getNotation() +
                ", x=" + x +
                ", y=" + y +
                ", white=" + white +
                '}';
    }
}
