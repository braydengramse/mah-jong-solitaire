import java.awt.Color;
import java.awt.*;
import javax.swing.*;
import java.util.*;

public class CircleTile extends RankTile {
	private ArrayList<Circle> circles = new ArrayList<Circle>();
	
	public CircleTile(int rank) {
		super(rank);
		this.setToolTipText(this.toString());
		
		switch(rank) {
		case 1:
			circles.add(new Pancake(35, 26, Color.RED));
			break;
		case 2:
			circles.add(new Circle(35, 16, Color.GREEN));
			circles.add(new Circle(35, 42, Color.RED));
			break;
		case 3:
			circles.add(new Circle(20, 5, Color.BLUE));
			circles.add(new Circle(35, 26, Color.RED));
			circles.add(new Circle(50, 48, Color.GREEN));
			break;
		case 4:
			circles.add(new Circle(26, 16, Color.BLUE));
			circles.add(new Circle(26, 37, Color.GREEN));
			circles.add(new Circle(47, 16, Color.GREEN));
			circles.add(new Circle(47, 37, Color.BLUE));
			break;
		case 5:
			circles.add(new Circle(20, 5, Color.BLUE));
			circles.add(new Circle(20, 48, Color.GREEN));
			circles.add(new Circle(35, 26, Color.RED));
			circles.add(new Circle(50, 5, Color.GREEN));
			circles.add(new Circle(50, 48, Color.BLUE));
			break;
		case 6:
			circles.add(new Circle(26, 11, Color.GREEN));
			circles.add(new Circle(47, 11, Color.GREEN));
			circles.add(new Circle(26, 27, Color.RED));
			circles.add(new Circle(26, 43, Color.RED));
			circles.add(new Circle(47, 27, Color.RED));
			circles.add(new Circle(47, 43, Color.RED));
			break;
		case 7:
			circles.add(new Circle(20, 5, Color.GREEN));
			circles.add(new Circle(35, 10, Color.GREEN));
			circles.add(new Circle(50, 15, Color.GREEN));
			circles.add(new Circle(26, 27, Color.RED));
			circles.add(new Circle(26, 43, Color.RED));
			circles.add(new Circle(47, 27, Color.RED));
			circles.add(new Circle(47, 43, Color.RED));
			break;
		case 8:
			circles.add(new Circle(26, 8, Color.BLUE));
			circles.add(new Circle(26, 21, Color.BLUE));
			circles.add(new Circle(26, 34, Color.BLUE));
			circles.add(new Circle(26, 47, Color.BLUE));
			circles.add(new Circle(47, 8, Color.BLUE));
			circles.add(new Circle(47, 21, Color.BLUE));
			circles.add(new Circle(47, 34, Color.BLUE));
			circles.add(new Circle(47, 47, Color.BLUE));
			break;
		case 9:
			circles.add(new Circle(20, 11, Color.GREEN));
			circles.add(new Circle(35, 11, Color.GREEN));
			circles.add(new Circle(50, 11, Color.GREEN));
			circles.add(new Circle(20, 27, Color.RED));
			circles.add(new Circle(35, 27, Color.RED));
			circles.add(new Circle(50, 27, Color.RED));
			circles.add(new Circle(20, 43, Color.BLUE));
			circles.add(new Circle(35, 43, Color.BLUE));
			circles.add(new Circle(50, 43, Color.BLUE));
			break;
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for (Circle circle : this.circles) {
			circle.draw(g);
		}
	}

	public String toString() {
		return "Circle " + this.rank;
	}
}