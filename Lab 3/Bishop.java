class Bishop extends ChessPiece {
    // Empty constructor
    public Bishop(String color, char column, int row) {
        super("Bishop", color, column, row);
    }

    @Override
    public boolean verifyMove(char newX, int newY) {
        return Math.abs(this.column - newX) == Math.abs(this.row - newY);
    }
}
