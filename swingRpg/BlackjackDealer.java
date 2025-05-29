package swingRpg;

import javax.swing.ImageIcon;

public class BlackjackDealer extends BlackjackGameParticipant{
	
	public BlackjackDealer() {
		super();
	}
	
	public void drawCard() {
		this.getCards().add(BlackjackGame.drawCard());
		if(this.getCards().size() == 2) {
			BlackjackPanel.getDealerFieldPanel().addCard(new ImageIcon("./images\\tramp\\tramp_2.png"));
			BlackjackPanel.updateDealerHandTotalLabel(this.getCards().get(0).getEffectiveRank(), 0);
		}else {
			BlackjackPanel.getDealerFieldPanel().addCard(this.getCards().get(this.getCards().size()-1).getIcon());
			BlackjackPanel.updateDealerHandTotalLabel(this.returnSum());
		}
		BlackjackPanel.getDealerFieldPanel().repaint();
	}
	
	public void drawAddCard() {
		while(this.returnSum() < 15) {
			this.drawCard();
		}
	}
	
}
