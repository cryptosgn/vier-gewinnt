
public class Spieler {
	
	private int chips = (int) 42/Logic.playercount;
	private int howmanyinarow = 0;
	private int wo;
	private char sign;
	private int id;
	
//	privates Array, um zu wissen, wann der Spieler 4 am Stück hängende hat
	public boolean[][] setmap = new boolean[6][7];
	
	public Spieler(char sign, int id) {

		this.sign = sign;
		this.id = id;
		
	}
	
	public void chipsetzen(int wer) {
		if(howmanyinarow <= 4) {
			try {
				wo = Logic.in()-1;
				if(wo == -1) {
					wo++;
				}
				Logic.spielfeld.chipsetzen(wo, wer);
				chips--;
			}catch(Exception e) {
				System.err.println("Diese Eingabe ist nicht möglich");
				System.out.println("wo möchtest du setzten, player " + (wer+1));
				chipsetzen(wer);
			}
		}
	}
	
//	könnte man auch extenden
	public void counthowmanyinarow() {
//		horizontal
		for(int innerC = 0; innerC < 7; innerC++) {
			for(int outerC = 0; outerC < 6; outerC++) {
				if(setmap[outerC][innerC]) {
					howmanyinarow++;
					if (howmanyinarow == 4) {
						System.out.println("Du hast gewonnen, Player" + (id+1));
						Logic.didsomeonealreadywin = true;
						break;
					}
				} else {
					howmanyinarow = 0;
				}
			}
		}
		
//		vertikal
		for(int innerC = 0; innerC < 6; innerC++) {
			for(int outerC = 0; outerC < 7; outerC++) {
				if(setmap[innerC][outerC]) {
					howmanyinarow++;
					if (howmanyinarow == 4) {
						System.out.println("Du hast gewonnen, Player" + (id+1));
						Logic.didsomeonealreadywin = true;
						break;
					}
				} else {
					howmanyinarow = 0;
				}
			}
		}
		
//		diagonal
	}

	public boolean[][] getSetmap() {
		return setmap;
	}

	public char getSign() {
		return sign;
	}
	
}
