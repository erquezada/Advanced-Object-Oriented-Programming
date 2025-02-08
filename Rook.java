class Rook extends ChessPiece {
    public Rook(ColorType color, char column, int row) {
        super(PieceType.ROOK, color, column, row);
    }

    @Override
    public boolean verifyTarget(char targetCol, int targetRow) {
        // The rook moves either horizontally (same row) or vertically (same column)
        return column == targetCol || row == targetRow;
    }
}
