package agh.cs.projekt2;

public class Position {
    public final int x;
    public final int y;

    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }
    @Override
    public String toString(){
        return "(" + this.x + "," + this.y + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        if (x != position.x) return false;
        if (y != position.y) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    public boolean smaller(Position other){
        if(this.x <= other.x && this.y <= other.y)
            return true;
        else
            return false;
    }
    public boolean larger(Position other){
        if(this.x >= other.x && this.y >= other.y)
            return true;
        else
            return false;
    }
    public Position upperRight(Position other){
        int x = Math.max(this.x, other.x);
        int y = Math.max(this.y, other.y);
        return new Position(x, y);
    }
    public Position lowerLeft(Position other){
        int x = Math.min(this.x, other.x);
        int y = Math.min(this.y, other.y);
        return new Position(x, y);
    }
    public Position add(Position other){
        int x = this.x + other.x;
        int y = this.y + other.y;
        return new Position(x, y);
    }
    public Position sub(Position other){
        int x = this.x - other.x;
        int y = this.y - other.y;
        return new Position(x, y);
}
