import java.util.*;

public class MahJongModel extends ArrayList<TileLayer>{
	public MahJongModel(List<TileModel> tiles) {
		List<TileModel> layer0 = tiles.subList(0, 120);
		List<TileModel> layer1 = tiles.subList(120, 240);
		List<TileModel> layer2 = tiles.subList(240, 360);
		List<TileModel> layer3 = tiles.subList(360, 480);
		List<TileModel> layer4 = tiles.subList(480, 600);
		
		this.add(new TileLayer(layer0));
		this.add(new TileLayer(layer1));
		this.add(new TileLayer(layer2));
		this.add(new TileLayer(layer3));
		this.add(new TileLayer(layer4));
	}
	
	public boolean removable(int x, int y, int z) {
		TileModel firstTile = this.get(z).get(y).getFirstTile();
		TileModel lastTile = this.get(z).get(y).getLastTile();
		TileModel selectedTile = this.get(z).get(y).get(x);
		TileModel leftEdgeTile = this.get(0).get(4).get(0);
		TileModel outerRightEdgeTile = this.get(0).get(3).get(14);
		TileModel innerRightEdgeTile = this.get(0).get(3).get(13);
		TileModel topTile = this.get(4).get(4).get(7);
		
		if (x == 1 && y == 3 && z == 0 && leftEdgeTile.tile.visible) {
			if (selectedTile.equals(lastTile)){
				return true;
			}
			return false;
		}
		if (x == 12 && y == 4 && z == 0 && (outerRightEdgeTile.tile.visible || innerRightEdgeTile.tile.visible)) {
			if (selectedTile.equals(firstTile)) {
				return true;
			}
			return false;
		}
		if (topTile.tile.visible && ((x == 6 && y == 4 && z == 3) || (x == 6 && y == 3 && z == 3) || (x == 7 && y == 3 && z == 3))) {
			return false;
		}
		if (z < 4) {
			TileModel tileAbove = this.get(z + 1).get(y).get(x);
			if (tileAbove.tile != null && tileAbove.tile.visible) {
				return false;
			}
		}
		if (firstTile.equals(selectedTile) ||
			lastTile.equals(selectedTile)) {
			return true;
		}
		return false;
	}
	
	public void removeTile(int x, int y, int z) {
		this.get(z).get(y).get(x).tile.visible = false;
	}
	
	public void addTileBack(int x, int y, int z) {
		this.get(z).get(y).get(x).tile.visible = true;
	}
}