import java.awt.Color;
import java.awt.Graphics;

public class Circle {
	private int x;
	private int y;
	private Color color;
	
	public Circle(int x, int y, Color color) {
		this.x = x;
		this.y = y;
		this.color = color;
	}
	
	public void draw(Graphics g) {
		g.setColor(this.color);
		g.fillOval(this.x, this.y, 10, 10);
		g.setColor(Color.WHITE);
		g.drawLine(this.x + 3, this.y + 3, this.x + 7, this.y + 7);
		g.drawLine(this.x + 7, this.y + 3, this.x + 3, this.y + 7);
	}
}