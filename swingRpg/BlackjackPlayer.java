package swingRpg;

public class BlackjackPlayer extends BlackjackGameParticipant{
	private boolean end = false;
	private boolean doubleDown;
	private boolean surrender;
	
	BlackjackPlayer(){
		super();
		doubleDown = false;
		surrender = false;
	}
	
	public void drawCard() {
		this.getCards().add(BlackjackGame.drawCard());
		System.out.println(this.getCards().get(this.getCards().size()-1).getSuit());
		BlackjackPanel.getPlayerFieldPanel().addCard(this.getCards().get(this.getCards().size()-1));
		BlackjackPanel.updatePlayerHandTotalLabel(this.returnSum());
		BlackjackPanel.getPlayerFieldPanel().repaint();
	}
	
	public void decideAction(int inputClickButton) {
		switch(inputClickButton) {
		case 0:
			this.hit();
			if(this.returnSum() > 21) {
				end = true;
			}
			break;
		case 1:
			end = true;
			break;
		case 2:
			if(this.getCards().size() == 2) {
				this.doubleDown();
				end = true;
			}
			break;
		case 3:
			this.surrender();
			end = true;
			break;
		case 4:
			end = false;
			BlackjackGame.restartGame();
			break;
		}
		if(this.end) {
			BlackjackGame.gameEnd();
		}
	}
	
	private void hit() {
		this.drawCard();
	}
	
	private void doubleDown() {
		BlackjackGame.setBet(BlackjackGame.getBet() * 2);
		BlackjackPanel.updateBetLabel();
		BlackjackPanel.updateGoldLabel();
		this.drawCard();
		doubleDown = true;
	}
	
	private void surrender() {
		surrender = true;
	}
	
	public boolean isEnd() {
		return end;
	}
	public boolean isDoubleDown() {
		return doubleDown;
	}
	public boolean isSurrender() {
		return surrender;
	}

	public void setEnd(boolean end) {
		this.end = end;
	}
	public void setDoubleDown(boolean doubleDown) {
		this.doubleDown = doubleDown;
	}
	public void setSurrender(boolean surrender) {
		this.surrender = surrender;
	}
	
}
