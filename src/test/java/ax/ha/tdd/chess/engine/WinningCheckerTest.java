package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.engine.pieces.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WinningCheckerTest {

    @Test
    public void checkPlayingBlack(){
        Chessboard board = new Chessboard();
        board.addPiece(new King(PieceType.KING,Player.BLACK,new Coordinates("e5")));
        Assertions.assertEquals(WinningState.PLAYING, WinningChecker.checkState(board, Player.BLACK));
    }

    @Test
    public void checkCheckBlack(){
        Chessboard board = new Chessboard();
        board.addPiece(new King(PieceType.KING,Player.BLACK,new Coordinates("e5")));
        board.addPiece(new Rook(PieceType.ROOK,Player.WHITE,new Coordinates("b5")));
        Assertions.assertEquals(WinningState.CHECK, WinningChecker.checkState(board, Player.BLACK));
    }

    @Test
    public void checkCheckMateBlack(){
        Chessboard board = new Chessboard();
        board.addPiece(new King(PieceType.KING,Player.BLACK,new Coordinates("e3")));
        board.addPiece(new Rook(PieceType.ROOK,Player.WHITE,new Coordinates("b2")));
        board.addPiece(new Rook(PieceType.ROOK,Player.WHITE,new Coordinates("h4")));
        board.addPiece(new Rook(PieceType.ROOK,Player.WHITE,new Coordinates("b3")));
        board.addPiece(new Knight(PieceType.KNIGHT,Player.WHITE,new Coordinates("g5")));
        board.addPiece(new Bishop(PieceType.BISHOP,Player.WHITE,new Coordinates("b5")));
        Assertions.assertEquals(WinningState.CHECKMATE, WinningChecker.checkState(board, Player.BLACK));
    }
}
