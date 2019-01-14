package agh.cs.projekt2;

public class WorldMap {
    private int width;
    private int height;
    private Position upperRightCorner;
    private Position lowerLeftCorner;

    WorldMap(int width, int height) {
        this.width = width;
        this.height = height;
        this.upperRightCorner = new Position(width - 1, height - 1);
        this.lowerLeftCorner = new Position(0, 0);

    }

    boolean canMoveTo(Position position) {
        if (position.larger(this.lowerLeftCorner) && position.smaller(this.upperRightCorner) && !this.isOccupied(position))
            return true;
        else return false;
    }

    boolean isOccupied(Position position) {
        return true; // do zrobienia
    }
}
