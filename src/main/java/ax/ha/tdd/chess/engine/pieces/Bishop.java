package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Coordinates;
import ax.ha.tdd.chess.engine.Player;

public class Bishop extends ChessPiece{
    public Bishop(PieceType pieceType, Player player, Coordinates location) {
        super(pieceType, player, location);
    }

    @Override
    public String getSymbol() {
        return pieceType.getSymbol();
    }

    @Override
    public boolean canMove(Chessboard chessboard, Coordinates destination) {
        if(Math.abs(location.getX() - destination.getX()) == Math.abs(location.getY() - destination.getY())){
            if (checkMove(chessboard, destination)){
                return true;
            } else{
                return false;
            }
        }else {
            return false;
        }
    }

    public boolean checkMove(Chessboard board, Coordinates destination){
        int steps = Math.abs(location.getX() - destination.getX());

        int directionX = Integer.compare(0, location.getX() - destination.getX());
        int directionY =  Integer.compare(0, location.getY() - destination.getY());

        for (int i = 1; i < steps; i++) {
            if(board.isOccupied(location.getX() + i * directionX, location.getY() + i * directionY)){
                return false;
            }
        }
        return true;
        }
}
