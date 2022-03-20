package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Coordinates;
import ax.ha.tdd.chess.engine.Player;

public class King extends ChessPiece {
    boolean hasMoved = false;

    public King(PieceType pieceType, Player player, Coordinates location) {
        super(pieceType, player, location);
    }

    @Override
    public String getSymbol() {
        return pieceType.getSymbol();
    }

    @Override
    public boolean canMove(Chessboard chessboard, Coordinates destination) {
        if (checkOccupiedAndCastle(chessboard, destination)) {
            if (checkCastling(chessboard, destination)) {
                chessboard.addPiece(new Rook(PieceType.ROOK,player,new Coordinates(location.getX(), location.getY())));
                return true;
            }
            return false;
        }
        if (checkOneStep(destination)) {
            if (checkForPawn(chessboard, destination) && checkRook(destination, chessboard, PieceType.ROOK) && checkKnight(chessboard, destination) && checkBishop(destination, chessboard, PieceType.BISHOP) && checkQueen(chessboard, destination)) {
                hasMoved = true;
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private boolean inBounds(int i, int j) {
        return i >= 0 && i < 8 && j >= 0 && j < 8;
    }

    private boolean checkOneStep(Coordinates dest) {
        int numOfSteps = 0;

        int directionX = Integer.compare(0, location.getX() - dest.getX());
        int directionY = Integer.compare(0, location.getY() - dest.getY());

        if (directionX != 0 && directionY == 0) {
            numOfSteps = Math.abs(location.getX() - dest.getX());
        } else {
            numOfSteps = Math.abs(location.getY() - dest.getY());
        }

        if (numOfSteps == 1 || numOfSteps == 0) {
            return true;
        } else {
            return false;
        }
    }

    private boolean checkForPawn(Chessboard board, Coordinates destination) {

        if (this.player.getSymbol().equals("W")) {
            if (inBounds(destination.getX() + 1, destination.getY() - 1) && board.isOccupied(destination.getX() + 1, destination.getY() - 1) && !location.equals(new Coordinates(destination.getX() + 1, destination.getY() - 1))) {
                if (board.getPiece(new Coordinates(destination.getX() + 1, destination.getY() - 1)).getPieceType().equals(PieceType.PAWN) && !board.getPiece(new Coordinates(destination.getX() + 1, destination.getY() - 1)).getPlayer().equals(player)) {
                    return false;
                }
            }
            if (inBounds(destination.getX() - 1, destination.getY() - 1) && board.isOccupied(destination.getX() - 1, destination.getY() - 1) && !location.equals(new Coordinates(destination.getX() + 1, destination.getY() - 1))) {
                if (board.getPiece(new Coordinates(destination.getX() - 1, destination.getY() - 1)).getPieceType().equals(PieceType.PAWN) && !board.getPiece(new Coordinates(destination.getX() - 1, destination.getY() - 1)).getPlayer().equals(player)) {
                    return false;
                }
            }
            return true;
        } else {
            if (inBounds(destination.getX() - 1, destination.getY() + 1) && board.isOccupied(destination.getX() - 1, destination.getY() + 1) && !location.equals(new Coordinates(destination.getX() + 1, destination.getY() - 1))) {
                if (board.getPiece(new Coordinates(destination.getX() - 1, destination.getY() + 1)).getPieceType().equals(PieceType.PAWN) && !board.getPiece(new Coordinates(destination.getX() - 1, destination.getY() + 1)).getPlayer().equals(player)) {
                    return false;
                }
            }
            if (inBounds(destination.getX() + 1, destination.getY() + 1) && board.isOccupied(destination.getX() + 1, destination.getY() + 1) && !location.equals(new Coordinates(destination.getX() + 1, destination.getY() + 1))) {
                if (board.getPiece(new Coordinates(destination.getX() + 1, destination.getY() + 1)).getPieceType().equals(PieceType.PAWN) && !board.getPiece(new Coordinates(destination.getX() + 1, destination.getY() + 1)).getPlayer().equals(player)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkRook(Coordinates destination, Chessboard board, PieceType type) {

        int i = destination.getX();
        int j = destination.getY();
        int k = 0;

        //ner
        while (inBounds(i + ++k, j)) {
            if (board.isOccupied(i + k, j) && !location.equals(new Coordinates(i + k, j))) {
                if (board.getPiece(new Coordinates(i + k, j)).getPlayer().equals(player)) {
                    break;
                } else if (board.getPiece(new Coordinates(i + k, j)).getPieceType().equals(type)) {
                    return false;
                }
            }
        }
        // upp
        k = 0;
        while (inBounds(i + --k, j)) {
            if (board.isOccupied(i + k, j) && !location.equals(new Coordinates(i + k, j))) {
                if (board.getPiece(new Coordinates(i + k, j)).getPlayer().equals(player)) {
                    break;
                } else if (board.getPiece(new Coordinates(i + k, j)).getPieceType().equals(type)) {
                    return false;
                }
            }
        }
        // höger
        k = 0;
        while (inBounds(i, j + ++k)) {
            if (board.isOccupied(i, j + k) && !location.equals(new Coordinates(i, j + k))) {
                if (board.getPiece(new Coordinates(i, j + k)).getPlayer().equals(player)) {
                    break;
                } else if (board.getPiece(new Coordinates(i, j + k)).getPieceType().equals(type)) {
                    return false;
                }
            }
        }
        // vänster
        k = 0;
        while (inBounds(i, j + --k)) {
            if (board.isOccupied(i, j + k) && !location.equals(new Coordinates(i, j + k))) {
                if (board.getPiece(new Coordinates(i, j + k)).getPlayer().equals(player)) {
                    break;
                } else if (board.getPiece(new Coordinates(i, j + k)).getPieceType().equals(type)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkKnight(Chessboard board, Coordinates destination) {

        int i = destination.getX();
        int j = destination.getY();

        int[] x = {2, 2, -2, -2, 1, 1, -1, -1};
        int[] y = {1, -1, 1, -1, 2, -2, 2, -2};

        for (int k = 0; k < 8; k++) {

            int m = i + x[k];
            int n = j + y[k];

            if (inBounds(m, n) && board.isOccupied(m, n) && board.getPiece(new Coordinates(m, n)).getPieceType().equals(PieceType.KNIGHT) && !board.getPiece(new Coordinates(m, n)).getPlayer().equals(player))
                return false;
        }
        return true;
    }

    public boolean checkBishop(Coordinates destination, Chessboard board, PieceType type) {
        int i = destination.getX();
        int j = destination.getY();
        // ner höger
        int k = 0;
        while (inBounds(i + ++k, j + k)) {
            if (board.isOccupied(i + k, j + k) && board.getPiece(new Coordinates(i + k, j + k)).getPlayer().equals(player)) {
                break;
            } else if (board.isOccupied(i + k, j + k) && board.getPiece(new Coordinates(i + k, j + k)).getPieceType().equals(type)) {
                return false;
            }
        }

        //ner vänster
        k = 0;
        while (inBounds(i + ++k, j - k)) {
            if (board.isOccupied(i + k, j - k) && board.getPiece(new Coordinates(i + k, j - k)).getPlayer().equals(player)) {
                break;
            } else if (board.isOccupied(i + k, j - k) && board.getPiece(new Coordinates(i + k, j - k)).getPieceType().equals(type)) {
                return false;
            }
        }

        //upp höger
        k = 0;
        while (inBounds(i - ++k, j + k)) {
            if (board.isOccupied(i - k, j + k) && board.getPiece(new Coordinates(i - k, j + k)).getPlayer().equals(player)) {
                break;
            } else if (board.isOccupied(i - k, j + k) && board.getPiece(new Coordinates(i - k, j + k)).getPieceType().equals(type)) {
                return false;
            }
        }

        // upp vänster
        k = 0;
        while (inBounds(i - ++k, j - k)) {
            if (board.isOccupied(i - k, j - k) && board.getPiece(new Coordinates(i - k, j - k)).getPlayer().equals(player)) {
                break;
            } else if (board.isOccupied(i - k, j - k) && board.getPiece(new Coordinates(i - k, j - k)).getPieceType().equals(type)) {
                return false;
            }
        }

        return true;
    }

    public boolean checkQueen(Chessboard board, Coordinates destination) {

        if (checkBishop(destination, board, PieceType.QUEEN)) {
            if (checkRook(destination, board, PieceType.QUEEN)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkOccupiedAndCastle(Chessboard board, Coordinates destination) {
        if (board.isOccupied(destination.getX(), destination.getY())) {
            if (board.getPiece(new Coordinates(destination.getX(), destination.getY())).getPieceType().equals(PieceType.ROOK) && board.getPiece(new Coordinates(destination.getX(), destination.getY())).getPlayer().equals(player)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkCastling(Chessboard board, Coordinates destination) {

        Rook rook = (Rook) board.getPiece(new Coordinates(destination.getX(), destination.getY()));
        if (rook.isHasMoved()) {
            return false;
        } else {
            //kolla om den rutan eller någon där emellan är hotade
            int directionX = Integer.compare(0, location.getX() - destination.getX());
            int numOfSteps = Math.abs(location.getX() - destination.getX());
            for (int i = 0; i <= numOfSteps; i++) {
                destination = new Coordinates(location.getX() + i * directionX, location.getY());
                if (!checkForPawn(board, destination) || !checkRook(destination, board, PieceType.ROOK) || !checkKnight(board, destination) || !checkBishop(destination, board, PieceType.BISHOP) || !checkQueen(board, destination)) {
                    return false;
                }
            }
        }

        return true;
    }
}
