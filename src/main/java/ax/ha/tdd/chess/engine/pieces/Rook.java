package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Coordinates;
import ax.ha.tdd.chess.engine.Player;

public class Rook extends ChessPiece{

    public Rook(PieceType pieceType, Player player, Coordinates location) {
        super(pieceType, player, location);
    }

    @Override
    public String getSymbol() {
        return pieceType.getSymbol();
    }

    @Override
    public boolean canMove(Chessboard chessboard, Coordinates destination) {
        if(checkXY(destination)){
            if(checkOccupiedOnWay(destination, chessboard)){
                if(checkColorDest(chessboard,destination)){
                    return true;
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

    private boolean checkXY(Coordinates destination){
        if((destination.getX() == location.getX() && destination.getY() != location.getY()) || (destination.getX() != location.getX() && destination.getY() == location.getY())){
            return true;
        }else{
            return false;
        }
    }

    private boolean checkOccupiedOnWay(Coordinates destination, Chessboard chessboard){
        int diffX = location.getX() - destination.getX();
        int diffY = location.getY() -destination.getY();
            if(diffY == 0 && diffX != 0){
                if(diffX > 0){
                    for (int i = location.getX()-1; i > destination.getX(); i--){
                        if (chessboard.isOccupied(i,destination.getY())){
                            return false;
                        }
                    }
                    return true;
                }else {
                    for (int i = location.getX()+1; i < destination.getX(); i++){
                        if (chessboard.isOccupied(i,destination.getY())){
                            return false;
                        }
                    }
                    return true;
                }
            }else{
                if(diffY > 0){
                    for (int i = location.getY()-1; i > destination.getY(); i--){
                        if (chessboard.isOccupied(destination.getX(),i)){
                            return false;
                        }
                    }
                    return true;
                }else {
                    for (int i = location.getY()+1; i < destination.getY(); i++){
                        if (chessboard.isOccupied(destination.getX(),i)){
                            return false;
                        }
                    }
                    return true;
                }
            }
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
}
