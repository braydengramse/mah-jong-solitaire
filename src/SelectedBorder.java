import java.awt.*;
import java.awt.geom.*;

import javax.swing.border.*;

public class SelectedBorder extends AbstractBorder {
	private Color BORDER_COLOR = Color.WHITE;
	
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

    public SelectedBorder() {
    	
    }

    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        super.paintBorder(c, g, x, y, width, height);
        Graphics2D g2D = null;
        if (g instanceof Graphics2D)
        {
            g2D = (Graphics2D) g;
            g2D.setColor(BORDER_COLOR);
            g2D.setStroke(new BasicStroke());
            g.setColor(BORDER_COLOR);
            g.drawPolygon(TOP_FACE);
    		g.drawPolygon(TOP_LEFT_FACE);
    		g.drawPolygon(BOTTOM_LEFT_FACE);
    		g.drawPolygon(TOP_FRONT_FACE);
    		g.drawPolygon(BOTTOM_FRONT_FACE);
        }
    }
}