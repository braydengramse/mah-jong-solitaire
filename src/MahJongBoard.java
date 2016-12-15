import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

import javax.swing.*;
import javax.swing.border.*;

public class MahJongBoard extends JPanel implements MouseListener {
	private MahJongModel mahJongModel;
	private MahJong mahJong;
	private Image backgroundImage = new ImageIcon(getClass().getResource("/images/dragon_bg.png")).getImage();
	private Color backgroundColor = new Color(238, 192, 31);
	
	private java.util.List<Tile> gameTiles;
	private java.util.List<TileModel> shuffledGameTiles;
	private RemovedTiles removedTiles;
	private TileModel first;
	private final int TILE_WIDTH = 50;
	private final int TILE_HEIGHT = 63;
	private final int LEFT_TILE_EDGE = 10;
	private final int BOTTOM_TILE_EDGE = 15;
	public boolean playSound = true;
	
	public MahJongBoard(long gameNumber, MahJong mahJong) {
		this.mahJong = mahJong;
		gameTiles = new ArrayList<Tile>();
		shuffledGameTiles = new ArrayList<TileModel>();
		removedTiles = new RemovedTiles();
		setLayout(null);
		populateGameTiles();
		Collections.shuffle(gameTiles, new Random(gameNumber));
		createTileModels();
		this.mahJongModel = new MahJongModel(shuffledGameTiles);
		for (int i = 585; i != 465; i -= 30) {
			for (int j = 0; j < 15; j++) {
				paintTile(i);
				i++;
			}
		}
		for (int i = 465; i != 345; i -= 30) {
			for (int j = 0; j < 15; j++) {
				paintTile(i);
				i++;
			}
		}
		for (int i = 345; i != 225; i -= 30) {
			for (int j = 0; j < 15; j++) {
				paintTile(i);
				i++;
			}
		}
		for (int i = 225; i != 105; i -= 30) {
			for (int j = 0; j < 15; j++) {
				paintTile(i);
				i++;
			}
		}
		for (int i = 105; i != -15; i -= 30) {
			for (int j = 0; j < 15; j++) {
				paintTile(i);
				i++;
			}
		}
		this.addMouseListener(this);
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(this.backgroundColor);
		g.fillRect(0, 0, 775, 529);
		g.drawImage(this.backgroundImage, 50, 43, this);
	}
	
	public void mouseClicked(MouseEvent e) {
		if (e.getComponent() instanceof Tile && e.getButton() == MouseEvent.BUTTON1) {
			Tile tile = (Tile) e.getComponent();
			int zOrder = getComponentZOrder(tile);
			int z = -1;
			int horizontalOffset = 0;
			int verticalOffset = 0;
			if (zOrder <= 143 && zOrder > 56) {
				z = 0;
			}
			else if (zOrder <= 56 && zOrder > 20) {
				z = 1;
			}
			else if (zOrder <= 20 && zOrder > 4) {
				z = 2;
			}
			else if (zOrder <= 4 && zOrder > 0) {
				z = 3;
			}
			else if (zOrder == 0) {
				z = 4;
				horizontalOffset += 25;
				verticalOffset += 25;
			}
			if (tile.getX() == 5 && tile.getY() == 232) {
				verticalOffset += 25;
			}
			int x = ((tile.getX() + horizontalOffset - 5) - (z * LEFT_TILE_EDGE)) / TILE_WIDTH;
			int y = ((tile.getY() + verticalOffset - 5) + (z * BOTTOM_TILE_EDGE)) / TILE_HEIGHT;
			if (this.mahJongModel.removable(x, y, z)) {
				if (this.first == null) {
					this.first = new TileModel(tile, x, y, z);
					tile.selected = true;
					tile.setBorder(new SelectedBorder());
				}
				else if (this.first.tile.equals(tile)) {
					this.first = null;
					tile.selected = false;
					tile.setBorder(null);
				}
				else if (this.first.tile.matches(tile)) {
					this.removedTiles.push(new TilePair(first, new TileModel (tile, x, y, z)));
					first.tile.setVisible(false);
					tile.setVisible(false);
					this.mahJongModel.removeTile(first.x, first.y, first.z);
					this.mahJongModel.removeTile(x, y, z);
					this.first.tile.selected = false;
					this.first = null;
					checkForWin();
					if(outOfMoves()) {
						JOptionPane.showMessageDialog(this, "There are no more available moves.", "No More Moves", JOptionPane.INFORMATION_MESSAGE);;
					}
				}
				else {
					this.first.tile.selected = false;
					this.first.tile.setBorder(null);
					this.first = new TileModel(tile, x, y, z);
					tile.selected = true;
					tile.setBorder(new SelectedBorder());
				}
				repaint();
			}
		}
	}
	
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	
	private void populateGameTiles() {
		char[] characterTiles = { '1', '2', '3', '4', '5', '6', '7', '8', '9', 'N', 'E', 'W', 'S', 'C', 'F' };
		char[] circleTiles = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		char[] bambooTiles = { 2, 3, 4, 5, 6, 7, 8, 9 };
		String[] seasonTiles = { "Spring", "Summer", "Fall", "Winter" };
		String[] flowerTiles = { "Chrysanthemum", "Orchid", "Plum", "Bamboo" };
		
		for (int i = 0; i < 4; i++) {
			for (char characterTile : characterTiles) {
				gameTiles.add(new CharacterTile(characterTile));
			}
			
			gameTiles.add(new WhiteDragonTile());
			
			for (int circleTile : circleTiles) {
				gameTiles.add(new CircleTile(circleTile));
			}
			
			gameTiles.add(new Bamboo1Tile());
			
			for (int bambooTile : bambooTiles) {
				gameTiles.add(new BambooTile(bambooTile));
			}
		}
		
		for (String seasonTile : seasonTiles) {
			gameTiles.add(new SeasonTile(seasonTile));
		}
		
		for (String flowerTile : flowerTiles) {
			gameTiles.add(new FlowerTile(flowerTile));
		}
	}
	
	private void createTileModels() {
		int gameTileCounter = 0;
		ArrayList<String> layer0NullPairs = new ArrayList<String>();
		ArrayList<String> layer1NonNullPairs = new ArrayList<String>();
		ArrayList<String> layer2NonNullPairs = new ArrayList<String>();
		ArrayList<String> layer3NonNullPairs = new ArrayList<String>();
		ArrayList<String> layer4NonNullPairs = new ArrayList<String>();
		
		layer0NullPairs.add("00");
		layer0NullPairs.add("130");
		layer0NullPairs.add("140");
		layer0NullPairs.add("01");
		layer0NullPairs.add("11");
		layer0NullPairs.add("21");
		layer0NullPairs.add("111");
		layer0NullPairs.add("121");
		layer0NullPairs.add("131");
		layer0NullPairs.add("141");
		layer0NullPairs.add("02");
		layer0NullPairs.add("12");
		layer0NullPairs.add("122");
		layer0NullPairs.add("132");
		layer0NullPairs.add("142");
		layer0NullPairs.add("03");
		layer0NullPairs.add("134");
		layer0NullPairs.add("144");
		layer0NullPairs.add("05");
		layer0NullPairs.add("15");
		layer0NullPairs.add("125");
		layer0NullPairs.add("135");
		layer0NullPairs.add("145");
		layer0NullPairs.add("06");
		layer0NullPairs.add("16");
		layer0NullPairs.add("26");
		layer0NullPairs.add("116");
		layer0NullPairs.add("126");
		layer0NullPairs.add("136");
		layer0NullPairs.add("146");
		layer0NullPairs.add("07");
		layer0NullPairs.add("137");
		layer0NullPairs.add("147");
		
		for (int i = 4; i < 10; i++) {
			for (int j = 1; j < 7; j++) {
				layer1NonNullPairs.add(String.valueOf(i) + String.valueOf(j));
			}
		}
		
		for (int i = 5; i < 9; i++) {
			for (int j = 2; j < 6; j++) {
				layer2NonNullPairs.add(String.valueOf(i) + String.valueOf(j));
			}
		}
		
		for (int i = 6; i < 8; i++) {
			for (int j = 3; j < 5; j++) {
				layer3NonNullPairs.add(String.valueOf(i) + String.valueOf(j));
			}
		}
		
		layer4NonNullPairs.add("74");
		
		// layer 0
		while(shuffledGameTiles.size() < 120) {
			for (int j = 0; j < 8; j++) {
				for (int k = 14; k >= 0; k--) {
					if (layer0NullPairs.contains(String.valueOf(k) + String.valueOf(j))) {
						shuffledGameTiles.add(new TileModel(null, k, j, 0));
					}
					else {
						shuffledGameTiles.add(new TileModel(gameTiles.get(gameTileCounter), k, j, 0));
						gameTileCounter++;
					}
				}
			}	
		}
		
		// layer 1
		while (shuffledGameTiles.size() < 240) {
			for (int j = 0; j < 8; j++) {
				for (int k = 14; k >= 0; k--) {
					if (layer1NonNullPairs.contains(String.valueOf(k) + String.valueOf(j))) {
						shuffledGameTiles.add(new TileModel(gameTiles.get(gameTileCounter), k, j, 1));
						gameTileCounter++;
					}
					else {
						shuffledGameTiles.add(new TileModel(null, k, j, 1));
					}
				}
			}
		}
		
		// layer 2
		while (shuffledGameTiles.size() < 360) {
			for (int j = 0; j < 8; j++) {
				for (int k = 14; k >= 0; k--) {
					if (layer2NonNullPairs.contains(String.valueOf(k) + String.valueOf(j))) {
						shuffledGameTiles.add(new TileModel(gameTiles.get(gameTileCounter), k, j, 2));
						gameTileCounter++;
					}
					else {
						shuffledGameTiles.add(new TileModel(null, k, j, 2));
					}
				}
			}
		}
		
		// layer 3
		while (shuffledGameTiles.size() < 480) {
			for (int j = 0; j < 8; j++) {
				for (int k = 14; k >= 0; k--) {
					if (layer3NonNullPairs.contains(String.valueOf(k) + String.valueOf(j))) {
						shuffledGameTiles.add(new TileModel(gameTiles.get(gameTileCounter), k, j, 3));
						gameTileCounter++;
					}
					else {
						shuffledGameTiles.add(new TileModel(null, k, j, 3));
					}
				}
			}
		}
		
		// layer 4
		while (shuffledGameTiles.size() < 600) {
			for (int j = 0; j < 8; j++) {
				for (int k = 14; k >= 0; k--) {
					if (layer4NonNullPairs.contains(String.valueOf(k) + String.valueOf(j))) {
						shuffledGameTiles.add(new TileModel(gameTiles.get(gameTileCounter), k, j, 4));
						gameTileCounter++;
					}
					else {
						shuffledGameTiles.add(new TileModel(null, k, j, 4));
					}
				}
			}
		}
	}
	
	public void paintTile(int i) {
		TileModel t = shuffledGameTiles.get(i);
		if (t.tile != null && t.tile.visible == true) {
			int horizontal = 5 + ((t.x * TILE_WIDTH) + (t.z * LEFT_TILE_EDGE));
			int vertical = 5 + (t.y * TILE_HEIGHT - (t.z * BOTTOM_TILE_EDGE));
			
			if (t.x == 7 && t.y == 4 && t.z == 4) {
				horizontal -= 25;
			}

			if ((t.x == 0 && t.y == 4 && t.z == 0) ||
				(t.x == 7 && t.y == 4 && t.z == 4)) {
				vertical -= 25;
			}
			
			if ((t.x == 13 && t.y == 3 && t.z == 0) ||
				(t.x == 14 && t.y == 3 && t.z == 0)) {
				vertical += 25;
			}
			t.tile.addMouseListener(this);
			t.tile.setLocation(horizontal, vertical); 
			add(t.tile, -1);
		}
	}
	
	public void openRemovedTiles() {
		if(this.removedTiles.empty()) {
			JOptionPane.showMessageDialog(this, "No tiles have been removed", "Removed Tiles Failed", JOptionPane.ERROR_MESSAGE);
		}
		else {
			RemovedTilesDialog removedTilesDialog = new RemovedTilesDialog(mahJong, this.removedTiles);
		}
	}
	
	public void undo() {
		if (this.removedTiles.empty()) {
			JOptionPane.showMessageDialog(this, "No moves to undo", "Undo Failed", JOptionPane.ERROR_MESSAGE);
		}
		else {
			TilePair tilePair = this.removedTiles.pop();
			mahJongModel.addTileBack(tilePair.first.x, tilePair.first.y, tilePair.first.z);
			mahJongModel.addTileBack(tilePair.second.x, tilePair.second.y, tilePair.second.z);
			tilePair.first.tile.setBorder(null);
			tilePair.first.tile.setVisible(true);
			tilePair.second.tile.setVisible(true);
		}
	}
	
	public void restart() {
		while(!this.removedTiles.empty()) {
			TilePair tilePair = this.removedTiles.pop();
			mahJongModel.addTileBack(tilePair.first.x, tilePair.first.y, tilePair.first.z);
			mahJongModel.addTileBack(tilePair.second.x, tilePair.second.y, tilePair.second.z);
			tilePair.first.tile.setBorder(null);
			tilePair.first.tile.setVisible(true);
			tilePair.second.tile.setVisible(true);
		}
	}
	
	public boolean hasRemovedTiles() {
		return !this.removedTiles.empty();
	}
	
	private void checkForWin() {
		if (this.removedTiles.size() == 72) {
			JFrame		frame = new JFrame();
			Fireworks	fw = new Fireworks();
			if (!playSound) {
				fw.setSound(false);
			}
			frame.setTitle("YOU WIN!!!!");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(791, 591);
			frame.add(fw.getPanel());
			frame.setVisible(true);

			fw.setExplosions(0, 1000);
			fw.fire();


			try
			{
				Thread.sleep(10000);
				fw.stop();
			}
			catch (InterruptedException ie) {}
		}
	}
	
	private boolean outOfMoves() {
		ArrayList<TileModel> removableTiles = new ArrayList<TileModel>();
		for (TileLayer layer : mahJongModel) {
			for (TileRow row : layer) {
				for (TileModel tileModel : row) {
					if (tileModel.tile != null && tileModel.tile.visible == true && this.mahJongModel.removable(tileModel.x, tileModel.y, tileModel.z)) {
						removableTiles.add(tileModel);
					}
				}
			}
		}
		for (int i = 0; i < removableTiles.size(); i++) {
			for (int j = 1; j < removableTiles.size(); j++) {
				if (removableTiles.get(i).tile.matches(removableTiles.get(j).tile) && i != j) {
					return false;
				}
			}
		}
		return true;
	}
}