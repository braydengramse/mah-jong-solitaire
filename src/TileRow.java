import java.util.*;

public class TileRow extends ArrayList<TileModel>{
	private TileModel firstTile;
	private TileModel lastTile;
	
	public TileRow(List<TileModel> tiles) {
		for (TileModel tile : tiles) {
			this.add(tile);
		}
	}
	
	public TileModel getFirstTile() {
		for (int i = 0; i < this.size(); i++) {
			TileModel currentTile = this.get(i);
			if (currentTile.tile != null && currentTile.tile.visible) {
				this.setFirstTile(currentTile);
				return this.firstTile;
			}
		}
		this.setFirstTile(null);
		return this.firstTile;
	}
	
	public TileModel getLastTile() {
		for (int i = this.size() - 1; i >= 0; i--) {
			TileModel currentTile = this.get(i);
			if (currentTile.tile != null && currentTile.tile.visible) {
				this.setLastTile(currentTile);
				return this.lastTile;
			}
		}
		this.setLastTile(null);
		return this.lastTile;
	}
	
	private void setFirstTile(TileModel firstTile) {
		this.firstTile = firstTile;
	}
	
	private void setLastTile(TileModel lastTile) {
		this.lastTile = lastTile;
	}
}