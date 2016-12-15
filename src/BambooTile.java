import java.awt.*;
import java.util.*;

import javax.swing.JFrame;

public class BambooTile extends RankTile {
	private ArrayList<Bamboo> bamboos = new ArrayList<Bamboo>();
	
	public BambooTile(int rank) {
		super(rank);
		this.setToolTipText(this.toString());
		
		switch(rank) {
		case 2:
			bamboos.add(new Bamboo(37, 15, Color.BLUE));
			bamboos.add(new Bamboo(37, 32, Color.GREEN));
			break;
		case 3:
			bamboos.add(new Bamboo(37, 15, Color.BLUE));
			bamboos.add(new Bamboo(27, 32, Color.GREEN));
			bamboos.add(new Bamboo(47, 32, Color.GREEN));
			break;
		case 4:
			bamboos.add(new Bamboo(27, 15, Color.BLUE));
			bamboos.add(new Bamboo(47, 15, Color.GREEN));
			bamboos.add(new Bamboo(27, 32, Color.GREEN));
			bamboos.add(new Bamboo(47, 32, Color.BLUE));
			break;
		case 5:
			bamboos.add(new Bamboo(22, 15, Color.GREEN));
			bamboos.add(new Bamboo(52, 15, Color.BLUE));
			bamboos.add(new Bamboo(37, 23, Color.RED));
			bamboos.add(new Bamboo(22, 32, Color.BLUE));
			bamboos.add(new Bamboo(52, 32, Color.GREEN));
			break;
		case 6:
			bamboos.add(new Bamboo(22, 15, Color.GREEN));
			bamboos.add(new Bamboo(37, 15, Color.GREEN));
			bamboos.add(new Bamboo(52, 15, Color.GREEN));
			bamboos.add(new Bamboo(22, 32, Color.BLUE));
			bamboos.add(new Bamboo(37, 32, Color.BLUE));
			bamboos.add(new Bamboo(52, 32, Color.BLUE));
			break;
		case 7:
			bamboos.add(new Bamboo(37, 7, Color.RED));
			bamboos.add(new Bamboo(22, 24, Color.GREEN));
			bamboos.add(new Bamboo(37, 24, Color.BLUE));
			bamboos.add(new Bamboo(52, 24, Color.GREEN));
			bamboos.add(new Bamboo(22, 41, Color.GREEN));
			bamboos.add(new Bamboo(37, 41, Color.BLUE));
			bamboos.add(new Bamboo(52, 41, Color.GREEN));
			break;
		case 8:
			bamboos.add(new Bamboo(22, 7, Color.GREEN));
			bamboos.add(new Bamboo(37, 7, Color.GREEN));
			bamboos.add(new Bamboo(52, 7, Color.GREEN));
			bamboos.add(new Bamboo(27, 24, Color.RED));
			bamboos.add(new Bamboo(47, 24, Color.RED));
			bamboos.add(new Bamboo(22, 41, Color.BLUE));
			bamboos.add(new Bamboo(37, 41, Color.BLUE));
			bamboos.add(new Bamboo(52, 41, Color.BLUE));
			break;
		case 9:
			bamboos.add(new Bamboo(22, 7, Color.RED));
			bamboos.add(new Bamboo(37, 7, Color.BLUE));
			bamboos.add(new Bamboo(52, 7, Color.GREEN));
			bamboos.add(new Bamboo(22, 24, Color.RED));
			bamboos.add(new Bamboo(37, 24, Color.BLUE));
			bamboos.add(new Bamboo(52, 24, Color.GREEN));
			bamboos.add(new Bamboo(22, 41, Color.RED));
			bamboos.add(new Bamboo(37, 41, Color.BLUE));
			bamboos.add(new Bamboo(52, 41, Color.GREEN));
			break;
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for (Bamboo bamboo : this.bamboos) {
			bamboo.draw(g);
		}
	}

	public String toString() {
		return "Bamboo " + this.rank;
	}
}