package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.engine.pieces.Pawn;
import ax.ha.tdd.chess.engine.pieces.PieceType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PawnTest {

    @Test
    public void pawnMoveOnceWhite(){
        final Chessboard board = new Chessboard();
        board.addPiece(new Pawn(PieceType.PAWN,Player.WHITE,new Coordinates("a2")));
        board.movePiece("a2-a3",Player.WHITE);
        Assertions.assertEquals("P", board.getPiece(new Coordinates("a3")).getSymbol());
    }

    @Test
    public void pawnMoveTwiceWhite(){
        final Chessboard board = new Chessboard();
        board.addPiece(new Pawn(PieceType.PAWN,Player.WHITE,new Coordinates("a2")));
        board.movePiece("a2-a4",Player.WHITE);
        Assertions.assertEquals("P", board.getPiece(new Coordinates("a4")).getSymbol());
    }

    @Test
    public void pawnMoveSidewaysWhite(){
        final Chessboard board = new Chessboard();
        board.addPiece(new Pawn(PieceType.PAWN,Player.WHITE,new Coordinates("a2")));
        board.movePiece("a2-b2",Player.WHITE);
        Assertions.assertEquals("P", board.getPiece(new Coordinates("a2")).getSymbol());
    }

    @Test
    public void pawnAttackForwardWhite(){
        final Chessboard board = new Chessboard();
        board.addPiece(new Pawn(PieceType.PAWN,Player.WHITE,new Coordinates("a2")));
        board.addPiece(new Pawn(PieceType.PAWN,Player.BLACK,new Coordinates("a3")));
        board.movePiece("a2-a3",Player.WHITE);
        Assertions.assertEquals("P", board.getPiece(new Coordinates("a2")).getSymbol());
    }

    @Test
    public void pawnAttackDiagonallyWhite(){
        final Chessboard board = new Chessboard();
        board.addPiece(new Pawn(PieceType.PAWN,Player.WHITE,new Coordinates("a2")));
        board.addPiece(new Pawn(PieceType.PAWN,Player.BLACK,new Coordinates("b3")));
        board.movePiece("a2-b3",Player.WHITE);
        Assertions.assertEquals("W", board.getPiece(new Coordinates("b3")).getPlayer().getSymbol());
    }

    @Test
    public void pawnMoveOnceBlack(){
        final Chessboard board = new Chessboard();
        board.addPiece(new Pawn(PieceType.PAWN,Player.BLACK,new Coordinates("a7")));
        board.movePiece("a7-a6",Player.BLACK);
        Assertions.assertEquals("P", board.getPiece(new Coordinates("a6")).getSymbol());
    }

    @Test
    public void pawnMoveTwiceBlack(){
        final Chessboard board = new Chessboard();
        board.addPiece(new Pawn(PieceType.PAWN,Player.BLACK,new Coordinates("a7")));
        board.movePiece("a7-a5",Player.BLACK);
        Assertions.assertEquals("P", board.getPiece(new Coordinates("a5")).getSymbol());
    }

    @Test
    public void pawnMoveSidewaysBlack(){
        final Chessboard board = new Chessboard();
        board.addPiece(new Pawn(PieceType.PAWN,Player.BLACK,new Coordinates("a7")));
        board.movePiece("a7-b7",Player.BLACK);
        Assertions.assertEquals("P", board.getPiece(new Coordinates("a7")).getSymbol());
    }

    @Test
    public void pawnAttackForwardBlack(){
        final Chessboard board = new Chessboard();
        board.addPiece(new Pawn(PieceType.PAWN,Player.BLACK,new Coordinates("a7")));
        board.addPiece(new Pawn(PieceType.PAWN,Player.WHITE,new Coordinates("a6")));
        board.movePiece("a7-a6",Player.BLACK);
        Assertions.assertEquals("P", board.getPiece(new Coordinates("a7")).getSymbol());
    }

    @Test
    public void pawnAttackDiagonallyBlack(){
        final Chessboard board = new Chessboard();
        board.addPiece(new Pawn(PieceType.PAWN,Player.BLACK,new Coordinates("a7")));
        board.addPiece(new Pawn(PieceType.PAWN,Player.WHITE,new Coordinates("b6")));
        board.movePiece("a7-b6",Player.BLACK);
        Assertions.assertEquals("B", board.getPiece(new Coordinates("b6")).getPlayer().getSymbol());
    }
}
