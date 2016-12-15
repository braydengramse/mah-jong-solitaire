import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Pancake extends Circle {
	public Pancake(int x, int y, Color color) {
		super(x, y, color);
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawOval(20, 11, 40, 40);
		g.setColor(Color.GREEN);
		g.fillOval(20, 11, 40, 40);
		super.draw(g);
		g.setColor(Color.WHITE);
		Graphics2D	g2 = (Graphics2D)g;
		g2.setColor(Color.WHITE);
		g2.setStroke(new BasicStroke(3.5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER, 4.5f, new float[] {0.35f, 6.5f}, 9.5f));
		g2.drawOval(25, 16, 30, 30);
	}
}