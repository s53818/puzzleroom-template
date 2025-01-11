package at.edu.c02.puzzleroom.fields;

import at.edu.c02.puzzleroom.Direction;
import at.edu.c02.puzzleroom.GameBoard;

/**
 * A wall field. The player can never move onto this field.
 */
public class FieldOneWay extends BaseField {

    private Direction allowedDirection;

    public FieldOneWay(GameBoard gameBoard, char name, int row, int col) {
        super(gameBoard, name, row, col);
        switch (name) {
            case '<' -> allowedDirection = Direction.Left;
            case '>' -> allowedDirection = Direction.Right;
            case '^' -> allowedDirection = Direction.Up;
            case 'v' -> allowedDirection = Direction.Down;
        }
    }

    public void initialize() {
    }

    public boolean enterField(Direction direction) {
        gameBoard.getPlayer().walkStep();
        setPlayerPositionToField();
        return true;
    }

    public boolean leaveField(Direction direction) {
        return direction == allowedDirection;
    }
}
