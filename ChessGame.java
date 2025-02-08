import java.util.Scanner;
import java.util.ArrayList;
// Chess game class to read chess pieces from user input and validate moves
public class ChessGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<ChessPiece> chessPieces = new ArrayList<>();

        while (true) {
            try {
                System.out.print("Select a chess piece (PAWN, ROOK, KNIGHT, BISHOP, QUEEN, KING): ");
                PieceType pieceType = PieceType.valueOf(scanner.next().toUpperCase());

                System.out.print("Enter color (WHITE, BLACK): ");
                ColorType color = ColorType.valueOf(scanner.next().toUpperCase());

                System.out.print("Enter current column (a-h): ");
                char col = scanner.next().charAt(0);

                System.out.print("Enter current row (1-8): ");
                int row = scanner.nextInt();

                if (!Chessboard.withinChessboard(col, row)) {
                    System.out.println("Invalid position. Try again.");
                    continue;
                }

                ChessPiece piece = switch (pieceType) {
                    case PAWN -> new Pawn(color, col, row);
                    case ROOK -> new Rook(color, col, row);
                    case KNIGHT -> new Knight(color, col, row);
                    case BISHOP -> new Bishop(color, col, row);
                    case QUEEN -> new Queen(color, col, row);
                    case KING -> new King(color, col, row);
                };

                chessPieces.add(piece);

                while (true) {
                    System.out.print("Enter target column (a-h): ");
                    char targetCol = scanner.next().charAt(0);

                    System.out.print("Enter target row (1-8): ");
                    int targetRow = scanner.nextInt();

                    if (piece.isValidMove(targetCol, targetRow)) {
                        System.out.println("Valid move!");
                    } else {
                        System.out.println("Invalid move!");
                    }

                    System.out.print("Check another move? (yes/no): ");
                    if (!scanner.next().equalsIgnoreCase("yes")) break;
                }

                System.out.print("Select another piece? (yes/no): ");
                if (!scanner.next().equalsIgnoreCase("yes")) break;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input. Please try again.");
                scanner.nextLine(); // Clear buffer
            }
        }
        scanner.close();
    }
}
