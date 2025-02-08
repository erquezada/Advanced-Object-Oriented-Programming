class Queen extends ChessPiece {
    public Queen(ColorType color, char column, int row) {
        super(PieceType.QUEEN, color, column, row);
    }

    @Override
    public boolean verifyTarget(char targetCol, int targetRow) {
        int colDiff = Math.abs(targetCol - column);
        int rowDiff = Math.abs(targetRow - row);

        // The queen can move like a rook (same column or row) or like a bishop (diagonal movement)
        return column == targetCol || row == targetRow || colDiff == rowDiff;
    }
}
