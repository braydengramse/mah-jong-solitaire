import java.awt.*;
import javax.swing.*;

public class SeasonTile extends PictureTile {
	private Image spring = new ImageIcon(getClass().getResource("/images/Spring.png")).getImage().getScaledInstance(40, 30, Image.SCALE_SMOOTH);
	private Image summer = new ImageIcon(getClass().getResource("/images/Summer.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	private Image fall = new ImageIcon(getClass().getResource("/images/Fall.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	private Image winter = new ImageIcon(getClass().getResource("/images/Winter.png")).getImage().getScaledInstance(40, 38, Image.SCALE_SMOOTH);
	
	public SeasonTile(String name) {
		super(name);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		switch(this.toString()) {
		case "Spring":
			g.drawImage(spring, 20, 16, this);
			break;
		case "Summer":
			g.drawImage(summer, 20, 11, this);
			break;
		case "Fall":
			g.drawImage(fall, 20, 11, this);
			break;
		case "Winter":
			g.drawImage(winter, 20, 12, this);
			break;
		}
	}
}