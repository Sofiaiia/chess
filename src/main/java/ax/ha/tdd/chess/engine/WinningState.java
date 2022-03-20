package ax.ha.tdd.chess.engine;

public enum WinningState {
    PLAYING("PLAYING"),
    CHECK("CHECK"),
    CHECKMATE("CHECKMATE");

    private final String symbol;

    WinningState(String symbol){this.symbol = symbol;}
    public String getSymbol(){return symbol;}

}
