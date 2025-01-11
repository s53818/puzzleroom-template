package at.edu.c02.puzzleroom.fields;

import at.edu.c02.puzzleroom.Direction;
import at.edu.c02.puzzleroom.GameBoard;
import at.edu.c02.puzzleroom.exceptions.PuzzleRoomException;

public class FieldTeleporter extends BaseField
{
    public FieldTeleporter(GameBoard gameBoard, char name, int row, int col)
    {
        super(gameBoard, name, row, col);
    }

    public void initialize() {
    }

    public boolean enterField(Direction direction) {
        gameBoard.getPlayer().walkStep();
        setPlayerPositionToField();
        Field nextField = switch (direction) {
            case Direction.Up -> gameBoard.getField(row - 1, col);
            case Direction.Down -> gameBoard.getField(row + 1, col);
            case Direction.Left -> gameBoard.getField(row, col - 1);
            case Direction.Right -> gameBoard.getField(row, col + 1);
        };
        nextField.enterField(direction);
        return true;
    }

    public boolean leaveField(Direction direction) {
        return true;
    }
}
