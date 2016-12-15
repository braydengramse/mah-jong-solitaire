import java.awt.*;
import java.net.*;
import javax.swing.*;

public class Bamboo1Tile extends PictureTile {
	private Image sparrow = new ImageIcon(getClass().getResource("/images/Sparrow.png")).getImage().getScaledInstance(40, 31, Image.SCALE_SMOOTH);
	
	public Bamboo1Tile() {
		super("Sparrow");
		this.setToolTipText(this.toString());
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(sparrow, 20, 16, this);
	}

	public String toString() {
		return "Bamboo 1";
	}
}