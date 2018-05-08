package TicTacToe;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class DifficultyPanel extends JPanel {
	private JButton ok;
	private JToggleButton easy;
	private JToggleButton medium;
	private JToggleButton hard;
	private JLabel label;
	private ButtonGroup button;
	private MainFrame frame;

	public DifficultyPanel(MainFrame frame) {
		this.frame = frame;
		this.setLayout(new BorderLayout());
		
		
		//label
		JPanel labelPanel = new JPanel();
		labelPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		label = new JLabel("Choose game difficulty:");
		labelPanel.add(label);
		
		this.add(labelPanel,BorderLayout.NORTH);
		
		//buttons
		JPanel buttons = new JPanel();
		buttons.setLayout(new FlowLayout(FlowLayout.CENTER));
		button = new ButtonGroup();
		
		easy = new JToggleButton("Easy");
		medium = new JToggleButton("Medium");
		hard = new JToggleButton("Hard");
		
		button.add(easy);
		button.add(medium);
		button.add(hard);
		
		buttons.add(easy);
		buttons.add(medium);
		buttons.add(hard);
		
		this.add(buttons, BorderLayout.CENTER);
		
		easy.setSelected(true);
		
		//ok button
		
		JPanel okPanel = new JPanel();
		okPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		ok = new JButton("OK");
		okPanel.add(ok);
		
		this.add(okPanel,BorderLayout.SOUTH);
		
		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.chooseDifficulty.setVisible(false);
			}
			
		});
		
	}

	
	
	public JButton getOk() {
		return ok;
	}

	public JToggleButton getEasy() {
		return easy;
	}

	public JToggleButton getMedium() {
		return medium;
	}

	public JToggleButton getHard() {
		return hard;
	}

	public JLabel getLabel() {
		return label;
	}

	public ButtonGroup getButton() {
		return button;
	}
	
}
