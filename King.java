class King extends ChessPiece {
    public King(ColorType color, char column, int row) {
        super(PieceType.KING, color, column, row);
    }

    @Override
    public boolean verifyTarget(char targetCol, int targetRow) {
        int colDiff = Math.abs(targetCol - column);
        int rowDiff = Math.abs(targetRow - row);
        return colDiff <= 1 && rowDiff <= 1 && (colDiff + rowDiff > 0); // Ensures the king moves exactly one square
    }
}
