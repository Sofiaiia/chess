package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.engine.pieces.ChessPiece;
import ax.ha.tdd.chess.engine.pieces.King;
import ax.ha.tdd.chess.engine.pieces.PieceType;

public class WinningChecker {

    public static WinningState checkState(Chessboard board, Player player){
        Coordinates destKing = getKingPosition(board,player);
        if(statusCheck(board,destKing,player)){
                if(statusCheckMate(board,destKing,player)){
                    return WinningState.CHECKMATE;
                }else{
                    return WinningState.CHECK;
                }
        }else{
            return WinningState.PLAYING;
        }
    }
    //CHECK = koordinaterna ska va på spelplanen och canMove ska va FALSKT
    private static boolean statusCheck(Chessboard board, Coordinates kingPos, Player player){
        ChessPiece king = board.getPiece(new Coordinates(kingPos.getX(),kingPos.getY()));
        if(inBounds(kingPos.getX(),kingPos.getY()) && !king.canMove(board,kingPos)){
            return true;
        }else{
            return false;
        }
    }

    //CHECKMATE = canMove på kungens position FALSKT + ALLA rutor runt kungen ska canMove va FALSKT
    private static boolean statusCheckMate(Chessboard board, Coordinates kingPos,Player player){
        //kolla om alla rutor runt kungen är hotad.
        int[] xDir = {-1, 0, 1, -1, 1, -1, 0, 1};
        int[] yDir = {-1, -1, -1, 0, 0, 1, 1, 1};

        for(int i = 0; i < 8;i++){
            if(inBounds(kingPos.getX() + xDir[i],kingPos.getY()+yDir[i])){
                if(new King(PieceType.KING,player,new Coordinates(kingPos.getX() + xDir[i],kingPos.getY()+yDir[i])).canMove(board,new Coordinates(kingPos.getX() + xDir[i],kingPos.getY()+yDir[i]))){
                    return false;
                }
            }
        }
        return true;
    }

    private static Coordinates getKingPosition(Chessboard board, Player player){
        Coordinates king = null;
        for(int i = 0; i <= 7 ; i++){
            for(int j= 0; j <= 7; j++){
                if(board.isOccupied(i,j)){
                    ChessPiece piece = board.getPiece(new Coordinates(i,j));
                    if(piece.getPieceType().equals(PieceType.KING) && piece.getPlayer().equals(player)){
                        king = piece.getLocation();
                    }
                }
            }
        }
        return king;
    }

    private static boolean inBounds(int i, int j) {
        return i >= 0 && i < 8 && j >= 0 && j < 8;
    }
}
