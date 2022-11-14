

public class Coordinate {
    int x, y;

    public Coordinate() {
        this(-1, -1);
    }

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Coordinate(Coordinate coordinate) {
        this(coordinate.x, coordinate.y);
    }
}
