package TicTacToe;

/**
 * @author Ivan Lovrencic
 * 
 * Board represents logic behind the game.
 *
 */
public class Board {
	private int[][] playingField;
	private boolean turn;
	private int victorian = 0;
	private int[] victoryCheck;
	private int[] dangerCheck;

	public Board() {
		playingField = new int[MainFrame.SIRINA][MainFrame.VISINA];
		turn = true;
		victoryCheck = new int[2];
		dangerCheck = new int[2];
	}
	
	
	
	public int[][] getPlayingField() {
		return playingField;
	}

	public boolean isTurn() {
		return turn;
	}
	
	public void setTurn(boolean value) {
		this.turn = value; 
	}
	
	public void setCell(int x,int y,int value) {
		this.playingField[x][y] = value;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < MainFrame.SIRINA ; i++) {
			for(int j = 0 ; j < MainFrame.VISINA ; j++) {
				if(this.playingField[i][j] == 1) {
					sb.append("O");
				}
				else if(this.playingField[i][j] == 2) {
					sb.append("X");
				}
				else {
					sb.append("-");
				}
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	
	//checking all possible endings
	public boolean isEnd(){
		victorian = 0;
		int brojac;
		//tri polja ista horizontalno
		brojac = 0;
		for(int j = 0 ; j < MainFrame.VISINA ; j++) {
			if(this.playingField[0][j] == 1) {
				brojac++;
			}
		}
		if(brojac == 3) {
			victorian = 1;
			return true;
		}
		
		brojac = 0;
		for(int j = 0 ; j < MainFrame.VISINA ; j++) {
			if(this.playingField[0][j] == 2) {
				brojac++;
			}
		}
		if(brojac == 3) {
			victorian = 2;
			return true;
		}
		
		brojac = 0;
		for(int j = 0 ; j < MainFrame.VISINA ; j++) {
			if(this.playingField[1][j] == 1) {
				brojac++;
			}
		}
		if(brojac == 3) {
			victorian = 1;
			return true;
		}
		
		brojac = 0;
		for(int j = 0 ; j < MainFrame.VISINA ; j++) {
			if(this.playingField[1][j] == 2) {
				brojac++;
			}
		}
		if(brojac == 3) {
			victorian = 2;
			return true;
		}
		
		brojac = 0;
		for(int j = 0 ; j < MainFrame.VISINA ; j++) {
			if(this.playingField[2][j] == 1) {
				brojac++;
			}
		}
		if(brojac == 3) {
			victorian = 1;
			return true;
		}
		
		brojac = 0;
		for(int j = 0 ; j < MainFrame.VISINA ; j++) {
			if(this.playingField[2][j] == 2) {
				brojac++;
			}
		}
		if(brojac == 3) {
			victorian = 2;
			return true;
		}
		
		//tri polja ista vertikalno
		brojac = 0;
		for(int i = 0 ; i < MainFrame.VISINA ; i++) {
			if(this.playingField[i][0] == 1) {
				brojac++;
			}
		}
		if(brojac == 3) {
			victorian = 1;
			return true;
		}
		
		brojac = 0;
		for(int i = 0 ; i < MainFrame.VISINA ; i++) {
			if(this.playingField[i][0] == 2) {
				brojac++;
			}
		}
		if(brojac == 3) {
			victorian = 2;
			return true;
		}
		
		brojac = 0;
		for(int i = 0 ; i < MainFrame.VISINA ; i++) {
			if(this.playingField[i][1] == 1) {
				brojac++;
			}
		}
		if(brojac == 3) {
			victorian = 1;
			return true;
		}
		
		brojac = 0;
		for(int i = 0 ; i < MainFrame.VISINA ; i++) {
			if(this.playingField[i][1] == 2) {
				brojac++;
			}
		}
		if(brojac == 3) {
			victorian = 2;
			return true;
		}
	
		brojac = 0;
		for(int i = 0 ; i < MainFrame.VISINA ; i++) {
			if(this.playingField[i][2] == 1) {
				brojac++;
			}
		}
		if(brojac == 3) {
			victorian = 1;
			return true;
		}
		
		brojac = 0;
		for(int i = 0 ; i < MainFrame.VISINA ; i++) {
			if(this.playingField[i][2] == 2) {
				brojac++;
			}
		}
		if(brojac == 3) {
			victorian = 2;
			return true;
		}
		
		//tri polja dijagonalno
		brojac = 0;
		for(int i = 0 ; i < MainFrame.VISINA ; i++) {
			for(int j = 0 ; j < MainFrame.SIRINA ; j++) {
				if(i == j) {
					if(this.playingField[i][j] == 1) {
						brojac++;
					}
				}
			}
		}
		if(brojac == 3) {
			victorian = 1;
			return true;
		}
		
		brojac = 0;
		for(int i = 0 ; i < MainFrame.VISINA ; i++) {
			for(int j = 0 ; j < MainFrame.SIRINA ; j++) {
				if(i == j) {
					if(this.playingField[i][j] == 2) {
						brojac++;
					}
				}
			}
		}
		if(brojac == 3) {
			victorian = 2;
			return true;
		}
		
		brojac = 0;
		for(int i = 0 ; i < MainFrame.VISINA ; i++) {
			for(int j = 0 ; j < MainFrame.SIRINA ; j++) {
				if(i + j == 2) {
					if(this.playingField[i][j] == 1) {
						brojac++;
					}
				}
			}
		}
		if(brojac == 3) {
			victorian = 1;
			return true;
		}
		
		brojac = 0;
		for(int i = 0 ; i < MainFrame.VISINA ; i++) {
			for(int j = 0 ; j < MainFrame.SIRINA ; j++) {
				if(i+j == 2) {
					if(this.playingField[i][j] == 2) {
						brojac++;
					}
				}
			}
		}
		if(brojac == 3) {
			victorian = 2;
			return true;
		}
		
		//sva polja popunjena
		brojac = 0;
		for(int i = 0 ; i < MainFrame.SIRINA ; i++) {
			for(int j = 0 ; j < MainFrame.VISINA ; j++) {
				if(this.playingField[i][j] != 0) {
						brojac++;
				}
			}
		}
		if(brojac == 9) {
			return true;
		}
				
		
		return false;
	}
		
	//returning a victorian
	public int getVictorian() {
		return victorian;
	}
	
	public int[] getBestMove(int value) {
		if(value == 1) {
			if(checkVictory(value)) {
				return victoryCheck;
			}
			if(checkDanger(value)) {
				return dangerCheck;
			}
			return null;
		}
		else {
			if(checkVictory(value)) {
				return victoryCheck;
			}
			if(checkDanger(value)) {
				return dangerCheck;
			}
			return null;
		}
	}
	
	public boolean checkVictory(int value) {
		boolean winner = true;
		int brojac;
		//tri polja ista horizontalno
			brojac = 0;
			for(int j = 0 ; j < MainFrame.VISINA ; j++) {
				if(this.playingField[0][j] == value) {
					brojac++;
				}
				else {
					if(this.playingField[0][j] == 0) {
						victoryCheck[1] = j;
					}
					else {
						winner = false;
					}
				}
			}
			if(brojac == 2 && winner) {
				victoryCheck[0] = 0;
				return true;
			}
				
			winner = true;
			brojac = 0;
			for(int j = 0 ; j < MainFrame.VISINA ; j++) {
				if(this.playingField[1][j] == value) {
					brojac++;
				}
				else {
					if(this.playingField[1][j] == 0) {
						victoryCheck[1] = j;
					}
					else {
						winner = false;
					}
				}
			}
			if(brojac == 2 && winner) {
				victoryCheck[0] = 1;
				return true;
			}
				
			winner = true;
			brojac = 0;
			for(int j = 0 ; j < MainFrame.VISINA ; j++) {
				if(this.playingField[2][j] == value) {
					brojac++;
				}
				else {
					if(this.playingField[2][j] == 0) {
						victoryCheck[1] = j;
					}
					else {
						winner = false;
					}
				}
			}
			if(brojac == 2 && winner) {
				victoryCheck[0] = 2;
				return true;
			}
				
			//tri polja ista vertikalno
			winner = true;
			brojac = 0;
			for(int i = 0 ; i < MainFrame.VISINA ; i++) {
				if(this.playingField[i][0] == value) {
					brojac++;
				}
				else {
					if(this.playingField[i][0] == 0) {
						victoryCheck[0] = i;
					}
					else {
						winner = false;
					}
				}
			}
			if(brojac == 2 && winner) {
				victoryCheck[1] = 0;
				return true;
			}
			
			winner = true;
			brojac = 0;
			for(int i = 0 ; i < MainFrame.VISINA ; i++) {
				if(this.playingField[i][1] == value) {
					brojac++;
				}
				else {
					if(this.playingField[i][1] == 0) {
						victoryCheck[0] = i;
					}
					else {
						winner = false;
					}
				}
			}
			if(brojac == 2 && winner) {
				victoryCheck[1] = 1;
				return true;
			}
			
			winner = true;
			brojac = 0;
			for(int i = 0 ; i < MainFrame.VISINA ; i++) {
				if(this.playingField[i][2] == value) {
					brojac++;
				}
				else {
					if(this.playingField[i][2] == 0) {
						victoryCheck[0] = i;
					}
					else {
						winner = false;
					}
				}
			}
			if(brojac == 2 && winner) {
				victoryCheck[1] = 2;
				return true;
			}
				
			//tri polja dijagonalno
			winner = true;
			brojac = 0;
			for(int i = 0 ; i < MainFrame.VISINA ; i++) {
				for(int j = 0 ; j < MainFrame.SIRINA ; j++) {
					if(i == j) {
						if(this.playingField[i][j] == value) {
							brojac++;
						}
						else {
							if(this.playingField[i][j] == 0) {
								victoryCheck[0] = i;
								victoryCheck[1] = j;
							}
							else {
								winner = false;
							}
						}
					}
				}
			}
			if(brojac == 2 && winner) {
				System.out.println("Prva dijagonala");
				return true;
			}
			
			winner = true;
			brojac = 0;
			for(int i = 0 ; i < MainFrame.VISINA ; i++) {
				for(int j = 0 ; j < MainFrame.SIRINA ; j++) {
					if(i + j == 2) {
						if(this.playingField[i][j] == value) {
							brojac++;
						}
						else {
							if(this.playingField[i][j] == 0) {
								victoryCheck[0] = i;
								victoryCheck[1] = j;
							}
							else {
								winner = false;
							}
						}
					}
				}
			}
			if(brojac == 2 && winner) {
				System.out.println("Druga dijagonala");
				return true;
			}
			return false;
	}
	
	public boolean checkDanger(int value) {
		boolean danger = true;
		int newValue;
		if(value == 1) {
			newValue = 2;
		}
		else {
			newValue = 1;
		}
		
		int brojac = 0;
		//tri polja ista horizontalno
			brojac = 0;
			for(int j = 0 ; j < MainFrame.VISINA ; j++) {
				if(this.playingField[0][j] == newValue) {
					brojac++;
				}
				else {
					if(this.playingField[0][j] == 0) {
						dangerCheck[1] = j;
					}
					else {
						danger = false;
					}
				}
			}
			if(brojac == 2 && danger) {
				dangerCheck[0] = 0;
				return true;
			}
				
			danger = true;
			brojac = 0;
			for(int j = 0 ; j < MainFrame.VISINA ; j++) {
				if(this.playingField[1][j] == newValue) {
					brojac++;
				}
				else {
					if(this.playingField[1][j] == 0) {
						dangerCheck[1] = j;
					}
					else {
						danger = false;
					}
				}
			}
			if(brojac == 2 && danger) {
				dangerCheck[0] = 1;
				return true;
			}
				
			danger = true;
			brojac = 0;
			for(int j = 0 ; j < MainFrame.VISINA ; j++) {
				if(this.playingField[2][j] == newValue) {
					brojac++;
				}
				else {
					if(this.playingField[2][j] == 0) {
						dangerCheck[1] = j;
					}
					else {
						danger = false;
					}
				}
			}
			if(brojac == 2 && danger) {
				dangerCheck[0] = 2;
				return true;
			}
				
			//tri polja ista vertikalno
			danger = true;
			brojac = 0;
			for(int i = 0 ; i < MainFrame.VISINA ; i++) {
				if(this.playingField[i][0] == newValue) {
					brojac++;
				}
				else {
					if(this.playingField[i][0] == 0) {
						dangerCheck[0] = i;
					}
					else {
						danger = false;
					}
				}
			}
			if(brojac == 2 && danger) {
				dangerCheck[1] = 0;
				return true;
			}
			
			danger = true;
			brojac = 0;
			for(int i = 0 ; i < MainFrame.VISINA ; i++) {
				if(this.playingField[i][1] == newValue) {
					brojac++;
				}
				else {
					if(this.playingField[i][1] == 0) {
						dangerCheck[0] = i;
					}
					else {
						danger = false;
					}
				}
			}
			if(brojac == 2 && danger) {
				dangerCheck[1] = 1;
				return true;
			}
			
			danger = true;
			brojac = 0;
			for(int i = 0 ; i < MainFrame.VISINA ; i++) {
				if(this.playingField[i][2] == newValue) {
					brojac++;
				}
				else {
					if(this.playingField[i][2] == 0) {
						dangerCheck[0] = i;
					}
					else {
						danger = false;
					}
				}
			}
			if(brojac == 2 && danger) {
				dangerCheck[1] = 2;
				return true;
			}
				
			//tri polja dijagonalno
			danger = true;
			brojac = 0;
			for(int i = 0 ; i < MainFrame.VISINA ; i++) {
				for(int j = 0 ; j < MainFrame.SIRINA ; j++) {
					if(i == j) {
						if(this.playingField[i][j] == newValue) {
							brojac++;
						}
						else {
							if(this.playingField[i][j] == 0) {
								dangerCheck[0] = i;
								dangerCheck[1] = j;
							}
							else {
								danger = false;
							}
						}
					}
				}
			}
			if(brojac == 2 && danger) {
				return true;
			}
			
			danger = true;
			brojac = 0;
			for(int i = 0 ; i < MainFrame.VISINA ; i++) {
				for(int j = 0 ; j < MainFrame.SIRINA ; j++) {
					if(i + j == 2) {
						if(this.playingField[i][j] == newValue) {
							brojac++;
						}
						else {
							if(this.playingField[i][j] == 0) {
								dangerCheck[0] = i;
								dangerCheck[1] = j;
							}
							else {
								danger = false;
							}
						}
					}
				}
			}
			if(brojac == 2 && danger) {
				return true;
			}
			return false;

	}
	
	public void printBoard() {
		for(int i = 0 ; i < 3 ; i++) {
			for(int j = 0 ; j < 3 ; j++) {
				System.out.print(this.playingField[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
}

