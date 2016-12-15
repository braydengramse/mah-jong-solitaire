import java.awt.Color;
import java.awt.Graphics;

public class Bamboo {
	private int x;
	private int y;
	private Color color;
	
	public Bamboo(int x, int y, Color color) {
		this.x = x;
		this.y = y;
		this.color = color;
	}
	
	public void draw(Graphics g) {
		g.setColor(this.color);
		g.fillRoundRect(x + 2, y + 1, 5, 15, 2, 2);
		g.fillOval(x, y, 8, 4);
		g.fillOval(x, y + 13, 8, 4);
		g.setColor(Color.WHITE);
		g.drawLine(x + 4, y + 2, x + 4, y + 14);
		g.setColor(color);
		g.fillOval(x, y + 6, 8, 4);
	}
}