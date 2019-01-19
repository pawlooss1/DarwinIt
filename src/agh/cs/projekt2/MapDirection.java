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

    public MapDirection rotateRight() {
        switch (this) {
            case NORTH:
                return NORTH_EAST;
            case SOUTH:
                return SOUTH_WEST;
            case EAST:
                return SOUTH_EAST;
            case WEST:
                return NORTH_WEST;
            case NORTH_EAST:
                return EAST;
            case NORTH_WEST:
                return NORTH;
            case SOUTH_EAST:
                return SOUTH;
            case SOUTH_WEST:
                return WEST;
        }
        return NORTH;
    }

    public int computeDeltaX() {
        switch (this) {
            case NORTH:
                return 0;
            case NORTH_WEST:
                return 1;
            case WEST:
                return 1;
            case SOUTH_WEST:
                return 1;
            case SOUTH:
                return 0;
            case SOUTH_EAST:
                return -1;
            case EAST:
                return -1;
            case NORTH_EAST:
                return -1;
        }
        return 0;
    }

    public int computeDeltaY() {
        switch (this) {
            case NORTH:
                return 1;
            case NORTH_WEST:
                return 1;
            case WEST:
                return 0;
            case SOUTH_WEST:
                return -1;
            case SOUTH:
                return -1;
            case SOUTH_EAST:
                return -1;
            case EAST:
                return 0;
            case NORTH_EAST:
                return 1;
        }
        return 0;
    }
}
