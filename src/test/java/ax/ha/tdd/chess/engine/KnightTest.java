package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.engine.pieces.ChessPiece;
import ax.ha.tdd.chess.engine.pieces.Knight;
import ax.ha.tdd.chess.engine.pieces.PieceType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class KnightTest {

    @Test
    public void twoForwardLeft(){
        final Chessboard board = new Chessboard();
        board.addPiece(new Knight(PieceType.KNIGHT,Player.WHITE,new Coordinates("e4")));
        board.movePiece("e4-d6",Player.WHITE);
        Assertions.assertEquals("K", board.getPiece(new Coordinates("d6")).getSymbol());
    }

    @Test
    public void twoForwardRight(){
        final Chessboard board = new Chessboard();
        board.addPiece(new Knight(PieceType.KNIGHT,Player.WHITE,new Coordinates("e4")));
        board.movePiece("e4-f6",Player.WHITE);
        Assertions.assertEquals("K", board.getPiece(new Coordinates("f6")).getSymbol());
    }

    @Test
    public void twoBackRight(){
        final Chessboard board = new Chessboard();
        board.addPiece(new Knight(PieceType.KNIGHT,Player.WHITE,new Coordinates("e4")));
        board.movePiece("e4-f2",Player.WHITE);
        Assertions.assertEquals("K", board.getPiece(new Coordinates("f2")).getSymbol());
    }

    @Test
    public void twoBackLeft(){
        final Chessboard board = new Chessboard();
        board.addPiece(new Knight(PieceType.KNIGHT,Player.WHITE,new Coordinates("e4")));
        board.movePiece("e4-d2",Player.WHITE);
        Assertions.assertEquals("K", board.getPiece(new Coordinates("d2")).getSymbol());
    }

    @Test
    public void twoLeftUp(){
        final Chessboard board = new Chessboard();
        board.addPiece(new Knight(PieceType.KNIGHT,Player.WHITE,new Coordinates("e4")));
        board.movePiece("e4-c5",Player.WHITE);
        Assertions.assertEquals("K", board.getPiece(new Coordinates("c5")).getSymbol());
    }

    @Test
    public void twoLeftDown(){
        final Chessboard board = new Chessboard();
        board.addPiece(new Knight(PieceType.KNIGHT,Player.WHITE,new Coordinates("e4")));
        board.movePiece("e4-c3",Player.WHITE);
        Assertions.assertEquals("K", board.getPiece(new Coordinates("c3")).getSymbol());
    }

    @Test
    public void twoRightUp(){
        final Chessboard board = new Chessboard();
        board.addPiece(new Knight(PieceType.KNIGHT,Player.WHITE,new Coordinates("e4")));
        board.movePiece("e4-g5",Player.WHITE);
        Assertions.assertEquals("K", board.getPiece(new Coordinates("g5")).getSymbol());
    }

    @Test
    public void twoRightDown(){
        final Chessboard board = new Chessboard();
        board.addPiece(new Knight(PieceType.KNIGHT,Player.WHITE,new Coordinates("e4")));
        board.movePiece("e4-g3",Player.WHITE);
        Assertions.assertEquals("K", board.getPiece(new Coordinates("g3")).getSymbol());
    }

    @Test
    public void knightAttack(){
        final Chessboard board = new Chessboard();
        ChessPiece knight = new Knight(PieceType.KNIGHT,Player.WHITE,new Coordinates("e4"));
        board.addPiece(knight);
        board.addPiece(new Knight(PieceType.KNIGHT,Player.BLACK,new Coordinates("g3")));
        board.movePiece("e4-g3",Player.WHITE);
        Assertions.assertEquals(knight, board.getPiece(new Coordinates("g3")));
    }
}
