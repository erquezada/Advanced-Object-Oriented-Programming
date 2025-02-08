class Knight extends ChessPiece {
    public Knight(ColorType color, char column, int row) {
        super(PieceType.KNIGHT, color, column, row);
    }

    @Override
    public boolean verifyTarget(char targetCol, int targetRow) {
        int colDiff = Math.abs(targetCol - column);
        int rowDiff = Math.abs(targetRow - row);
        return (colDiff == 2 && rowDiff == 1) || (colDiff == 1 && rowDiff == 2); // L-shape movement
    }
}
