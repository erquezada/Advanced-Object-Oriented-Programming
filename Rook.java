class Rook extends ChessPiece {
    // Empty constructor
    public Rook(String color, char column, int row) {
        super("Rook", color, column, row);
    }

    @Override
    public boolean verifyMove(char newX, int newY) {
        return (this.column == newX || this.row == newY);
    }
}
