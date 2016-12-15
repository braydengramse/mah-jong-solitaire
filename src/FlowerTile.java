import java.awt.*;
import javax.swing.*;

public class FlowerTile extends PictureTile {
	private Image chrysanthemum = new ImageIcon(getClass().getResource("/images/Chrysanthemum.png")).getImage().getScaledInstance(40, 36, Image.SCALE_SMOOTH);
	private Image orchid = new ImageIcon(getClass().getResource("/images/Orchid.png")).getImage().getScaledInstance(40, 39, Image.SCALE_SMOOTH);
	private Image plum = new ImageIcon(getClass().getResource("/images/Plum.png")).getImage().getScaledInstance(40, 43, Image.SCALE_SMOOTH);
	private Image bamboo = new ImageIcon(getClass().getResource("/images/Bamboo.png")).getImage().getScaledInstance(40, 48, Image.SCALE_SMOOTH);
	
	public FlowerTile(String name) {
		super(name);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		switch(this.toString()) {
		case "Chrysanthemum":
			g.drawImage(chrysanthemum, 20, 13, this);
			break;
		case "Orchid":
			g.drawImage(orchid, 20, 12, this);
			break;
		case "Plum":
			g.drawImage(plum, 20, 10, this);
			break;
		case "Bamboo":
			g.drawImage(bamboo, 20, 8, this);
			break;
		}
	}
}