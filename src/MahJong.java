import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MahJong extends JFrame {
	private Dimension screenSize = new Dimension(791, 591);
	public MahJongBoard mahJongBoard;
	public static MahJong mahJong;
	public long gameNumber;
	
	public MahJong() {
		gameNumber = System.currentTimeMillis() % 1000000;
		setTitle("Mah Jong - Game Number: " + gameNumber);
		mahJongBoard = new MahJongBoard(gameNumber, mahJong);
		setSize(screenSize);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		add(mahJongBoard);
		setJMenuBar(this.createMenu());
		setVisible(true);
	}
	
	public static void main(String[] args) {
		mahJong = new MahJong();
	}
	
	private JMenuBar createMenu() {
		JMenuBar mahJongMenuBar = new JMenuBar();
		JMenu gameMenu = new JMenu("Game");
		gameMenu.setMnemonic('G');
		mahJongMenuBar.add(gameMenu);

		JMenuItem playMenuItem = new JMenuItem("Play", 'P');
		gameMenu.add(playMenuItem);
		playMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!mahJongBoard.hasRemovedTiles() || JOptionPane.showConfirmDialog(mahJong, "If you start a new game, your progress will be lost. Do you want to continue?", "New Game", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					Container container = mahJong.getContentPane();
					container.removeAll();
					mahJongBoard = null;
					gameNumber = System.currentTimeMillis() % 1000000;
					mahJong.setTitle("Mah Jong - Game Number: " + gameNumber);
					mahJongBoard = new MahJongBoard(gameNumber, mahJong);
					container.add(mahJongBoard);
					validate();
				}
			}
		});
		
		JMenuItem restartMenuItem = new JMenuItem("Restart", 'R');
		gameMenu.add(restartMenuItem);
		restartMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mahJongBoard.restart();
			}
		});
		
		JMenuItem numberedMenuItem = new JMenuItem("Numbered", 'N');
		gameMenu.add(numberedMenuItem);
		numberedMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					long userGameNumber = Long.valueOf(JOptionPane.showInputDialog(mahJong, "Enter game number", "Game Number", JOptionPane.PLAIN_MESSAGE));
					Container container = mahJong.getContentPane();
					container.removeAll();
					mahJongBoard = null;
					mahJong.setTitle("Mah Jong - Game Number: " + userGameNumber);
					mahJongBoard = new MahJongBoard(userGameNumber, mahJong);
					container.add(mahJongBoard);
					validate();
				}
				catch (Exception exception) {
					JOptionPane.showMessageDialog(mahJong, "Sorry, that is not a valid game number.", "Invalid Game Number", JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
		});
		
		JMenu soundMenu = new JMenu("Sound");
		soundMenu.setMnemonic('S');
		mahJongMenuBar.add(soundMenu);
		
		JMenuItem onMenuItem = new JMenuItem("On", 'O');
		soundMenu.add(onMenuItem);
		onMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mahJongBoard.playSound = true;
			}
		});
		
		JMenuItem offMenuItem = new JMenuItem("Off", 'f');
		soundMenu.add(offMenuItem);
		offMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mahJongBoard.playSound = false;
			}
		});
		
		JMenu moveMenu = new JMenu("Move");
		moveMenu.setMnemonic('M');
		mahJongMenuBar.add(moveMenu);
		
		JMenuItem removedTilesMenuItem = new JMenuItem("Removed Tiles", 'R');
		moveMenu.add(removedTilesMenuItem );
		removedTilesMenuItem .addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mahJongBoard.openRemovedTiles();
			}
		});
		
		JMenuItem undoMenuItem = new JMenuItem("Undo", 'U');
		moveMenu.add(undoMenuItem);
		undoMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mahJongBoard.undo();
			}
		});
		
		JMenu helpMenu = new JMenu("Help");
		helpMenu.setMnemonic('H');
		mahJongMenuBar.add(helpMenu);
		
		JMenuItem operationMenuItem = new JMenuItem("Operation", 'O');
		helpMenu.add(operationMenuItem);
		operationMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Help("/help/operation.html", "Operation").display();
			}
		});
		
		JMenuItem gameRulesMenuItem = new JMenuItem("Game Rules", 'G');
		helpMenu.add(gameRulesMenuItem);
		gameRulesMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Help("/help/game-rules.html", "Game Rules").display();
			}
		});
		return mahJongMenuBar;
	}
}