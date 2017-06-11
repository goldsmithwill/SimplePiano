package piano;

import java.awt.Color;

import javax.swing.*;
import listeners.*;

public class SimplePiano {
	protected static JButton whiteKeys[] = new JButton[8];
	protected static JButton blackKeys[] = new JButton[7];

	public static void main(String[] args) {
		// only needed for mac OS to set button color
		try {
			UIManager.setLookAndFeel(UIManager
					.getCrossPlatformLookAndFeelClassName());
		} catch (Exception ev) {
			ev.printStackTrace();
		}
		int x = 0;
		JFrame pianoFrame = new JFrame();
		pianoFrame.setSize(1950, 500);
		pianoFrame.setVisible(true);
		pianoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// this panel will hold all of the keys
		JPanel keyPanel = new JPanel();
		// keyPanel.setVisible(false);
		keyPanel.setSize(pianoFrame.getWidth(), pianoFrame.getHeight());
		keyPanel.setBackground(Color.WHITE);
		// adding the keyPanel
		pianoFrame.getContentPane().add(keyPanel);
		// a compact way to set both key arrays
		for (int i = 0; i < whiteKeys.length; i++) {
			whiteKeys[i] = new JButton();
		}
		for (int j = 0; j < blackKeys.length; j++) {
			blackKeys[j] = new JButton();
		}
		for (int k = 0; k < 8; k++) {
			whiteKeys[k].setBounds(x, 0, 175, keyPanel.getHeight());
			whiteKeys[k].setBackground(Color.WHITE);
			whiteKeys[k].addActionListener(new WhiteKeys());
			keyPanel.add(whiteKeys[k]);
			x += 255;

		}
		// setting x so that it can be used for the black keys
		x = 175;
		for (int l = 0; l < blackKeys.length; l++) {

			blackKeys[l].setBounds(x, 0, 80, keyPanel.getHeight());
			blackKeys[l].setBackground(Color.BLACK);
			blackKeys[l].addActionListener(new BlackKeys());
			keyPanel.add(blackKeys[l]);
			x += 255;
		}
	}
}
