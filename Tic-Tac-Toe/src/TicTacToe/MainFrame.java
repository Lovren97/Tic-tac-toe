package TicTacToe;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 * @author Ivan Lovrencic
 *
 * MainFrame is the main window of TIC-TAC-TOE. Here I am implementing all
 * my panels and threads.
 *
 */


public class MainFrame extends JFrame {
	protected JToggleButton[][] buttons;
	protected final static int SIRINA = 3;
	protected final static int VISINA = 3;
	private JToolBar toolBar;
	protected Board board;
	protected static ImageIcon krizic = new ImageIcon("X.jpg");
	protected static ImageIcon kruzic = new ImageIcon("images.png");
	protected JLabel labelKrizic = new JLabel(krizic);
	protected JLabel labelKruzic = new JLabel(kruzic); 
	protected NewGame newGamePanel;
	protected JPanel buttonGrid;
	protected JFrame newGameFrame;
	protected JButton newGame;
	protected JFrame chooseDifficulty;
	protected DifficultyPanel difficultyPanel;

	public MainFrame() {
		//main frame setup
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Tic-Tac-Toe");
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		this.add(panel);
		
		//set difficulty frame setup
		difficultyPanel = new DifficultyPanel(this);
		chooseDifficulty = new JFrame();
		chooseDifficulty.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		chooseDifficulty.setBounds(100,100,500,400);
		chooseDifficulty.add(difficultyPanel);
		chooseDifficulty.pack();
		
		//new Game frame setup
		newGamePanel = new NewGame(this);
		newGameFrame = new JFrame("Game menu");	
		newGameFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		newGameFrame.setBounds(100,100,500,400);
		newGameFrame.add(newGamePanel);
		newGameFrame.pack();
		
		//toolbar setup
		toolBar = new JToolBar();
		panel.add(toolBar,BorderLayout.NORTH);
		
		newGame = new JButton("New Game");
		toolBar.add(newGame);
		
		JButton help = new JButton("Help");
		toolBar.add(help);
		
		//board setup
		buttonGrid = new JPanel();
		buttonGrid.setLayout(new GridLayout(3,3));
		this.add(buttonGrid,BorderLayout.SOUTH);
		board = new Board();
		
		//buttons setup
		buttons = new JToggleButton[SIRINA][VISINA];
		Integer actionCommand;
		for(int i = 0 ; i < SIRINA ; i++) {
			for(int j = 0 ; j < VISINA ; j++) {
				actionCommand = i+j;
				JToggleButton button = new JToggleButton();
				board.setCell(i,j,0);
				button.setActionCommand(actionCommand.toString());
				button.setPreferredSize(new Dimension(200,200));
				buttons[i][j] = button;
				buttonGrid.add(button);
				button.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						JToggleButton button = (JToggleButton)e.getSource();
						if(button.isSelected()) {
							button.setEnabled(false);
							for(int i = 0 ; i < SIRINA ; i++) 
								for(int j = 0 ; j < VISINA ; j++) 
									if(button.equals(buttons[i][j])) {
										if(newGamePanel.getTwoPlayer().isSelected()) {
											if(newGamePanel.isTurn()) {
												board.setCell(i, j, 2);
												button.add(labelKrizic);
												buttonGrid.revalidate();
												newGamePanel.setTurn(false);
											}
											else {
												board.setCell(i, j, 1);
												button.add(labelKruzic);
												buttonGrid.revalidate();
												newGamePanel.setTurn(true);
											}
										}
										else if(newGamePanel.getOnePlayer().isSelected()) {
											if(board.isTurn()) {
												if(newGamePanel.isTurn()) {
													board.setCell(i, j, 2);
													button.add(labelKrizic);
													buttonGrid.revalidate();
													newGamePanel.setTurn(false);
												}
												else {
													board.setCell(i, j, 1);
													button.add(labelKruzic);
													buttonGrid.revalidate();
													newGamePanel.setTurn(true);
												}
												board.setTurn(false);
												MainFrame.this.disableMove();
											}
										}
									}
									try {
										pokreniAudio();
									} catch (UnsupportedAudioFileException | IOException
											| LineUnavailableException e1) {
										e1.printStackTrace();
									}
						}
						
					}
				});
			}
			
			
			//actions setup
			
			newGame.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					MainFrame.this.enableField();
					if(newGameFrame.isVisible()) {
						newGameFrame.setVisible(false);
					}
					else {
						newGameFrame.setVisible(true);
					}
				}
				
			});
			
			help.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(MainFrame.this,"Welcome to TIC-TAC-TOE. Start the game by pressing NEW GAME button in left corner.");
				}
				
			});
			
			newGamePanel.getOnePlayer().addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if(chooseDifficulty.isVisible()) {
						chooseDifficulty.setVisible(false);
					}
					else {
						chooseDifficulty.setVisible(true);
					}
				}
				
			});
		}
		
		disableField();
		
	}
	
	private void pokreniAudio() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		String name = "button-10.wav";
		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(name).getAbsoluteFile());
		Clip clip = AudioSystem.getClip();
		clip.open(audioInputStream);
		clip.start();
	}
	
	protected void disableField() {
		for(int i = 0 ; i < MainFrame.SIRINA ; i++) {
			for(int j = 0 ; j < MainFrame.VISINA ; j++) {
				this.buttons[i][j].remove(this.labelKruzic);
				this.buttons[i][j].remove(this.labelKrizic);
				buttons[i][j].setSelected(false);
				buttons[i][j].setEnabled(false);
			}
		}
	}
	
	protected void enableField() {
		for(int i = 0 ; i < MainFrame.SIRINA ; i++) {
			for(int j = 0 ; j < MainFrame.VISINA ; j++) {
				buttons[i][j].setEnabled(true);
				buttons[i][j].setSelected(false);
				this.buttons[i][j].remove(this.labelKruzic);
				this.buttons[i][j].remove(this.labelKrizic);
				this.board.setCell(i,j,0);
			}
		}
	}
	
	protected void disableMove() {
		for(int i = 0 ; i < MainFrame.SIRINA ; i++) {
			for(int j = 0 ; j < MainFrame.VISINA ; j++) {
				buttons[i][j].setEnabled(false);
				buttonGrid.revalidate();
			}
		}
	}
	
	protected void enableMove() {
		for(int i = 0 ; i < MainFrame.SIRINA ; i++) {
			for(int j = 0 ; j < MainFrame.VISINA ; j++) {
				if(board.getPlayingField()[i][j] == 0) {
					buttons[i][j].setEnabled(true);
				}
			}
		}
	}

	public static void main(String[] args) {
		try 
	    { 
	        UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); 
	    } 
	    catch(Exception e){ 
	    }
		SwingUtilities.invokeLater(()->{
			MainFrame frame = new MainFrame();
			frame.pack();
			frame.setVisible(true);
		});
	}

}
