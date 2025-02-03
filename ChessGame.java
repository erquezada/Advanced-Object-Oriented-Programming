/*
*  Course: CS 3331: Advanced Object-Oriented Programming
 * Students: Eric Quezada, Conrado Carillo, Alejandro Acevedo
 *  Lab 1: Validating a move for a chess piece
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class ChessPiece { 
    private String name; // name of the piece
    private String color; // color of the piece
    private char posX; // position of the piece (column)
    private int posY; // position of the piece (row)

    // constructor
    public ChessPiece(String name, String color, char posX, int posY) { 
        this.name = name;
        this.color = color;
        this.posX = posX;
        this.posY = posY;
    }

    // getters and setters
    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public char getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    // method to validate the piece is within a chess board
    public boolean isWithinBoard(char x, int y) {
        return x >= 'a' && x <= 'h' && y >= 1 && y <= 8;
    }

    // method to check if the piece can move to a target position
    public boolean canMoveTo(char targetX, int targetY) {
        if (!isWithinBoard(targetX, targetY)) {
            return false;
        }
        int horizontalDistanceX = Math.abs(targetX - posX); // A - H
        int verticalDistanceY = Math.abs(targetY - posY);   // 1 - 8

        switch (name) {
            case "Pawn":
                // Pawns move forward one square (assuming no capturing)
                return horizontalDistanceX == 0 && verticalDistanceY == 1;

            case "Rook":
                // Rooks move in straight lines
                return horizontalDistanceX == 0 || verticalDistanceY == 0;

            case "Knight":
                // Knights move in an L-shape
                return (horizontalDistanceX == 2 && verticalDistanceY == 1) || (horizontalDistanceX == 1 && verticalDistanceY == 2);

            case "Bishop":
                // Bishops move diagonally
                return horizontalDistanceX == verticalDistanceY;

            case "Queen":
                // Queens move in straight lines or diagonally
                return horizontalDistanceX == 0 || verticalDistanceY == 0 || horizontalDistanceX == verticalDistanceY;

            case "King":
                // Kings move one square in any direction
                return horizontalDistanceX <= 1 && verticalDistanceY <= 1;

            default:
                return false; 
        } 
    }

    // toString method to display the piece details
    @Override
    public String toString() {
        return name + " (" + color + ") at " + posX + ", " + posY;
    }
}

// Chess game class to read chess pieces from a file and validate the moves
public class ChessGame {
    public static ArrayList<ChessPiece> readChessPieces(String filePath) throws FileNotFoundException {
        ArrayList<ChessPiece> pieces = new ArrayList<>();
        File file = new File(filePath);

        Scanner scan = new Scanner(file);
        // Read each line from the file and create a ChessPiece object
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] columns = line.split(", ");
            String name = columns[0];
            String color = columns[1];
            char posX = columns[2].charAt(0);
            int posY = Integer.parseInt(columns[3]);
            pieces.add(new ChessPiece(name, color, posX, posY));
        }

        scan.close();
        return pieces;
    }

    public static void main(String[] args) {
        try {
            // Step 1: Read chess pieces from the file
            String filePath = "chess.txt"; 
            ArrayList<ChessPiece> chessPieces = readChessPieces(filePath);

            // Step 2: Prompt the user for the target position
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the position you want to move to (a-h): ");
            char targetX = scanner.next().toLowerCase().charAt(0);
            System.out.print("Enter the position you want to move to (1-8): ");
            int targetY = scanner.nextInt();

            // Step 3: Validate the move for each piece
            for (ChessPiece piece : chessPieces) {
                if (piece.canMoveTo(targetX, targetY)) {
                    System.out.println(piece + " can move to " + targetX + ", " + targetY);
                } else {
                    System.out.println(piece + " can NOT move to " + targetX + ", " + targetY);
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}
