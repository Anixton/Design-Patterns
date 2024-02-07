public class GameMoves {
    public static void main(String[] args) throws Exception {
        Game game = new Game();
        game.executeCommand(new MoveUnitCommand(game.getUnit(), new Position(1, 1)));
        game.executeCommand(new MoveUnitCommand(game.getUnit(), new Position(2, 2)));
        game.executeCommand(new MoveUnitCommand(game.getUnit(), new Position(3, 3)));
        game.displayPosition();

        // deleted the undoLastCommand and redoLastCommand methods
        // because MoveUnitCommand has undo and redo methods
        // game.undoLastCommand();
        // game.displayPosition();
        // game.redoLastCommand();

        Game game2 = new Game();
        game2.loadGame(game.getPositionHistory(), game.getPositionFuture(), game.getPosition());
        game2.displayReplay();



    }
}
