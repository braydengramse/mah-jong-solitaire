import java.awt.*;
import java.util.*;
import javax.swing.*;

public class CharacterTile extends Tile {
	
	protected char symbol;
	private static HashMap<String, String> chineseUnicodeSymbols = new HashMap<String, String>();
	private String chineseUnicodeString;
	
	static {
		chineseUnicodeSymbols.put("1", "\u4E00");
		chineseUnicodeSymbols.put("2", "\u4E8C");
		chineseUnicodeSymbols.put("3", "\u4E09");
		chineseUnicodeSymbols.put("4", "\u56DB");
		chineseUnicodeSymbols.put("5", "\u4E94");
		chineseUnicodeSymbols.put("6", "\u516D");
		chineseUnicodeSymbols.put("7", "\u4E03");
		chineseUnicodeSymbols.put("8", "\u516B");
		chineseUnicodeSymbols.put("9", "\u4E5D");
		chineseUnicodeSymbols.put("N", "\u5317");
		chineseUnicodeSymbols.put("E", "\u6771");
		chineseUnicodeSymbols.put("W", "\u897F");
		chineseUnicodeSymbols.put("S", "\u5357");
		chineseUnicodeSymbols.put("C", "\u4E2D");
		chineseUnicodeSymbols.put("F", "\u767C");
		chineseUnicodeSymbols.put("wan", "\u842C");
	}

	public CharacterTile(char symbol) {
		this.symbol = symbol;
		this.chineseUnicodeString = chineseUnicodeSymbols.get(String.valueOf(this.symbol));
		this.setToolTipText(this.toString());
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.RED);
		g.drawString(String.valueOf(this.symbol), 53, 13);
		
		if (this.symbol >= '1' && this.symbol <= '9') {			
			g.setColor(Color.BLACK);
			Font font = g.getFont();
			FontMetrics fontMetrics = g.getFontMetrics();
			int width = fontMetrics.stringWidth(this.chineseUnicodeString);
			font = font.deriveFont(font.getSize2D() * 2F);
			g.setFont(font);
			g.drawString(this.chineseUnicodeString, (getWidth() - width - 8) / 2, (getHeight() + 20) / 4);
			g.setColor(Color.RED);
			g.drawString(chineseUnicodeSymbols.get("wan"), (getWidth() - width - 8) / 2, (getHeight() + 20) / 2);
		}
		else if (this.symbol == 'C') {
			this.drawNonNumeric(g, Color.RED);
		}
		else if (this.symbol == 'F') {
			this.drawNonNumeric(g, Color.GREEN);
		}
		else {
			this.drawNonNumeric(g, Color.BLACK);
		}
		
	}

	public boolean matches(Tile other) {
		if (super.matches(other)) {
			CharacterTile otherObject = (CharacterTile) other;
			return this.symbol == otherObject.symbol;
		} else {
			return false;
		}
	}

	public String toString() {
		switch (this.symbol) {
		case '1':
		case '2':
		case '3':
		case '4':
		case '5':
		case '6':
		case '7':
		case '8':
		case '9':
			return "Character " + this.symbol;
		case 'N':
			return "North Wind";
		case 'E':
			return "East Wind";
		case 'W':
			return "West Wind";
		case 'S':
			return "South Wind";
		case 'C':
			return "Red Dragon";
		case 'F':
			return "Green Dragon";
		default:
			return "";
		}
	}
	
	private void drawNonNumeric(Graphics g, Color c) {
		g.setColor(c);
		Font font = g.getFont();
		FontMetrics fontMetrics = g.getFontMetrics();
		int width = fontMetrics.stringWidth(this.chineseUnicodeString);
		font = font.deriveFont(font.getSize2D() * 3.5F);
		g.setFont(font);
		g.drawString(this.chineseUnicodeString, (getWidth() - width - 22) / 2, (getHeight() + 15) / 2);
	}
}