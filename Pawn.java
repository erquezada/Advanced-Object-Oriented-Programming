class Pawn extends ChessPiece {
    public Pawn(ColorType color, char column, int row) {
        super(PieceType.PAWN, color, column, row);
    }

    @Override
    public boolean verifyTarget(char targetCol, int targetRow) {
        int direction = (color == ColorType.WHITE) ? 1 : -1; // White moves up, Black moves down
        int rowDiff = targetRow - row;
        int colDiff = Math.abs(targetCol - column);

        // Regular move: One step forward
        if (colDiff == 0 && rowDiff == direction) {
            return true;
        }

        // First move: Two steps forward from starting row
        if (colDiff == 0 && rowDiff == 2 * direction && (row == 2 || row == 7)) {
            return true;
        }

        // Capturing move: One step diagonally forward
        if (colDiff == 1 && rowDiff == direction) {
            return true;
        }

        return false;
    }
}
