class Pawn extends ChessPiece {
    // Empty constructor
    public Pawn(String color, char column, int row) {
        super("Pawn", color, column, row);
    }

    @Override
    public boolean verifyMove(char newX, int newY) {
        return (this.column == newX) && (newY == this.row + (color.equals("WHITE") ? 1 : -1));
    }
}
