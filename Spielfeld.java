
public class Spielfeld {
//	statisches Array, um abzufragen, ob chip loegt und zur Ausgabe
	public static boolean[][] istschoneinchipdraufgesetzt = new boolean[6][7];
	
	public void chipsetzen(int wo, int wer) {
		
//		i ist die vertikale Position vom "Chip"
//		errormanagement einfügen
		for(int i = 6; i > 0; i--) {
//			try-catch einfügen
			if(!istschoneinchipdraufgesetzt[wo][i]) {
				istschoneinchipdraufgesetzt[wo][i] = true;
//				wissen welcher Player an der Reihe ist und die Werte der entsprechenden setmap anzupassen/zu setzen
				Logic.player.get(wer).setmap[wo][i] = true;
				break;
			}
			
		}
	}
	
	public static void printsf() {
		System.out.println();
		System.out.println();
			for(int innerC = 0; innerC < 7; innerC++) {
				System.out.println();
				for(int outerC = 0; outerC < 6; outerC++) {
					if(istschoneinchipdraufgesetzt[outerC][innerC]) {
						for(int temp = 0; temp <= (Logic.playercount-1); temp++) {
							if(Logic.player.get(temp).getSetmap()[outerC][innerC] == istschoneinchipdraufgesetzt[outerC][innerC]) {
								System.out.print(Logic.player.get(temp).getSign() + "|");
							}
						}
					}
					else {
						System.out.print("2|");
					}
				}
			}
			for(int temp1 = 0; temp1 <= (Logic.playercount-1); temp1++) {
				Logic.player.get(temp1).counthowmanyinarow();
			}
			if(!Logic.didsomeonealreadywin) {
				System.out.println();
				Logic.chipsetzen();
			}
		}
	
}
