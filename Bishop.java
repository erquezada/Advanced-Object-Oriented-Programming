class Bishop extends ChessPiece {
    public Bishop(ColorType color, char column, int row) {
        super(PieceType.BISHOP, color, column, row);
    }

    @Override
    public boolean verifyTarget(char targetCol, int targetRow) {
        int colDiff = Math.abs(targetCol - column);
        int rowDiff = Math.abs(targetRow - row);
        return colDiff == rowDiff; // Bishops move diagonally
    }
}
