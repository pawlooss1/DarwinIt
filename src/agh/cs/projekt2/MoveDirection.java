package agh.cs.projekt2;

import java.util.LinkedList;
import java.util.List;

public enum MoveDirection {
    FORWARD,
    BACKWARD,
    RIGHT,
    LEFT,
    FORWARD_RIGHT,
    FORWARD_LEFT,
    BACKWARD_RIGHT,
    BACKWARD_LEFT;

    public static List<MoveDirection> getAllDirections() {
        List<MoveDirection> result = new LinkedList<>();
        result.add(MoveDirection.FORWARD_LEFT);
        result.add(MoveDirection.FORWARD);
        result.add(MoveDirection.FORWARD_RIGHT);
        result.add(MoveDirection.RIGHT);
        result.add(MoveDirection.BACKWARD_RIGHT);
        result.add(MoveDirection.BACKWARD);
        result.add(MoveDirection.BACKWARD_LEFT);
        result.add(MoveDirection.LEFT);
        return result;
    }

    public int howManyRotations() {
        switch (this) {
            case FORWARD:
                return 0;
            case FORWARD_RIGHT:
                return 1;
            case RIGHT:
                return 2;
            case BACKWARD_RIGHT:
                return 3;
            case BACKWARD:
                return 4;
            case BACKWARD_LEFT:
                return 5;
            case LEFT:
                return 6;
            case FORWARD_LEFT:
                return 7;
        }
        return 0;
    }
}
