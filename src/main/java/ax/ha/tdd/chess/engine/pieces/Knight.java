package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Coordinates;
import ax.ha.tdd.chess.engine.Player;

public class Knight extends ChessPiece{
    public Knight(PieceType pieceType, Player player, Coordinates location) {
        super(pieceType, player, location);
    }

    @Override
    public String getSymbol() {
        return pieceType.getSymbol();
    }

    @Override
    public boolean canMove(Chessboard chessboard, Coordinates destination) {
        int [] row = new int[]{2, 1, -1, -2, -2, -1, 1, 2, 2};
        int[] col = new int[]{1, 2, 2, 1, -1, -2, -2, -1, 1};

        for(int i = 0; i <= 7; i++){
            Coordinates coordinates = new Coordinates(location.getX() + row[i], location.getY() + col[i]);
            if(destination.equals(coordinates)){
                if(inBounds(destination.getX(),destination.getY()) && chessboard.isOccupied(destination.getX(),destination.getY()) && chessboard.getPiece(destination).getPieceType().equals(PieceType.KING)){
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    private boolean inBounds(int i, int j) {
        return i >= 0 && i < 8 && j >= 0 && j < 8;
    }
}
