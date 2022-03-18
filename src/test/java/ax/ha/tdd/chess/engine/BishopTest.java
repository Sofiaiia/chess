package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.engine.pieces.Bishop;
import ax.ha.tdd.chess.engine.pieces.King;
import ax.ha.tdd.chess.engine.pieces.PieceType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BishopTest {

    @Test
    public void diagonallyForwardRight(){
        final Chessboard board = new Chessboard();
        board.addPiece(new Bishop(PieceType.BISHOP,Player.WHITE,new Coordinates("e4")));
        board.movePiece("e4-g6",Player.WHITE);
        Assertions.assertEquals("B", board.getPiece(new Coordinates("g6")).getSymbol());
    }

    @Test
    public void diagonallyForwardLeft(){
        final Chessboard board = new Chessboard();
        board.addPiece(new Bishop(PieceType.BISHOP,Player.WHITE,new Coordinates("e4")));
        board.movePiece("e4-b7",Player.WHITE);
        Assertions.assertEquals("B", board.getPiece(new Coordinates("b7")).getSymbol());
    }

    @Test
    public void diagonallyBackRight(){
        final Chessboard board = new Chessboard();
        board.addPiece(new Bishop(PieceType.BISHOP,Player.WHITE,new Coordinates("e4")));
        board.movePiece("e4-f3",Player.WHITE);
        Assertions.assertEquals("B", board.getPiece(new Coordinates("f3")).getSymbol());
    }

    @Test
    public void diagonallyBackLeft(){
        final Chessboard board = new Chessboard();
        board.addPiece(new Bishop(PieceType.BISHOP,Player.WHITE,new Coordinates("e4")));
        board.movePiece("e4-c2",Player.WHITE);
        Assertions.assertEquals("B", board.getPiece(new Coordinates("c2")).getSymbol());
    }

    @Test
    public void diagonallyInvalidMove(){
        final Chessboard board = new Chessboard();
        board.addPiece(new Bishop(PieceType.BISHOP,Player.WHITE,new Coordinates("e4")));
        board.addPiece(new Bishop(PieceType.BISHOP,Player.BLACK,new Coordinates("d3")));
        board.movePiece("e4-c2",Player.WHITE);
        Assertions.assertEquals("B", board.getPiece(new Coordinates("e4")).getSymbol());
    }

    @Test
    public void attackKing(){
        final Chessboard board = new Chessboard();
        board.addPiece(new Bishop(PieceType.BISHOP,Player.WHITE,new Coordinates("e4")));
        board.addPiece(new King(PieceType.KING,Player.BLACK,new Coordinates("c2")));
        board.movePiece("e4-c2",Player.WHITE);
        Assertions.assertEquals("B", board.getPiece(new Coordinates("e4")).getSymbol());
    }

}
