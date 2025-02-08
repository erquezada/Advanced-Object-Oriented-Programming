import java.util.Scanner;
import java.util.ArrayList;

// Enums for PieceType and ColorType
enum PieceType { PAWN, ROOK, KNIGHT, BISHOP, QUEEN, KING }
enum ColorType { WHITE, BLACK }

// Chessboard class containing rows and columns for chess game
class ChessBoard {
    public static final int MIN_ROW = 1;
    public static final int MAX_ROW = 8;
    public static final char MIN_COL = 'a';
    public static final char MAX_COL = 'h';

    // Method to validate if the coordinates are within the chessboard
    public static boolean withinChessboard(char col, int row) {
        return col >= MIN_COL && col <= MAX_COL && row >= MIN_ROW && row <= MAX_ROW;
    }
}

// Abstract ChessPiece class
abstract class ChessPiece {
    protected PieceType name;
    protected ColorType color;
    protected char column;
    protected int row;

    public ChessPiece(PieceType name, ColorType color, char column, int row) {
        this.name = name;
        this.color = color;
        this.column = column;
        this.row = row;
    }

    public abstract boolean verifyTarget(char targetCol, int targetRow);

    public boolean isValidMove(char targetCol, int targetRow) {
        return Chessboard.withinChessboard(targetCol, targetRow) && verifyTarget(targetCol, targetRow);
    }
}
