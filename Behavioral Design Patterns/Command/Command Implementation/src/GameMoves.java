/*
 * This program demonstrates the Command pattern in a game context, providing functionalities such as moving a unit, 
 * undoing and redoing moves, and replaying the game.
 *
 * Key components:
 * - Game: The client class that creates and executes commands. It also manages undo/redo operations and provides 
 *         methods to display the current position and replay the game.
 * - Unit: The receiver class that performs actions such as moving to a new position, moving back to the previous position, 
 *         moving forward to the next position, and replaying the game.
 * - MoveUnitCommand: A concrete command implementing the Command interface. It provides methods to execute, undo, 
 *         and redo the command, and to get the destination and unit.
 * - Position: A utility class representing a position with x and y coordinates.
 * - GameMoves: The main class that orchestrates the game flow, including moving the unit, undoing and redoing moves, 
 *         displaying the current position, and replaying the game.
 */

public class GameMoves {
    public static void main(String[] args) throws Exception {
        Game game = new Game();
        game.executeCommand(new MoveUnitCommand(game.getUnit(), new Position(1, 1)));
        game.executeCommand(new MoveUnitCommand(game.getUnit(), new Position(2, 2)));
        game.executeCommand(new MoveUnitCommand(game.getUnit(), new Position(3, 3)));
        game.displayPosition();

        game.undoLastCommand();
        game.displayPosition();
        game.redoLastCommand();

        Game game2 = new Game();
        game2.loadGame(game.getPositionHistory(), game.getPositionFuture(), game.getPosition());
        game2.displayReplay();
    }
}
