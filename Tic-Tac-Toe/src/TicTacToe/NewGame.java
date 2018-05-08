package TicTacToe;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class NewGame extends JPanel {
	private JToggleButton onePlayer;
	private JToggleButton twoPlayer;
	private ButtonGroup playerGroup;
	private ButtonGroup simbolGroup;
	private JToggleButton krizic;
	private JToggleButton kruzic;
	private JButton start;
	private ImageIcon krizicIcon = new ImageIcon("krizic.jpg");
	private ImageIcon kruzicIcon = new ImageIcon("kruzic.jpg");
	private MainFrame frame;
	private boolean turn = true;

	public NewGame(MainFrame frame) {
		this.frame = frame;
		this.setLayout(new BorderLayout());
			
		//label
		JPanel gameMode = new JPanel();
		gameMode.setLayout(new BorderLayout());
		
		JPanel labelPanel = new JPanel();
		labelPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		labelPanel.add(new JLabel("Choose game mode:"));
		gameMode.add(labelPanel,BorderLayout.NORTH);
		
		//GAME MODE CHOOSING
		onePlayer = new JToggleButton("VS COMPUTER");
		twoPlayer = new JToggleButton("VS PLAYER");
		playerGroup = new ButtonGroup();
		
		playerGroup.add(onePlayer);
		playerGroup.add(twoPlayer);
		twoPlayer.setSelected(true);
		
		JPanel buttons = new JPanel();
		buttons.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		buttons.add(twoPlayer);
		buttons.add(onePlayer);
		
		
		gameMode.add(buttons, BorderLayout.CENTER);
		
		this.add(gameMode,BorderLayout.NORTH);
		
		//SIMBOL CHOOSING 
		JPanel simbolChoosing = new JPanel();
		simbolChoosing.setLayout(new BorderLayout());
		
		JPanel labelSimbol = new JPanel();
		labelSimbol.setLayout(new FlowLayout(FlowLayout.CENTER));
		labelSimbol.add(new JLabel("Choose your simbol:"));
		
		simbolChoosing.add(labelSimbol, BorderLayout.NORTH);
		
		JPanel simbols = new JPanel();
		simbols.setLayout(new FlowLayout(FlowLayout.CENTER));
		simbolGroup = new ButtonGroup();
		
		krizic = new JToggleButton();
		kruzic = new JToggleButton();
		krizic.setSelected(true);
		
		krizic.setIcon(krizicIcon);
		kruzic.setIcon(kruzicIcon);
		
		simbolGroup.add(krizic);
		simbolGroup.add(kruzic);
		
		simbols.add(krizic);
		simbols.add(kruzic);
		
		simbolChoosing.add(simbols,BorderLayout.CENTER);
		
		this.add(simbolChoosing,BorderLayout.CENTER);
		
		
		//start button
		start = new JButton("Start");
		JPanel startButton = new JPanel();
		startButton.setLayout(new FlowLayout(FlowLayout.CENTER));
		startButton.add(start);
		
		this.add(startButton, BorderLayout.SOUTH);
		
		
		//actions
		start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				for(int i = 0 ; i < frame.SIRINA ; i++) {
					for(int j = 0 ; j < frame.VISINA ; j++) {
						frame.buttons[i][j].remove(frame.labelKruzic);
						frame.buttons[i][j].remove(frame.labelKrizic);
						frame.buttons[i][j].setSelected(false);
						frame.buttons[i][j].setEnabled(true);
						frame.board.setCell(i, j, 0);
					}
				}
				setTurnMethod();
				
				if(onePlayer.isSelected()) {
					OnePlayerThread game = new OnePlayerThread(frame,frame.difficultyPanel);
					game.start();
				}
				else if(twoPlayer.isSelected()) {
					TwoPlayerThread game = new TwoPlayerThread(frame);
					game.start();
				}
			
				frame.buttonGrid.revalidate();
				frame.newGameFrame.setVisible(false);
			}
			
		});
		
	}
	//set turn
	private void setTurnMethod() {
		if(krizic.isSelected()) {
			turn = true;
		}
		else {
			turn = false;
		}
		frame.board.setTurn(true);
	}
	
	//getters
	public JToggleButton getOnePlayer() {
		return onePlayer;
	}
	public JToggleButton getTwoPlayer() {
		return twoPlayer;
	}
	public JButton getStart() {
		return start;
	}
	public boolean isTurn() {
		return turn;
	}
	
	//setters
	public void setTurn(boolean turn) {
		this.turn = turn;
	}
}
