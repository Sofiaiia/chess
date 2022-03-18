package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.engine.pieces.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class KingTest {

    @Test
    public void forward(){
        final Chessboard board = new Chessboard();
        board.addPiece(new King(PieceType.KING,Player.WHITE,new Coordinates("e4")));
        board.movePiece("e4-e5",Player.WHITE);
        Assertions.assertEquals("K", board.getPiece(new Coordinates("e5")).getSymbol());
    }

    @Test
    public void back(){
        final Chessboard board = new Chessboard();
        board.addPiece(new King(PieceType.KING,Player.WHITE,new Coordinates("e4")));
        board.movePiece("e4-e3",Player.WHITE);
        Assertions.assertEquals("K", board.getPiece(new Coordinates("e3")).getSymbol());
    }

    @Test
    public void left(){
        final Chessboard board = new Chessboard();
        board.addPiece(new King(PieceType.KING,Player.WHITE,new Coordinates("e4")));
        board.movePiece("e4-d4",Player.WHITE);
        Assertions.assertEquals("K", board.getPiece(new Coordinates("d4")).getSymbol());
    }

    @Test
    public void right(){
        final Chessboard board = new Chessboard();
        board.addPiece(new King(PieceType.KING,Player.WHITE,new Coordinates("e4")));
        board.movePiece("e4-f4",Player.WHITE);
        Assertions.assertEquals("K", board.getPiece(new Coordinates("f4")).getSymbol());
    }

    @Test
    public void diagonallyForwardRight(){
        final Chessboard board = new Chessboard();
        board.addPiece(new King(PieceType.KING,Player.WHITE,new Coordinates("e4")));
        board.movePiece("e4-f5",Player.WHITE);
        Assertions.assertEquals("K", board.getPiece(new Coordinates("f5")).getSymbol());
    }

    @Test
    public void diagonallyForwardLeft(){
        final Chessboard board = new Chessboard();
        board.addPiece(new King(PieceType.KING,Player.WHITE,new Coordinates("e4")));
        board.movePiece("e4-d5",Player.WHITE);
        Assertions.assertEquals("K", board.getPiece(new Coordinates("d5")).getSymbol());
    }

    @Test
    public void diagonallyBackLeft(){
        final Chessboard board = new Chessboard();
        board.addPiece(new King(PieceType.KING,Player.WHITE,new Coordinates("e4")));
        board.movePiece("e4-d3",Player.WHITE);
        Assertions.assertEquals("K", board.getPiece(new Coordinates("d3")).getSymbol());
    }

    @Test
    public void diagonallyBackRight(){
        final Chessboard board = new Chessboard();
        board.addPiece(new King(PieceType.KING,Player.WHITE,new Coordinates("e4")));
        board.movePiece("e4-f3",Player.WHITE);
        Assertions.assertEquals("K", board.getPiece(new Coordinates("f3")).getSymbol());
    }

    @Test
    public void checkPawn(){
        final Chessboard board = new Chessboard();
        board.addPiece(new King(PieceType.KING,Player.WHITE,new Coordinates("e4")));
        board.addPiece(new Pawn(PieceType.PAWN,Player.BLACK,new Coordinates("c5")));
        board.movePiece("e4-d4",Player.WHITE);
        Assertions.assertEquals("K", board.getPiece(new Coordinates("e4")).getSymbol());
    }

    @Test
    public void checkRook(){
        final Chessboard board = new Chessboard();
        board.addPiece(new King(PieceType.KING,Player.WHITE,new Coordinates("e4")));
        board.addPiece(new Rook(PieceType.ROOK,Player.BLACK,new Coordinates("c5")));
        board.movePiece("e4-e5",Player.WHITE);
        Assertions.assertEquals("K", board.getPiece(new Coordinates("e4")).getSymbol());
    }
    @Test
    public void checkKnight(){
        final Chessboard board = new Chessboard();
        board.addPiece(new King(PieceType.KING,Player.WHITE,new Coordinates("e4")));
        board.addPiece(new Knight(PieceType.KNIGHT,Player.BLACK,new Coordinates("d7")));
        board.movePiece("e4-e5",Player.WHITE);
        Assertions.assertEquals("K", board.getPiece(new Coordinates("e4")).getSymbol());
    }
    @Test
    public void checkBishop(){
        final Chessboard board = new Chessboard();
        board.addPiece(new King(PieceType.KING,Player.WHITE,new Coordinates("e4")));
        board.addPiece(new Bishop(PieceType.BISHOP,Player.BLACK,new Coordinates("h8")));
        board.movePiece("e4-e5",Player.WHITE);
        Assertions.assertEquals("K", board.getPiece(new Coordinates("e4")).getSymbol());
    }
    @Test
    public void checkQueen(){
        final Chessboard board = new Chessboard();
        board.addPiece(new King(PieceType.KING,Player.WHITE,new Coordinates("e4")));
        board.addPiece(new Queen(PieceType.QUEEN,Player.BLACK,new Coordinates("c7")));
        board.movePiece("e4-e5",Player.WHITE);
        Assertions.assertEquals("K", board.getPiece(new Coordinates("e4")).getSymbol());
    }
    @Test
    public void checkWhenWhiteBlocks(){
        final Chessboard board = new Chessboard();
        board.addPiece(new King(PieceType.KING,Player.WHITE,new Coordinates("e4")));
        board.addPiece(new Rook(PieceType.ROOK,Player.BLACK,new Coordinates("b5")));
        board.addPiece(new Bishop(PieceType.BISHOP,Player.WHITE,new Coordinates("c5")));
        board.movePiece("e4-e5",Player.WHITE);
        Assertions.assertEquals("K", board.getPiece(new Coordinates("e5")).getSymbol());
    }

    @Test
    public void checkCastlingHasMoved(){
        final Chessboard board = new Chessboard();
        board.addPiece(new King(PieceType.KING,Player.WHITE,new Coordinates("d1")));
        Rook rook = new Rook(PieceType.ROOK,Player.WHITE,new Coordinates("a2"));
        rook.setHasMoved(true);
        board.addPiece(rook);
        board.movePiece("d1-a2",Player.WHITE);
        Assertions.assertEquals("K", board.getPiece(new Coordinates("d1")).getSymbol());
    }

    @Test
    public void checkCastlingMove(){
        final Chessboard board = new Chessboard();
        board.addPiece(new King(PieceType.KING,Player.WHITE,new Coordinates("d1")));
        Rook rook = new Rook(PieceType.ROOK,Player.WHITE,new Coordinates("a1"));
        board.addPiece(rook);
        board.movePiece("d1-a1",Player.WHITE);
        Assertions.assertEquals("K", board.getPiece(new Coordinates("a1")).getSymbol());
        Assertions.assertEquals("R", board.getPiece(new Coordinates("d1")).getSymbol());
    }

    @Test
    public void checkCastlingRisk(){
        final Chessboard board = new Chessboard();
        board.addPiece(new King(PieceType.KING,Player.WHITE,new Coordinates("d1")));
        board.addPiece(new Pawn(PieceType.PAWN,Player.BLACK,new Coordinates("c2")));
        Rook rook = new Rook(PieceType.ROOK,Player.WHITE,new Coordinates("a1"));
        board.addPiece(rook);
        board.movePiece("d1-a1",Player.WHITE);
        Assertions.assertEquals("K", board.getPiece(new Coordinates("d1")).getSymbol());
        Assertions.assertEquals("R", board.getPiece(new Coordinates("a1")).getSymbol());
    }
}
