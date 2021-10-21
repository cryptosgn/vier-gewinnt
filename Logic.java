import java.util.ArrayList;
import java.util.Scanner;

public class Logic {
	
//	Variablen für die Eingabe der Spieleranzahl
	static ArrayList<Spieler> player = new ArrayList<Spieler>(); 
	static 	Spielfeld spielfeld = new Spielfeld();
	static int playercount;
	static boolean didsomeonealreadywin = false;
	
	static Scanner in = new Scanner(System.in);
	
	static void logic() {
		
		spieleranzahl();
		chipsetzen();
		
	}
	
	private static void spieleranzahl() {
		
		char unicode = 58;
		
		System.out.println("mit wievielen Personen möchten sie Spielen?");
		
		playercount = in();
		System.out.println("Eure Zeichen:");
		for(int c = 0; c < playercount; c++) {
			
			player.add(c, new Spieler(unicode, c));
			
			unicode++;
			System.out.println("\n" + "Spieler "+ (c+1) + ":" + player.get(c).getSign());
		}
		player.trimToSize();
		
	}
	
	static void chipsetzen() {
//		try {
//		i entspricht dem Spieler, der gerade an der Reihe ist
			for(int i = 0; i < playercount; i++) {
				System.out.println("wo möchtest du setzten, player " + (i+1));
				player.get(i).chipsetzen(i);
			}
//		} catch (Exception e){
//			System.err.println("an error occurred");
//		}
		
//		Spielfeld printen
			Spielfeld.printsf();
	}
	
	public static int in() {
		int eingabe = -1;	
		try {
			eingabe = in.nextInt();
		}catch(Exception e) {
			System.err.println("diese Eingabe liegt nicht im Bereich, des Möglichen... versuchen sie es am besten mal mit 42... und nehmen sie beim nächsten mal ein Handtuch mit ;)");
		}
		
		return eingabe;
	}
	
	
}
