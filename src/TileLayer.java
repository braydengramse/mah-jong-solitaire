import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TileLayer extends ArrayList<TileRow> {
	public TileLayer(List<TileModel> tiles) {
		for (int i = 0; i < tiles.size(); i += 15) {
			List<TileModel> subList = tiles.subList(i, i + 15);
			Collections.reverse(subList);
			this.add(new TileRow(subList));
		}
	}
}