package TicTacToe;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;

public class OnePlayerThread extends Thread {
	private MainFrame frame;
	private int winner;
	private DifficultyPanel panel;

	public OnePlayerThread(MainFrame frame,DifficultyPanel panel) {
		this.panel = panel;
		this.frame = frame;
		this.winner = 0;
	}
	
	
	public void run() {
		Random random = new Random();
		int i,j;
		int[] polje;
		frame.newGame.setEnabled(false);
		while(!(frame.board.isEnd())) {
			if(!(frame.board.isTurn())) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				//Computer output algoritam
				if(panel.getEasy().isSelected()) {
					do {
						 i = random.nextInt(3);
						 j = random.nextInt(3); 
					}while(frame.board.getPlayingField()[i][j] != 0);
					
				}
				else if(panel.getMedium().isSelected()) {
					int randomizer = random.nextInt(10)+1;
					if(randomizer%2 == 0) {
						if(frame.newGamePanel.isTurn()) {
							polje = frame.board.getBestMove(2);
						}
						else {
							polje = frame.board.getBestMove(1);
						}
						
						if(polje == null) {
							do {
								 i = random.nextInt(3);
								 j = random.nextInt(3); 
							}while(frame.board.getPlayingField()[i][j] != 0);
						}
						else {
							i = polje[0];
							j = polje[1];
						}
					}
					else {
						do {
							 i = random.nextInt(3);
							 j = random.nextInt(3); 
						}while(frame.board.getPlayingField()[i][j] != 0);
					}
				}
				else{
					int randomizer = random.nextInt(99)+1;
					if(randomizer%23 == 0) {
						do {
							 i = random.nextInt(3);
							 j = random.nextInt(3); 
						}while(frame.board.getPlayingField()[i][j] != 0);
					}
					else {
						if(frame.newGamePanel.isTurn()) {
							polje = frame.board.getBestMove(2);
						}
						else {
							polje = frame.board.getBestMove(1);
						}
						
										
						if(polje == null) {
							do {
								 i = random.nextInt(3);
								 j = random.nextInt(3); 
							}while(frame.board.getPlayingField()[i][j] != 0);
						}
						else {
							i = polje[0];
							j = polje[1];
						}
					}
				}
				//---------------------------------------------------
				
				
				if(frame.newGamePanel.isTurn()) {
					frame.board.setCell(i, j, 2);
					frame.buttons[i][j].add(frame.labelKrizic);
					frame.buttons[i][j].setSelected(true);
					frame.newGamePanel.setTurn(false);
				}
				else {
					frame.board.setCell(i, j, 1);
					frame.buttons[i][j].add(frame.labelKruzic);
					frame.buttons[i][j].setSelected(true);
					frame.newGamePanel.setTurn(true);
				}
				try {
					pokreniAudio();
				} catch (UnsupportedAudioFileException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (LineUnavailableException e) {
					e.printStackTrace();
				}
				frame.board.setTurn(true);
				frame.buttonGrid.revalidate();
				frame.enableMove();
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
		frame.newGame.setEnabled(true);
	}
	
	private void pokreniAudio() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		String name = "button-10.wav";
		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(name).getAbsoluteFile());
		Clip clip = AudioSystem.getClip();
		clip.open(audioInputStream);
		clip.start();
	}
}
	
