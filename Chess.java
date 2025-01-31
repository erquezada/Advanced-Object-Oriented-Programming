import java.util.Scanner;
import java.io.File;
public class Chess{
	public static void main(String[]args){
		try{
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
		
		System.out.println("Choose the piece you want to move. Options: King, Rook, Pawn, Knight, Queen, Bishop")
		String ChoosePiece=;
	}

}
