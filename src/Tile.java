import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public abstract class Tile extends JPanel {
	public boolean visible = true;
	public boolean selected = false;
	
	private final static Dimension SIZE = new Dimension(70, 83);
	
	private final static Color TAN = new Color(245, 222, 179);
	private final static Color DARK_GREEN = new Color(0, 100, 0);
	private final static GradientPaint TOP_TILE_GRADIENT = new GradientPaint(20, 141, Color.WHITE, 110, 0, TAN);
	private final static GradientPaint BOTTOM_TILE_GRADIENT = new GradientPaint(10, 156, Color.GREEN, 110, 0, DARK_GREEN);
	
	private final static int[] TOP_TILE_X_COORDINATES = {15, 65, 65, 15};
	private final static int[] TOP_TILE_Y_COORDINATES = {0, 0, 63, 63};
	
	private final static int[] TOP_LEFT_SIDE_X_COORDINATES = {10, 15, 15, 10};
	private final static int[] TOP_LEFT_SIDE_Y_COORDINATES = {8, 0, 63, 71};
	
	private final static int[] BOTTOM_LEFT_SIDE_X_COORDINATES = {5, 10, 10, 5};
	private final static int[] BOTTOM_LEFT_SIDE_Y_COORDINATES = {15, 8, 71, 78};
	
	private final static int[] TOP_FRONT_SIDE_X_COORDINATES = {10, 15, 65, 58};
	private final static int[] TOP_FRONT_SIDE_Y_COORDINATES = {71, 63, 63, 71};
	
	private final static int[] BOTTOM_FRONT_SIDE_X_COORDINATES = {5, 10, 58, 50};
	private final static int[] BOTTOM_FRONT_SIDE_Y_COORDINATES = {78, 71, 71, 78};
	
	private final static Polygon TOP_FACE = new Polygon(TOP_TILE_X_COORDINATES,
														TOP_TILE_Y_COORDINATES,
														TOP_TILE_X_COORDINATES.length);
	
	private final static Polygon TOP_LEFT_FACE = new Polygon(TOP_LEFT_SIDE_X_COORDINATES,
															 TOP_LEFT_SIDE_Y_COORDINATES,
															 TOP_LEFT_SIDE_X_COORDINATES.length);
	
	private final static Polygon TOP_FRONT_FACE = new Polygon(TOP_FRONT_SIDE_X_COORDINATES,
															  TOP_FRONT_SIDE_Y_COORDINATES,
															  TOP_FRONT_SIDE_X_COORDINATES.length);
	
	private final static Polygon BOTTOM_LEFT_FACE = new Polygon(BOTTOM_LEFT_SIDE_X_COORDINATES,
																BOTTOM_LEFT_SIDE_Y_COORDINATES,
																BOTTOM_LEFT_SIDE_X_COORDINATES.length);
	
	private final static Polygon BOTTOM_FRONT_FACE = new Polygon(BOTTOM_FRONT_SIDE_X_COORDINATES,
																 BOTTOM_FRONT_SIDE_Y_COORDINATES,
																 BOTTOM_FRONT_SIDE_X_COORDINATES.length);
	
	public Tile() {
		setSize(SIZE);
		setOpaque(false);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2D = (Graphics2D) g;
		
		g2D.setPaint(BOTTOM_TILE_GRADIENT);
		g.fillPolygon(BOTTOM_LEFT_FACE);
		g.fillPolygon(BOTTOM_FRONT_FACE);
		
		g2D.setPaint(TOP_TILE_GRADIENT);
		g.fillPolygon(TOP_FACE);
		g.fillPolygon(TOP_LEFT_FACE);
		g.fillPolygon(TOP_FRONT_FACE);
		
		g2D.setPaint(Color.BLACK);
		g.drawPolygon(TOP_FACE);
		g.drawPolygon(TOP_LEFT_FACE);
		g.drawPolygon(BOTTOM_LEFT_FACE);
		g.drawPolygon(TOP_FRONT_FACE);
		g.drawPolygon(BOTTOM_FRONT_FACE);
	}
	
	public boolean matches(Tile other) {
		if (this == other) {
			return true;
		}
		if (other == null) {
			return false;
		}
		if (getClass() != other.getClass()) {
			return false;
		} else {
			return true;
		}
	}
}