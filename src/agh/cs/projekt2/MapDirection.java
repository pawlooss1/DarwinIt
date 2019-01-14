package agh.cs.projekt2;

public enum MapDirection {
    NORTH,
    SOUTH,
    EAST,
    WEST,
    NORTH_EAST,
    NORTH_WEST,
    SOUTH_EAST,
    SOUTH_WEST;

    public String toString() {
        switch (this) {
            case NORTH:
                return "Północ";
            case SOUTH:
                return "Południe";
            case EAST:
                return "Wschód";
            case WEST:
                return "Zachód";
            case NORTH_EAST:
                return "Północny-wschód";
            case NORTH_WEST:
                return "Północny-zachód";
            case SOUTH_EAST:
                return "Południowy wschód";
            case SOUTH_WEST:
                return "Południowy-zachód";
        }
        return "";
    }
    public MapDirection next() {
        switch (this) {
            case NORTH:
                return EAST;
            case SOUTH:
                return WEST;
            case EAST:
                return SOUTH;
            case WEST:
                return NORTH;
        }
        return NORTH;
    }
    public MapDirection previous() {
        switch (this) {
            case NORTH:
                return WEST;
            case SOUTH:
                return EAST;
            case EAST:
                return NORTH;
            case WEST:
                return SOUTH;
        }
        return NORTH;
    }
}
