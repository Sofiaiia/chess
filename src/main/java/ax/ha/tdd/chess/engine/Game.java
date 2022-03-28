package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.engine.pieces.ChessPiece;
import ax.ha.tdd.chess.engine.pieces.Pawn;

public class Game {

    Chessboard board = Chessboard.startingBoard();

    boolean isNewGame = true;
    int turn = 0;
    String message = "";

    public Player getPlayerToMove() {
        return turn % 2 == 0 ?Player.WHITE: Player.BLACK;
    }

    public Chessboard getBoard() {
        return board;
    }

    public String getLastMoveResult() {
        if (isNewGame) {
            return "Game hasn't begun";
        }
        return message;
    }

    public void move(String move) {
        try{
            if(WinningChecker.checkState(board,getPlayerToMove()).equals(WinningState.CHECKMATE)){
                message = "CHECKMATE";
            }else {
                if(WinningChecker.checkState(board,getPlayerToMove()).equals(WinningState.CHECK)){
                  message = getPlayerToMove() + " you are in check!";
                }
                isNewGame = false;
                boolean succeeded = board.movePiece(move, getPlayerToMove());
                if (succeeded) {
                    message = getPlayerToMove() + " made a succesful move: " + move;
                    turn++;
                } else {
                    throw new InvalidMovementException("Invalid movement");
                }
           }
        }catch(Exception e){
            message = getPlayerToMove() + " invalid move: " + move + "!!!";
        }
    }
}
