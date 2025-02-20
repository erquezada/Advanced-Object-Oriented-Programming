import java.util.Scanner;

public class ChessGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ChessPiece[] pieces = new ChessPiece[6];

        // Prompt user for each of the six pieces
        for (int i = 0; i < 6; i++) {
            System.out.println("Select a piece: Pawn, Rook, Knight, Bishop, Queen, King");
            String pieceName = sc.nextLine().trim();

            System.out.println("Enter color (WHITE or BLACK):");
            String color = sc.nextLine().trim().toUpperCase();

            char column;
            int row;
            while (true) { // starting position loop
                System.out.println("Enter starting position (Column A-H and Row 1-8):");
                String input = sc.nextLine().trim().toUpperCase();
                column = input.charAt(0);
                row = Character.getNumericValue(input.charAt(1));

                if (ChessBoard.withinChessboard(column, row)) break;
                System.out.println("Invalid position! Enter column A-H and row 1-8.");
            }

            // Create the corresponding piece object
            switch (pieceName.toLowerCase()) {
                case "pawn": pieces[i] = new Pawn(color, column, row); break;
                case "rook": pieces[i] = new Rook(color, column, row); break;
                case "knight": pieces[i] = new Knight(color, column, row); break;
                case "bishop": pieces[i] = new Bishop(color, column, row); break;
                case "queen": pieces[i] = new Queen(color, column, row); break;
                case "king": pieces[i] = new King(color, column, row); break;
                default:
                    System.out.println("Invalid piece! Restarting input.");
                    i--;
            }
        }

        // Get target position
        char targetColumn;
        int targetRow;
        while (true) { // target loop
            System.out.println("Enter target position (Column A-H and Row 1-8):");
            String input = sc.nextLine().trim().toUpperCase();
            targetColumn = input.charAt(0);
            targetRow = Character.getNumericValue(input.charAt(1));

            if (ChessBoard.withinChessboard(targetColumn, targetRow)) break;
            System.out.println("Invalid position! Enter column A-H and row 1-8.");
        }

        // Check if each piece can move to the target position
        System.out.println("\nVerifying moves:\n");
        for (ChessPiece piece : pieces) {
            System.out.printf("%s at %c%d %s move to %c%d%n",
                piece.getPieceName(), piece.getColumn(), piece.getRow(),
                piece.verifyMove(targetColumn, targetRow) ? "can" : "can NOT",
                targetColumn, targetRow);
        }

        sc.close();
    }
}
