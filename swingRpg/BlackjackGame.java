package swingRpg;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;

public class BlackjackGame {
	private static int maxBet = 1000;
	private static int bet;
	
	private static ArrayList<BlackjackCard> cardDeck = new ArrayList<>();
	private static BlackjackDealer dealer;
	private static BlackjackPlayer player;
	
	public static void initializeDealerAndPlayer() {
		dealer = new BlackjackDealer();
		player = new BlackjackPlayer();
	}
	
	public static void gameStart() {
		initializeDeck();
		shuffle();
		
		MainWindow.getBlackjackPanel().hideBetButtons();
		
		player.drawCard();
		dealer.drawCard();
		player.drawCard();
		dealer.drawCard();
		MainWindow.getBlackjackPanel().displayButtons();
	}
	
	public static void gameEnd() {
		MainWindow.getBlackjackPanel().hideButtons();
		BlackjackPanel.getDealerFieldPanel().openCard();
		BlackjackGame.getDealer().drawAddCard();
		BlackjackPanel.updateDealerHandTotalLabel(dealer.returnSum());
		BlackjackGame.determineWinner(BlackjackGame.getPlayer(), BlackjackGame.getDealer());
		MainWindow.getBlackjackPanel().displayRestartButton();
	}
	
	public static void restartGame() {
		MainWindow.getBlackjackPanel().hideRestartButton();
		MainWindow.getBlackjackPanel().hideWinnerLabel();
		player.setSurrender(false);
		player.setEnd(false);
		player.setDoubleDown(false);
		BlackjackPanel.getPlayerFieldPanel().clearPlayerCardLabel();
		BlackjackPanel.getDealerFieldPanel().clearDealerCardLabel();
		player.clearCards();
		dealer.clearCards();
		updateBet();
		BlackjackPanel.updateBetLabel();
		MainWindow.getBlackjackPanel().displayBetButtons();
	}
	
	public static void initializeDeck() {
		cardDeck.clear();
		String[] suits = {"hearts", "diamonds", "clubs", "spades"};
		int[] ranks = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 1};
		for(String suit : suits) {
			for(int rank : ranks) {
				cardDeck.add(new BlackjackCard(suit, rank));
			}
		}
	}
	
	public static void shuffle() {
		Collections.shuffle(cardDeck);
	}
	
	public static BlackjackCard drawCard() {
		if(cardDeck.isEmpty()) {
			initializeDeck();
			shuffle();
		}
		return cardDeck.remove(0);
	}
	
	public static void determineWinner(BlackjackPlayer player, BlackjackDealer dealer) {
		boolean playerWin = false;
		if(dealer.returnSum() > 21 || player.returnSum() >= dealer.returnSum() && player.returnSum() <= 21) {
			playerWin = true;
		}
		if(playerWin) {
			MainWindow.getBlackjackPanel().displayWinnerLabel("プレイヤー");
			BattleSystem.getPlayer().setGold(BattleSystem.getPlayer().getGold() + bet);
				System.out.println("doubleDown"+player.isDoubleDown());
			if(player.isDoubleDown()) {
				bet = bet / 2;
				BlackjackPanel.updateBetLabel();
			}
		}else {
			MainWindow.getBlackjackPanel().displayWinnerLabel("ディーラー");
			if(player.isSurrender()) {
				BattleSystem.getPlayer().setGold(BattleSystem.getPlayer().getGold() - bet / 2); 
			}else {
				BattleSystem.getPlayer().setGold(BattleSystem.getPlayer().getGold() - bet);
			}
			if(player.isDoubleDown()) {
				bet = bet / 2;
				BlackjackPanel.updateBetLabel();
			}
		}
		BlackjackPanel.setGoldLabel(BattleSystem.getPlayer().getGold());
	}
	
	public static void setBetGold(MouseEvent e) {
		System.out.println(BattleSystem.getPlayer().getGold());
		switch(e.getComponent().getName()) {
		case "6":
			if(bet < maxBet) {
				bet += maxBet / 10;
				if(bet > maxBet) {
					bet = maxBet;
				}
				if(bet > BattleSystem.getPlayer().getGold()) {
					bet = BattleSystem.getPlayer().getGold();
				}
			}
			break;
		case "7":
			if(bet > maxBet / 10 -1) {
				bet -= maxBet / 10;
			}else {
				bet = 0;
			}
		}
		BlackjackPanel.setBetGoldLabel(bet);
	}
	
	private static void updateBet() {
		if(bet > BattleSystem.getPlayer().getGold()) {
			bet = BattleSystem.getPlayer().getGold();
		}
	}
	
	//  ゲッター
	public static BlackjackDealer getDealer() {
		return dealer;
	}
	public static BlackjackPlayer getPlayer() {
		return player;
	}
	public static int getMaxBet() {
		return maxBet;
	}
	public static int getBet() {
		return bet;
	}
	
	//  セッター
	public static void setDealer(BlackjackDealer dealer) {
		BlackjackGame.dealer = dealer;
	}
	public static void setPlayer(BlackjackPlayer player) {
		BlackjackGame.player = player;
	}
	public static void setMaxBet(int maxBet) {
		MainWindow.getBlackjackPanel().repaint();
		BlackjackPanel.setGoldLabel((BattleSystem.getPlayer().getGold()));
		BlackjackGame.maxBet = maxBet;
	}
	public static void setBet(int bet) {
		BlackjackGame.bet = bet;
	}
}
