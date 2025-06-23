package swingRpg;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class BlackjackCard {
	private String suit;
	private int rank;
	private ImageIcon icon;
	
	BlackjackCard(String suit, int rank){
		this.suit = suit;
		this.rank = rank;
		this.icon = this.returnImageIcon();
	}
	
	private ImageIcon returnImageIcon() {
		int y=0;
		int x=0;
		switch(this.suit) {
		case "diamonds":
			y = 2+ (1-1) * 209;
			break;
		case "clubs":
			y = 2+ (2-1) * 209;
			break;
		case "hearts":
			y = 2+ (3-1) * 209;
			break;
		case "spades":
			y = 2+ (4-1) * 209;
			break;
		}
		switch(this.rank) {
		case 1:
			x = 1793;
			break;
		case 2:
			x = 0;
			break;
		case 3:
			x = 149;
			break;
		case 4:
			x = 299;
			break;
		case 5:
			x = 448;
			break;
		case 6:
			x = 598;
			break;
		case 7:
			x = 747;
			break;
		case 8:
			x = 897;
			break;
		case 9:
			x = 1046;
			break;
		case 10:
			x = 1196;
			break;
		case 11:
			x = 1345;
			break;
		case 12:
			x = 1495;
			break;
		case 13:
			x = 1644;
			break;
		}
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File("./images\\tramp\\tramp.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		BufferedImage sprite = image.getSubimage(x, y, 138, 196);
		return new ImageIcon(sprite);
	}
	
	//  ゲッター
	public String getSuit() {
		return suit;
	}
	public int getRank() {
		return rank;
	}
	public int getEffectiveRank() {
		switch(this.rank) {
		case 1:
			return 11;
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
		case 7:
		case 8:
		case 9:
			return this.rank;
		case 10:
		case 11:
		case 12:
		case 13:
			return 10;
			default:
				return 0;
		}
	}
	public ImageIcon getIcon() {
		return icon;
	}



	//  セッター
	public void setSuit(String suit) {
		this.suit = suit;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}
	
}
