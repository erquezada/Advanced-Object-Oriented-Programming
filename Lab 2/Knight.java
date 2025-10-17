class Knight extends ChessPiece {
    // Empty constructor
    public Knight(String color, char column, int row) {
        super("Knight", color, column, row);
    }

    @Override
    public boolean verifyMove(char newX, int newY) {
        int dx = Math.abs(newX - this.column);
        int dy = Math.abs(newY - this.row);
        return (dx == 2 && dy == 1) || (dx == 1 && dy == 2);
    }
}
