package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.engine.pieces.ChessPiece;
import ax.ha.tdd.chess.engine.pieces.King;
import ax.ha.tdd.chess.engine.pieces.PieceType;
import ax.ha.tdd.chess.engine.pieces.Rook;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RookTest {

    @Test
    public void rookMoveXRightWhite(){
        final Chessboard board = new Chessboard();
        board.addPiece(new Rook(PieceType.ROOK,Player.WHITE,new Coordinates("a1")));
        board.movePiece("a1-c1",Player.WHITE);
        Assertions.assertEquals("R", board.getPiece(new Coordinates("c1")).getSymbol());
    }

    @Test
    public void rookMoveXLeftWhite(){
        final Chessboard board = new Chessboard();
        board.addPiece(new Rook(PieceType.ROOK,Player.WHITE,new Coordinates("h1")));
        board.movePiece("h1-f1",Player.WHITE);
        Assertions.assertEquals("R", board.getPiece(new Coordinates("f1")).getSymbol());
    }

    @Test
    public void rookMoveYForwardWhite(){
        final Chessboard board = new Chessboard();
        board.addPiece(new Rook(PieceType.ROOK,Player.WHITE,new Coordinates("h1")));
        board.movePiece("h1-h3",Player.WHITE);
        Assertions.assertEquals("R", board.getPiece(new Coordinates("h3")).getSymbol());
    }

    @Test
    public void rookMoveYBackWhite(){
        final Chessboard board = new Chessboard();
        board.addPiece(new Rook(PieceType.ROOK,Player.WHITE,new Coordinates("h3")));
        board.movePiece("h3-h1",Player.WHITE);
        Assertions.assertEquals("R", board.getPiece(new Coordinates("h1")).getSymbol());
    }

    @Test
    public void rookInvalidMoveWhite(){
        final Chessboard board = new Chessboard();
        ChessPiece rook = new Rook(PieceType.ROOK,Player.WHITE,new Coordinates("h1"));
        board.addPiece(rook);
        board.addPiece(new Rook(PieceType.ROOK,Player.BLACK,new Coordinates("h3")));
        board.movePiece("h1-h4",Player.WHITE);
        Assertions.assertEquals(rook, board.getPiece(new Coordinates("h1")));
    }

    @Test
    public void rookAttackWhite(){
        final Chessboard board = new Chessboard();
        ChessPiece rook = new Rook(PieceType.ROOK,Player.WHITE,new Coordinates("h1"));
        board.addPiece(rook);
        board.addPiece(new Rook(PieceType.ROOK,Player.BLACK,new Coordinates("h3")));
        board.movePiece("h1-h3",Player.WHITE);
        Assertions.assertEquals(rook, board.getPiece(new Coordinates("h3")));
    }

    @Test
    public void rookMoveXRightBlack(){
        final Chessboard board = new Chessboard();
        board.addPiece(new Rook(PieceType.ROOK,Player.BLACK,new Coordinates("a8")));
        board.movePiece("a8-c8",Player.BLACK);
        Assertions.assertEquals("R", board.getPiece(new Coordinates("c8")).getSymbol());
    }

    @Test
    public void rookMoveXLeftBlack(){
        final Chessboard board = new Chessboard();
        board.addPiece(new Rook(PieceType.ROOK,Player.BLACK,new Coordinates("h8")));
        board.movePiece("h8-f8",Player.BLACK);
        Assertions.assertEquals("R", board.getPiece(new Coordinates("f8")).getSymbol());
    }

    @Test
    public void rookMoveYForwardBlack(){
        final Chessboard board = new Chessboard();
        board.addPiece(new Rook(PieceType.ROOK,Player.BLACK,new Coordinates("h8")));
        board.movePiece("h8-h5",Player.BLACK);
        Assertions.assertEquals("R", board.getPiece(new Coordinates("h5")).getSymbol());
    }

    @Test
    public void rookMoveYBackBlack(){
        final Chessboard board = new Chessboard();
        board.addPiece(new Rook(PieceType.ROOK,Player.WHITE,new Coordinates("h5")));
        board.movePiece("h5-h8",Player.WHITE);
        Assertions.assertEquals("R", board.getPiece(new Coordinates("h8")).getSymbol());
    }

    @Test
    public void rookInvalidMoveBlack(){
        final Chessboard board = new Chessboard();
        ChessPiece rook = new Rook(PieceType.ROOK,Player.BLACK,new Coordinates("h8"));
        board.addPiece(rook);
        board.addPiece(new Rook(PieceType.ROOK,Player.WHITE,new Coordinates("h6")));
        board.movePiece("h8-h5",Player.BLACK);
        Assertions.assertEquals(rook, board.getPiece(new Coordinates("h8")));
    }

    @Test
    public void rookAttackBlack(){
        final Chessboard board = new Chessboard();
        ChessPiece rook = new Rook(PieceType.ROOK,Player.BLACK,new Coordinates("h8"));
        board.addPiece(rook);
        board.addPiece(new Rook(PieceType.ROOK,Player.WHITE,new Coordinates("h6")));
        board.movePiece("h8-h6",Player.BLACK);
        Assertions.assertEquals(rook, board.getPiece(new Coordinates("h6")));
    }
    @Test
    public void rookAttackKing(){
        final Chessboard board = new Chessboard();
        ChessPiece rook = new Rook(PieceType.ROOK,Player.BLACK,new Coordinates("h8"));
        board.addPiece(rook);
        board.addPiece(new King(PieceType.KING,Player.WHITE,new Coordinates("h6")));
        board.movePiece("h8-h6",Player.BLACK);
        Assertions.assertEquals(rook, board.getPiece(new Coordinates("h8")));
    }
}
