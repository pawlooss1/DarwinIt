package agh.cs.projekt2;

public class Plant {
    private Position position;

    public Plant(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "*";
    }
}
