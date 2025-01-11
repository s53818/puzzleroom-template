package at.edu.c02.puzzleroom;

import at.edu.c02.puzzleroom.commands.CommandLoad;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FieldTeleporterTest
{
    @Test
    public void moveIceTest() throws Exception {
        GameBoard gameBoard = new GameBoardImpl();
        // Finish is reached when moving twice to the right
        new CommandLoad(new String[]{"src/test/resources/teleporter.maze"}).execute(gameBoard);
        Player player = gameBoard.getPlayer();
        player.moveRight();
        // Player should now be at 3 step
        assertEquals(3, player.getStepCount());
    }

    @Test
    public void moveIce2Test() throws Exception {
        GameBoard gameBoard = new GameBoardImpl();
        // Finish is reached when moving twice to the right
        new CommandLoad(new String[]{"src/test/resources/teleporter2.maze"}).execute(gameBoard);
        Player player = gameBoard.getPlayer();
        player.moveDown();
        player.moveRight();
        player.moveDown();
        // Player should now be at 3 step
        assertTrue(gameBoard.isFinished());
    }
}
