package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Coordinates;
import ax.ha.tdd.chess.engine.Player;

public class Pawn extends ChessPiece {

    public Pawn(PieceType pieceType, Player player, Coordinates location) {
        super(pieceType, player, location);
    }

    @Override
    public String getSymbol() {
        return pieceType.getSymbol();
    }

    @Override
    public boolean canMove(Chessboard chessboard, Coordinates destination) {
        if(this.location.getX() == destination.getX()){
            if (checkNumOfSteps(this.location.getY() , destination.getY())){
                if(chessboard.isOccupied(destination.getX(),destination.getY())){
                    return false;
                }else{
                    return true;
                }
            }
            else{
                return false;
            }
        }else{
            if(checkDiagonal(destination)){
                if (chessboard.isOccupied(destination.getX(),destination.getY())){
                    if(checkColorDest(chessboard,destination)){
                        if(checkKing(chessboard,destination)){
                            return true;
                        }
                        return false;
                    }else{
                        return false;
                    }
                }
                else{
                    return false;
                }
            }else{
                return false;
            }
        }

    }

    private boolean checkNumOfSteps(int yStart, int yDest){
        int diff = yStart - yDest;
        if(this.player.getSymbol().equals("W")){
            if (diff == 1){
                return true;
            }else if(diff == 2 && yStart == 6){
                return true;
            }else{
                return false;
            }
        }else{
            if(diff == -1){
                return true;
            }else if(diff == -2 && yStart == 1){
                return true;
            }else {
                return false;
            }
        }
    }

    private boolean checkDiagonal(Coordinates destination){
        if(this.player.getSymbol().equals("W")){
            if(destination.getX() == this.location.getX()+1 || destination.getX() == this.location.getX()-1 && (destination.getY() == this.location.getY()-1)){
                return true;
            }else{
                return false;
            }
        }else{
            if(destination.getX() == this.location.getX()+1 || destination.getX() == this.location.getX()-1 && (destination.getY() == this.location.getY()+1)){
                return true;
            }else{
                return false;
            }
        }
    }

    private boolean checkColorDest(Chessboard chessboard, Coordinates destination){
        if(inBounds(destination.getX(),destination.getY()) &&chessboard.isOccupied(destination.getX(),destination.getY())){
            if(chessboard.getPiece(destination).getPlayer() == player){
                return false;
            }else{
                return true;
            }
        }else{
            return true;
        }
    }

    private boolean checkKing(Chessboard chessboard, Coordinates destination){
        if (chessboard.isOccupied(destination.getX(),destination.getY()) && chessboard.getPiece(destination).getPieceType().equals(PieceType.KING)){
            return false;
        }
        return true;
    }

    private boolean inBounds(int i, int j) {
        return i >= 0 && i < 8 && j >= 0 && j < 8;
    }
}
