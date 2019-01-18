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
}
