package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Coordinates;
import ax.ha.tdd.chess.engine.Player;

public class Rook extends ChessPiece{

    boolean hasMoved = false;

    public Rook(PieceType pieceType, Player player, Coordinates location) {
        super(pieceType, player, location);
    }

    @Override
    public String getSymbol() {
        return pieceType.getSymbol();
    }

    @Override
    public boolean canMove(Chessboard chessboard, Coordinates destination) {
        if((destination.getX() == location.getX() && destination.getY() != location.getY()) || (destination.getX() != location.getX() && destination.getY() == location.getY())){
            if(checkMove(destination, chessboard)){
                if(checkColorDest(chessboard,destination)){
                    if(checkKing(chessboard,destination)){
                        hasMoved = true;
                        return true;
                    }
                    return false;
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    private boolean checkMove(Coordinates dest, Chessboard board){
        int numOfSteps = 0;

        int directionX = Integer.compare(0, location.getX() - dest.getX());
        int directionY =  Integer.compare(0, location.getY() - dest.getY());

        if (directionX != 0 && directionY == 0){
            numOfSteps = Math.abs(location.getX() - dest.getX());
        } else if (directionX == 0 && directionY != 0) {
            numOfSteps = Math.abs(location.getY() - dest.getY());
        }

        //kolla pjäsens väg om det finns nått där
        for (int i = 1; i < numOfSteps; i++) {
            if(directionX != 0 && inBounds(location.getX() + i * directionX, location.getY()) && board.isOccupied(location.getX() + i * directionX, location.getY())){
                return false;
            }
            if (directionY != 0 && inBounds(location.getX(), location.getY() + i * directionY) && board.isOccupied(location.getX(), location.getY() + i * directionY)){
                return false;
            }
        }
        return true;
    }

    private boolean checkColorDest(Chessboard chessboard, Coordinates destination){
        if(chessboard.isOccupied(destination.getX(),destination.getY())){
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

    public boolean isHasMoved() {
        return hasMoved;
    }

    public void setHasMoved(boolean hasMoved) {
        this.hasMoved = hasMoved;
    }

    private boolean inBounds(int i, int j) {
        return i >= 0 && i < 8 && j >= 0 && j < 8;
    }
}
