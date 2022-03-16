package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.engine.pieces.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QueenTest {

    @Test
    public void rookMoveXRightWhite(){
        final Chessboard board = new Chessboard();
        board.addPiece(new Queen(PieceType.QUEEN,Player.WHITE,new Coordinates("a1")));
        board.movePiece("a1-c1",Player.WHITE);
        Assertions.assertEquals("Q", board.getPiece(new Coordinates("c1")).getSymbol());
    }

    @Test
    public void rookMoveXLeftWhite(){
        final Chessboard board = new Chessboard();
        board.addPiece(new Queen(PieceType.QUEEN,Player.WHITE,new Coordinates("h1")));
        board.movePiece("h1-f1",Player.WHITE);
        Assertions.assertEquals("Q", board.getPiece(new Coordinates("f1")).getSymbol());
    }

    @Test
    public void rookMoveYForwardWhite(){
        final Chessboard board = new Chessboard();
        board.addPiece(new Rook(PieceType.QUEEN,Player.WHITE,new Coordinates("h1")));
        board.movePiece("h1-h3",Player.WHITE);
        Assertions.assertEquals("Q", board.getPiece(new Coordinates("h3")).getSymbol());
    }

    @Test
    public void rookMoveYBackWhite(){
        final Chessboard board = new Chessboard();
        board.addPiece(new Rook(PieceType.QUEEN,Player.WHITE,new Coordinates("h3")));
        board.movePiece("h3-h1",Player.WHITE);
        Assertions.assertEquals("Q", board.getPiece(new Coordinates("h1")).getSymbol());
    }

    @Test
    public void rookInvalidMoveWhite(){
        final Chessboard board = new Chessboard();
        ChessPiece queen = new Queen(PieceType.QUEEN,Player.WHITE,new Coordinates("h1"));
        board.addPiece(queen);
        board.addPiece(new Rook(PieceType.ROOK,Player.BLACK,new Coordinates("h3")));
        board.movePiece("h1-h4",Player.WHITE);
        Assertions.assertEquals(queen, board.getPiece(new Coordinates("h1")));
    }

    @Test
    public void rookAttackWhite(){
        final Chessboard board = new Chessboard();
        ChessPiece queen = new Queen(PieceType.QUEEN,Player.WHITE,new Coordinates("h1"));
        board.addPiece(queen);
        board.addPiece(new Rook(PieceType.ROOK,Player.BLACK,new Coordinates("h3")));
        board.movePiece("h1-h3",Player.WHITE);
        Assertions.assertEquals(queen, board.getPiece(new Coordinates("h3")));
    }

    @Test
    public void rookMoveXRightBlack(){
        final Chessboard board = new Chessboard();
        board.addPiece(new Rook(PieceType.QUEEN,Player.BLACK,new Coordinates("a8")));
        board.movePiece("a8-c8",Player.BLACK);
        Assertions.assertEquals("Q", board.getPiece(new Coordinates("c8")).getSymbol());
    }

    @Test
    public void rookMoveXLeftBlack(){
        final Chessboard board = new Chessboard();
        board.addPiece(new Rook(PieceType.QUEEN,Player.BLACK,new Coordinates("h8")));
        board.movePiece("h8-f8",Player.BLACK);
        Assertions.assertEquals("Q", board.getPiece(new Coordinates("f8")).getSymbol());
    }

    @Test
    public void rookMoveYForwardBlack(){
        final Chessboard board = new Chessboard();
        board.addPiece(new Rook(PieceType.QUEEN,Player.BLACK,new Coordinates("h8")));
        board.movePiece("h8-h5",Player.BLACK);
        Assertions.assertEquals("Q", board.getPiece(new Coordinates("h5")).getSymbol());
    }

    @Test
    public void rookMoveYBackBlack(){
        final Chessboard board = new Chessboard();
        board.addPiece(new Rook(PieceType.QUEEN,Player.WHITE,new Coordinates("h5")));
        board.movePiece("h5-h8",Player.WHITE);
        Assertions.assertEquals("Q", board.getPiece(new Coordinates("h8")).getSymbol());
    }

    @Test
    public void rookInvalidMoveBlack(){
        final Chessboard board = new Chessboard();
        ChessPiece queen = new Queen(PieceType.QUEEN,Player.BLACK,new Coordinates("h8"));
        board.addPiece(queen);
        board.addPiece(new Rook(PieceType.ROOK,Player.WHITE,new Coordinates("h6")));
        board.movePiece("h8-h5",Player.BLACK);
        Assertions.assertEquals(queen, board.getPiece(new Coordinates("h8")));
    }

    @Test
    public void rookAttackBlack(){
        final Chessboard board = new Chessboard();
        ChessPiece queen = new Queen(PieceType.QUEEN,Player.BLACK,new Coordinates("h8"));
        board.addPiece(queen);
        board.addPiece(new Rook(PieceType.ROOK,Player.WHITE,new Coordinates("h6")));
        board.movePiece("h8-h6",Player.BLACK);
        Assertions.assertEquals(queen, board.getPiece(new Coordinates("h6")));
    }
    //----------------------

    @Test
    public void diagonallyForwardRight(){
        final Chessboard board = new Chessboard();
        board.addPiece(new Queen(PieceType.QUEEN,Player.WHITE,new Coordinates("e4")));
        board.movePiece("e4-g6",Player.WHITE);
        Assertions.assertEquals("Q", board.getPiece(new Coordinates("g6")).getSymbol());
    }

    @Test
    public void diagonallyForwardLeft(){
        final Chessboard board = new Chessboard();
        board.addPiece(new Queen(PieceType.QUEEN,Player.WHITE,new Coordinates("e4")));
        board.movePiece("e4-b7",Player.WHITE);
        Assertions.assertEquals("Q", board.getPiece(new Coordinates("b7")).getSymbol());
    }

    @Test
    public void diagonallyBackRight(){
        final Chessboard board = new Chessboard();
        board.addPiece(new Queen(PieceType.QUEEN,Player.WHITE,new Coordinates("e4")));
        board.movePiece("e4-f3",Player.WHITE);
        Assertions.assertEquals("Q", board.getPiece(new Coordinates("f3")).getSymbol());
    }

    @Test
    public void diagonallyBackLeft(){
        final Chessboard board = new Chessboard();
        board.addPiece(new Queen(PieceType.QUEEN,Player.WHITE,new Coordinates("e4")));
        board.movePiece("e4-c2",Player.WHITE);
        Assertions.assertEquals("Q", board.getPiece(new Coordinates("c2")).getSymbol());
    }


    @Test
    public void diagonallyInvalidMove(){
        final Chessboard board = new Chessboard();
        board.addPiece(new Queen(PieceType.QUEEN,Player.WHITE,new Coordinates("e4")));
        board.addPiece(new Bishop(PieceType.BISHOP,Player.BLACK,new Coordinates("d3")));
        board.movePiece("e4-c2",Player.WHITE);
        Assertions.assertEquals("Q", board.getPiece(new Coordinates("e4")).getSymbol());
    }
}
