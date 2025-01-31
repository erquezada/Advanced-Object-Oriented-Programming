import java.util.Scanner;
import java.io.File;
public class Chess{
	public static void main(String[]args){
		try{
			//Reads and save the text file into an 2d array
			Scanner sc = new Scanner(new File("chess.txt")); 
			String[][] database = new String[6][];
			int i=0;
			while(sc.hasNextLine()){
				String line = sc.nextLine(); 
				String[] delim = line.split(","); 
				database[i] = delim;
				System.out.println(database[i][0]+"|"+database[i][1]+"|"+database[i][2]+"|"+database[i][3]);
				i++;
			}
			
			
		}
		catch(Exception e){
			System.out.println("File can't be read");
		}
		//User menu selection for the next movement, the user will choose the piece, and the both coodinates 
		System.out.println("Choose the piece you want to move. Options: King, Rook, Pawn, Knight, Queen, Bishop")
		//String ChoosePiece= ;
		System.out.println("Choose the x coordinate(A-H)");
		//String
		System.out.println("Choose the y coordinate(1-8)");
		//int
	}

}
