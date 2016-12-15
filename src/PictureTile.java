public abstract class PictureTile extends Tile {
	private String name;

	public PictureTile(String name) {
		this.name = name;
		this.setToolTipText(this.toString());
	}

	public String toString() {
		return this.name;
	}
}