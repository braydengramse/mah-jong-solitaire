public abstract class RankTile extends Tile {
	protected int rank;

	public RankTile(int rank) {
		this.rank = rank;
	}

	public boolean matches(Tile other) {
		if (super.matches(other)) {
			RankTile otherObject = (RankTile) other;
			return this.rank == otherObject.rank;
		} else {
			return false;
		}
	}
}