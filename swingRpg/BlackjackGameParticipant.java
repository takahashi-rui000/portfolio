package swingRpg;

import java.util.ArrayList;

public class BlackjackGameParticipant {
	private ArrayList<BlackjackCard> cards;
	
	public BlackjackGameParticipant() {
		cards = new ArrayList<>();
	}
	
	public void drawCard() {
		cards.add(BlackjackGame.drawCard());
		System.out.println(this.getClass() + "の" + cards.size() + "枚目：" + cards.get(cards.size()-1).getRank());
	}
	
	public int returnSum() {
		int sum = 0;
		int aceNum = 0;
		for(BlackjackCard card : cards) {
			switch(card.getRank()) {
			case 11:
			case 12:
			case 13:
				sum += 10;
				break;
			case 1:
				aceNum++;
				sum += 11;
				break;
				default:
				sum += card.getRank();
			}
		}
		
		for(int i=0; i < aceNum; i++) {
			if(sum <= 21) {
				break;
			}else {
				sum -= 11;
				sum++;
			}
		}
		
		return sum;
	}

	public void clearCards() {
		cards.clear();
	}
	
	public ArrayList<BlackjackCard> getCards() {
		return cards;
	}

	public void setCards(ArrayList<BlackjackCard> cards) {
		this.cards = cards;
	}
	public void setCard(int index, BlackjackCard card) {
		this.cards.set(index, card);
	}
	
}
