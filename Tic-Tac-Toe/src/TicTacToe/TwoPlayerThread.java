package TicTacToe;

import javax.swing.JOptionPane;

public class TwoPlayerThread extends Thread {
	private MainFrame frame;
	private int winner; 

	public TwoPlayerThread(MainFrame frame) {
		this.frame = frame;
		this.winner = 0;
	}
	
	@Override
	public void run() {
		while(!(frame.board.isEnd())) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		winner = this.frame.board.getVictorian();
		
		if(winner == 1) {
			JOptionPane.showMessageDialog(frame,"The winner is CIRCLE!");
		}
		else if(winner == 2) {
			JOptionPane.showMessageDialog(frame,"The winner is CROSS!");
		}
		else {
			JOptionPane.showMessageDialog(frame,"It's a TIE!");
		}
		frame.disableField();
	}
	
	

}
