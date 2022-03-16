package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Coordinates;
import ax.ha.tdd.chess.engine.Player;

public class Queen extends ChessPiece{
    public Queen(PieceType pieceType, Player player, Coordinates location) {
        super(pieceType, player, location);
    }

    @Override
    public String getSymbol() {
        return pieceType.getSymbol();
    }

    @Override
    public boolean canMove(Chessboard chessboard, Coordinates destination) {
        ChessPiece rook = new Rook(PieceType.ROOK,player,location);
        ChessPiece bishop = new Bishop(PieceType.BISHOP,player,location);

        if(rook.canMove(chessboard, destination) || bishop.canMove(chessboard, destination)){
            return true;
        }else{
            return false;
        }
    }
}
