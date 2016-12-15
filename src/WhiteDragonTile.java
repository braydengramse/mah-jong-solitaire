import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class WhiteDragonTile extends Tile {
	public WhiteDragonTile() {
		this.setToolTipText(this.toString());
	}
	
	public String toString() {
		return "White Dragon";
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(Color.BLUE);
		g.drawRect(20, 12, 40, 40);
		g.drawRect(24, 16, 32, 32);
		Graphics2D g2 = (Graphics2D)g;
		g2.setStroke(new BasicStroke(3.5F, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL, 0F, new float[]{5F, 12F}, 0F));
		g2.drawRect(22, 14, 36, 36);
	}
}