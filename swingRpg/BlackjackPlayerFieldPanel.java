package swingRpg;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class BlackjackPlayerFieldPanel extends JPanel{
	private static ArrayList<JLabel> playerCardLabel = new ArrayList<>();
	
	BlackjackPlayerFieldPanel(){
		this.setBounds(200, 300, 400, 200);
		this.setLayout(null);
		this.setBackground(new Color(00, 160, 33));
		this.setBorder(new LineBorder(Color.white, 2));
	}
	
	public void addCard(BlackjackCard card) {
		JLabel label = new JLabel();
		playerCardLabel.add(label);
		label.setBounds((131 + (playerCardLabel.size()-1) * 30), 3, 138, 196);
		label.setOpaque(true);
		label.setIcon(card.getIcon());
		label.setBorder(new LineBorder(Color.black, 1));
		this.add(label);
		this.positioningCard();
		this.setComponentZOrder(label, 0);
	}
	
	private void positioningCard() {
		for(int i=0; i < playerCardLabel.size(); i++) {
			playerCardLabel.get(i).setBounds((200 - ((138 + (25 * playerCardLabel.size() - 1 - i)) / 2)) + i * 30, 3, 138, 196);
		}
	}
	
	public void clearPlayerCardLabel() {
		for(JLabel label : playerCardLabel) {
			this.remove(label);
		}
		playerCardLabel.clear();
	}
	
}
