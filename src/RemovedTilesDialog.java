import java.awt.*;
import java.util.*;
import javax.swing.*;

public class RemovedTilesDialog extends JDialog {
	public ArrayList<TilePair> removedTiles;
	private Color backgroundColor = new Color(238, 192, 31);
	public RemovedTilesDialog(Frame owner, Stack<TilePair> removedTiles) {
		super(owner, "Removed Tiles", true);
		this.removedTiles = new ArrayList<TilePair>(removedTiles);
		this.setSize(617, 138);
		this.setLocation(87, 234);
		this.add(this.createScrollPane());
		this.setVisible(true);
	}
	
	private JScrollPane createScrollPane() {
		JScrollPane jScrollPane = new JScrollPane(new RemovedTilesPanel(), JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		jScrollPane.setBounds(0, 0, 0, 0);
		return jScrollPane;
	}
	
	public class RemovedTilesPanel extends JPanel {
		public RemovedTilesPanel() {
			setLayout(new BorderLayout());
			
			for (int i = 0; i < removedTiles.size(); i ++) {
				TilePair tilePair = removedTiles.get(i);
				String firstTileString = tilePair.first.tile.toString();
				String secondTileString = tilePair.second.tile.toString();
				if (tilePair.first.tile.getClass() == new CircleTile(1).getClass()) {
					CircleTile firstTile = new CircleTile(Character.getNumericValue(firstTileString.charAt(firstTileString.length() - 1)));
					firstTile.setLocation(i * 150, 0);
					add(firstTile);
				}
				else if (tilePair.first.tile.getClass() == new BambooTile(2).getClass()) {
					BambooTile firstTile = new BambooTile(Character.getNumericValue(firstTileString.charAt(firstTileString.length() - 1)));
					firstTile.setLocation(i * 150, 0);
					add(firstTile);
				}
				else if (tilePair.first.tile.getClass() == new CharacterTile('1').getClass()) {
					if (firstTileString.substring(0, 9).equals("Character")) {
						CharacterTile firstTile = new CharacterTile(firstTileString.charAt(firstTileString.length() - 1));
						firstTile.setLocation(i * 150, 0);
						add(firstTile);
					}
					else if (firstTileString.charAt(0) == 'R') {
						CharacterTile firstTile = new CharacterTile('C');
						firstTile.setLocation(i * 150, 0);
						add(firstTile);
					}
					else if (firstTileString.charAt(0) == 'G') {
						CharacterTile firstTile = new CharacterTile('F');
						firstTile.setLocation(i * 150, 0);
						add(firstTile);
					}
					else {
						CharacterTile firstTile = new CharacterTile(firstTileString.charAt(0));
						firstTile.setLocation(i * 150, 0);
						add(firstTile);
					}
				}
				else if (tilePair.first.tile.getClass() == new WhiteDragonTile().getClass()) {
					WhiteDragonTile firstTile = new WhiteDragonTile();
					firstTile.setLocation(i * 150, 0);
					add(firstTile);
				}
				else if (tilePair.first.tile.getClass() == new SeasonTile("Fall").getClass()) {
					SeasonTile firstTile = new SeasonTile(firstTileString);
					firstTile.setLocation(i * 150, 0);
					add(firstTile);
				}
				else if (tilePair.first.tile.getClass() == new FlowerTile("Plum").getClass()) {
					FlowerTile firstTile = new FlowerTile(firstTileString);
					firstTile.setLocation(i * 150, 0);
					add(firstTile);
				}
				else if (tilePair.first.tile.getClass() == new Bamboo1Tile().getClass()) {
					Bamboo1Tile firstTile = new Bamboo1Tile();
					firstTile.setLocation(i * 150, 0);
					add(firstTile);
				}
				
				if (tilePair.second.tile.getClass() == new CircleTile(1).getClass()) {
					CircleTile secondTile = new CircleTile(Character.getNumericValue(secondTileString.charAt(secondTileString.length() - 1)));
					secondTile.setLocation((i * 150) + 70, 0);
					add(secondTile);
				}
				else if (tilePair.second.tile.getClass() == new BambooTile(2).getClass()) {
					BambooTile secondTile = new BambooTile(Character.getNumericValue(secondTileString.charAt(secondTileString.length() - 1)));
					secondTile.setLocation((i * 150) + 70, 0);
					add(secondTile);
				}
				else if (tilePair.second.tile.getClass() == new CharacterTile('1').getClass()) {
					if (secondTileString.substring(0, 9).equals("Character")) {
						CharacterTile secondTile = new CharacterTile(secondTileString.charAt(secondTileString.length() - 1));
						secondTile.setLocation((i * 150) + 70, 0);
						add(secondTile);
					}
					else if (secondTileString.charAt(0) == 'R') {
						CharacterTile secondTile = new CharacterTile('C');
						secondTile.setLocation((i * 150) + 70, 0);
						add(secondTile);
					}
					else if (secondTileString.charAt(0) == 'G') {
						CharacterTile secondTile = new CharacterTile('F');
						secondTile.setLocation((i * 150) + 70, 0);
						add(secondTile);
					}
					else {
						CharacterTile secondTile = new CharacterTile(secondTileString.charAt(0));
						secondTile.setLocation((i * 150) + 70, 0);
						add(secondTile);
					}
				}
				else if (tilePair.second.tile.getClass() == new WhiteDragonTile().getClass()) {
					WhiteDragonTile secondTile = new WhiteDragonTile();
					secondTile.setLocation((i * 150) + 70, 0);
					add(secondTile);
				}
				else if (tilePair.second.tile.getClass() == new SeasonTile("Fall").getClass()) {
					SeasonTile secondTile = new SeasonTile(secondTileString);
					secondTile.setLocation((i * 150) + 70, 0);
					add(secondTile);
				}
				else if (tilePair.second.tile.getClass() == new FlowerTile("Plum").getClass()) {
					FlowerTile secondTile = new FlowerTile(secondTileString);
					secondTile.setLocation((i * 150) + 70, 0);
					add(secondTile);
				}
				else if (tilePair.second.tile.getClass() == new Bamboo1Tile().getClass()) {
					Bamboo1Tile secondTile = new Bamboo1Tile();
					secondTile.setLocation((i * 150) + 70, 0);
					add(secondTile);
				}
			}
			add(new JLabel());
			setVisible(true);
		}
		
		public Dimension getPreferredSize() {
			return new Dimension((removedTiles.size() * 150), 83);
		}
		
		public void paintComponent(Graphics g) {
			g.setColor(backgroundColor);
			g.fillRect(0, 0, removedTiles.size() * 150 > 600 ? removedTiles.size() * 150 : 600, 83);
		}
	}
}