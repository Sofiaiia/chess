package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.engine.pieces.*;

import java.util.Iterator;
import java.util.List;

public class Chessboard implements Iterable<ChessPiece[]> {
    // This could just as easily be replaced with a List or Set,
    // since the ChessPieces right now keep track of their own location.
    // Feel free to change this however you like
    // [y][x]
    private final ChessPiece[][] board = new ChessPiece[8][8];

    public static Chessboard startingBoard() {
        final Chessboard chessboard = new Chessboard();

        chessboard.withMirroredPiece(PieceType.PAWN, List.of(0,1,2,3,4,5,6,7), 1)
                .withMirroredPiece(PieceType.ROOK, List.of(0,7), 0)
                .withMirroredPiece(PieceType.KNIGHT, List.of(1,6), 0)
                .withMirroredPiece(PieceType.BISHOP, List.of(2,5), 0)
                .withMirroredPiece(PieceType.QUEEN, List.of(3), 0)
                .withMirroredPiece(PieceType.KING, List.of(4), 0);
        return chessboard;
    }

    public ChessPiece getPiece(final Coordinates coordinates) {
        return board[coordinates.getY()][coordinates.getX()];
    }

    public void addPiece(final ChessPiece chessPiece) {
        board[chessPiece.getLocation().getY()][chessPiece.getLocation().getX()] = chessPiece;
    }

    public void removePiece(final ChessPiece chessPiece) {
        board[chessPiece.getLocation().getY()][chessPiece.getLocation().getX()] = null;
    }

    /**
     * Helper method to initialize chessboard with {@link ChessPieceStub}.
     * Basically mirrors all added pieces for both players.
     * When all pieces has been implemented, this should be replaced with the proper implementations.
     *
     * @param pieceType pieceType
     * @param xCoordinates xCoordinates
     * @param yCoordinate yCoordinateOffset
     * @return itself, like a builder pattern
     */
    private Chessboard withMirroredPiece(final PieceType pieceType,
                                         final List<Integer> xCoordinates, final int yCoordinate) {
        xCoordinates.forEach(xCoordinate -> {
            switch (pieceType) {
                case PAWN -> {
                    addPiece(new Pawn(pieceType, Player.BLACK, new Coordinates(xCoordinate, yCoordinate)));
                    addPiece(new Pawn(pieceType, Player.WHITE, new Coordinates(xCoordinate, 7 - yCoordinate)));
                }
                case ROOK -> {
                    addPiece(new Rook(pieceType, Player.BLACK, new Coordinates(xCoordinate, yCoordinate)));
                    addPiece(new Rook(pieceType, Player.WHITE, new Coordinates(xCoordinate, 7 - yCoordinate)));
                }
                case KNIGHT -> {
                    addPiece(new Knight(pieceType, Player.BLACK, new Coordinates(xCoordinate, yCoordinate)));
                    addPiece(new Knight(pieceType, Player.WHITE, new Coordinates(xCoordinate, 7 - yCoordinate)));
                }
                case BISHOP -> {
                    addPiece(new Bishop(pieceType, Player.BLACK, new Coordinates(xCoordinate, yCoordinate)));
                    addPiece(new Bishop(pieceType, Player.WHITE, new Coordinates(xCoordinate, 7 - yCoordinate)));
                }
                case QUEEN -> {
                    addPiece(new Queen(pieceType, Player.BLACK, new Coordinates(xCoordinate, yCoordinate)));
                    addPiece(new Queen(pieceType, Player.WHITE, new Coordinates(xCoordinate, 7 - yCoordinate)));
                }
                case KING -> {
                    addPiece(new King(pieceType, Player.BLACK, new Coordinates(xCoordinate, yCoordinate)));
                    addPiece(new King(pieceType, Player.WHITE, new Coordinates(xCoordinate, 7 - yCoordinate)));
                }
            }
        });
        return this;
    }

    @Override
    public Iterator<ChessPiece[]> iterator() {
        return List.of(board).iterator();
    }

    public boolean isOccupied(int x, int y){
        if(board[y][x] == null){
            return false;
        }else{
            return true;
        }
    }

    public boolean movePiece(String move, Player player){
        String[] moves = move.split("-");
        ChessPiece pieceToMove = getPiece(new Coordinates(moves[0]));
        if(pieceToMove.getPlayer().equals(player)) {
            Boolean canMove = false;
            ChessPiece piece = null;

            switch (pieceToMove.getPieceType()) {
                case PAWN:
                    canMove = new Pawn(pieceToMove.getPieceType(), pieceToMove.getPlayer(), pieceToMove.getLocation()).canMove(this, new Coordinates(moves[1]));
                    piece = new Pawn(pieceToMove.getPieceType(), pieceToMove.getPlayer(), new Coordinates(moves[1]));
                    break;
                case ROOK:
                    canMove = new Rook(pieceToMove.getPieceType(),pieceToMove.getPlayer(),pieceToMove.getLocation()).canMove(this,new Coordinates(moves[1]));
                    piece = new Rook(pieceToMove.getPieceType(), pieceToMove.getPlayer(), new Coordinates(moves[1]));
                    break;
                case KNIGHT:
                    canMove = new Knight(pieceToMove.getPieceType(),pieceToMove.getPlayer(),pieceToMove.getLocation()).canMove(this,new Coordinates(moves[1]));
                    piece = new Knight(pieceToMove.getPieceType(), pieceToMove.getPlayer(), new Coordinates(moves[1]));
                    break;
                case BISHOP:
                    canMove = new Bishop(pieceToMove.getPieceType(),pieceToMove.getPlayer(),pieceToMove.getLocation()).canMove(this,new Coordinates(moves[1]));
                    piece = new Bishop(pieceToMove.getPieceType(), pieceToMove.getPlayer(), new Coordinates(moves[1]));
                    break;
                case QUEEN:
                    canMove = new Queen(pieceToMove.getPieceType(),pieceToMove.getPlayer(),pieceToMove.getLocation()).canMove(this,new Coordinates(moves[1]));
                    piece = new Queen(pieceToMove.getPieceType(), pieceToMove.getPlayer(), new Coordinates(moves[1]));
                    break;
                case KING:
                    canMove = new King(pieceToMove.getPieceType(),pieceToMove.getPlayer(),pieceToMove.getLocation()).canMove(this,new Coordinates(moves[1]));
                    piece = new King(pieceToMove.getPieceType(), pieceToMove.getPlayer(), new Coordinates(moves[1]));
                    break;
                default:
                    canMove = false;
            }

            if (canMove) {
                addPiece(piece);
                removePiece(pieceToMove);
                if(pieceToMove.getPieceType().equals(PieceType.KING)){
                    addPiece(new Rook(PieceType.ROOK,player,new Coordinates(moves[0])));
                }
                return true;
            } else {
                return false;
            }
        }else{
            //fel spelare
            return false;
        }
    }
}
