package swingRpg;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class BlackjackDealerFieldPanel extends JPanel{
	private static ArrayList<JLabel> dealerCardLabel = new ArrayList<>();
	
	BlackjackDealerFieldPanel(){
		this.setBounds(200, 50, 400, 200);
		this.setLayout(null);
		this.setBackground(new Color(00, 160, 33));
		this.setBorder(new LineBorder(Color.white, 2));
	}
	
	public void addCard(ImageIcon icon) {
		JLabel label = new JLabel();
		dealerCardLabel.add(label);
		label.setBounds((131 + (dealerCardLabel.size()-1) * 30), 3, 138, 196);
		label.setOpaque(true);
		label.setIcon(icon);
		label.setBorder(new LineBorder(Color.black, 1));
		this.add(label);
		this.positioningCard();
		this.setComponentZOrder(label, 0);
	}
	
	public void openCard() {
		dealerCardLabel.get(1).setIcon(BlackjackGame.getDealer().getCards().get(1).getIcon());
		this.repaint();
	}
	
	private void positioningCard() {
		for(int i=0; i < dealerCardLabel.size(); i++) {
			dealerCardLabel.get(i).setBounds((200 - ((138 + (25 * dealerCardLabel.size() - 1 - i)) / 2)) + i * 30, 3, 138, 196);
		}
	}
	
	public void clearDealerCardLabel() {
		for(JLabel label : dealerCardLabel) {
			this.remove(label);
		}
		dealerCardLabel.clear();
	}
	
}
