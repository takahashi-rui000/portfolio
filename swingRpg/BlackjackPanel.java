package swingRpg;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

public class BlackjackPanel extends JPanel implements MouseListener, ActionListener, KeyListener{
	private static BlackjackDealerFieldPanel dealerFieldPanel;
	private static BlackjackPlayerFieldPanel playerFieldPanel;
	
	private static JButton backButton;
	private static JButton[] buttons;
	private static JButton[] betButtons;
	private static JLabel goldLabel;
	private static JLabel betGoldLabel;
	private static JLabel winnerLabel;
	private static JLabel[] handTotalLabel;
	
	final private Timer TIMER = new Timer(100, this);
	
	BlackjackPanel(){
		this.setLayout(null);
		this.setSize(800+8,600+36);
		this.setBackground(new Color(00, 88, 33));
		this.addKeyListener(this);
		
		dealerFieldPanel = new BlackjackDealerFieldPanel();
		playerFieldPanel = new BlackjackPlayerFieldPanel();
		this.add(dealerFieldPanel);
		this.add(playerFieldPanel);
	}
	
	public void prepareComponents() {
		this.prepareBackButton();
		this.prepareButtons();
		this.prepareBetButtons();
		this.prepareBetGoldLabel();
		this.prepareWinnerLabel();
		this.prepareHandTotalLabel();
		this.prepareGoldLabel();
	}
	
	private void prepareBackButton() {
		backButton = new JButton("戻る");
		backButton.addMouseListener(this);
		backButton.setName("8");
		backButton.setOpaque(true);
		backButton.setBackground(Color.black);
		backButton.setForeground(Color.white);
		backButton.setBorder(new LineBorder(Color.white, 1));
		backButton.setBounds(25, 50, 100, 50);
		this.add(backButton);
	}
	
	private void prepareButtons() {
		String[] subject = {"ヒット", "スタンド", "ダブルダウン", "サレンダー", "リスタート"};
		buttons = new JButton[subject.length];
		
		for(int i=0; i < buttons.length; i++) {
			buttons[i] = new JButton(subject[i]);
			buttons[i].addMouseListener(this);
			buttons[i].setName(i+"");
			buttons[i].setOpaque(true);
			buttons[i].setBackground(Color.black);
			buttons[i].setForeground(Color.white);
			buttons[i].setBorder(new LineBorder(Color.white, 1));
			buttons[i].setBounds(650, (50 + i * 100), 100, 50);
		}
	}
	
	public void prepareGoldLabel() {
		goldLabel = new JLabel("所持G:" + BattleSystem.getPlayer().getGold());
		goldLabel.setFont(new Font(Font.SERIF, Font.PLAIN, 17));
		goldLabel.setOpaque(true);
		goldLabel.setBackground(Color.black);
		goldLabel.setForeground(Color.white);
		goldLabel.setBorder(new LineBorder(Color.white));
		goldLabel.setHorizontalAlignment(JLabel.CENTER);
		goldLabel.setBounds(25, 125, 150, 50);
		this.add(goldLabel);
	}
	
	private void prepareBetButtons() {
		String[] subject = {"決定", "△","▽"};
		betButtons = new JButton[subject.length];
		
		for(int i=0; i < betButtons.length; i++) {
			betButtons[i] = new JButton(subject[i]);
			betButtons[i].addMouseListener(this);
			betButtons[i].setName((i + buttons.length)+"");
			betButtons[i].setOpaque(true);
			betButtons[i].setBackground(Color.black);
			betButtons[i].setForeground(Color.white);
			betButtons[i].setBorder(new LineBorder(Color.white, 1));
			betButtons[i].setBounds(25 + (50 * i), 225, 50, 50);
			this.add(betButtons[i]);
		}
	}
	

	
	private void prepareBetGoldLabel() {
		betGoldLabel = new JLabel("0");
		betGoldLabel.setOpaque(true);
		betGoldLabel.setBackground(Color.black);
		betGoldLabel.setForeground(Color.white);
		betGoldLabel.setHorizontalAlignment(JLabel.CENTER);
		betGoldLabel.setBorder(new LineBorder(Color.white, 1));
		betGoldLabel.setBounds(25, 275, 150, 50);
		this.add(betGoldLabel);
	}
	
	private void prepareWinnerLabel() {
		winnerLabel = new JLabel("ディーラーの勝ち");
		winnerLabel.setOpaque(true);
		winnerLabel.setBackground(Color.black);
		winnerLabel.setForeground(Color.yellow);
		winnerLabel.setBorder(new LineBorder(Color.yellow, 2));
		winnerLabel.setFont(new Font(Font.SERIF, Font.PLAIN, 50));
		winnerLabel.setBounds(150, 200, 500, 150);
		winnerLabel.setHorizontalAlignment(JLabel.CENTER);
	}
	
	private void prepareHandTotalLabel() {
		handTotalLabel = new JLabel[2];
		for(int i=0; i < handTotalLabel.length; i++) {
			handTotalLabel[i] = new JLabel("0");
			handTotalLabel[i].setOpaque(true);
			handTotalLabel[i].setBackground(new Color(00, 160, 33));
			handTotalLabel[i].setForeground(Color.white);
			handTotalLabel[i].setBorder(new LineBorder(Color.white, 2));
			handTotalLabel[i].setHorizontalAlignment(JLabel.CENTER);
			handTotalLabel[i].setFont(new Font(Font.SERIF, Font.PLAIN, 20));
			this.add(handTotalLabel[i]);
		}
		handTotalLabel[0].setBounds(152, 50, 50, 50);
		handTotalLabel[1].setBounds(152, 450, 50, 50);
	}
	

	
	public void displayWinnerLabel(String winner) {
		System.out.println("deispla");
		winnerLabel.setText(winner + "の勝ち");
		this.add(winnerLabel);
		this.setComponentZOrder(winnerLabel, 0);
		this.repaint();
	}
	public void hideWinnerLabel() {
		this.remove(winnerLabel);
		this.repaint();
	}
	
	public void displayButtons() {
		for(int i=0; i < buttons.length-1; i++) {
			this.add(buttons[i]);
		}
		this.repaint();
	}
	public void hideButtons() {
		for(int i=0; i < buttons.length-1; i++) {
			this.remove(buttons[i]);
		}
		this.repaint();
	}
	
	public void displayRestartButton() {
		this.add(buttons[buttons.length-1]);
	}
	public void hideRestartButton() {
		this.remove(buttons[buttons.length-1]);
	}
	
	public void displayBetButtons() {
		for(int i=0; i < betButtons.length; i++) {
			this.add(betButtons[i]);
		}
	}
	public void hideBetButtons() {
		for(int i=0; i < betButtons.length; i++) {
			this.remove(betButtons[i]);
		}
	}
	
	public void timerStart() {
		this.TIMER.start();
	}
	public void timerStop() {
		this.TIMER.stop();
	}
	
	public static void updateDealerHandTotalLabel(int handTotal) {
		handTotalLabel[0].setText(handTotal+"");
	}
	public static void updateDealerHandTotalLabel(int hand, int mode) {
		handTotalLabel[0].setText(hand+"+");
	}
	public static void updatePlayerHandTotalLabel(int handTotal) {
		handTotalLabel[1].setText(handTotal+"");
	}
	
	public static void updateBetLabel() {
		betGoldLabel.setText("ベット:" + BlackjackGame.getBet());
	}
	public static void updateGoldLabel() {
		goldLabel.setText("所持G:" + BattleSystem.getPlayer().getGold());
	}
	
	//  ゲッター
	public static BlackjackDealerFieldPanel getDealerFieldPanel() {
		return dealerFieldPanel;
	}
	public static BlackjackPlayerFieldPanel getPlayerFieldPanel() {
		return playerFieldPanel;
	}
	public static JLabel getBetGoldLabel() {
		return betGoldLabel;
	}
	
	
	//  セッター
	public void setDealerFieldPanel(BlackjackDealerFieldPanel dealerFieldPanel) {
		BlackjackPanel.dealerFieldPanel = dealerFieldPanel;
	}
	public void setPlayerFieldPanel(BlackjackPlayerFieldPanel playerFieldPanel) {
		BlackjackPanel.playerFieldPanel = playerFieldPanel;
	}
	public static void setBetGoldLabel(int bet) {
		BlackjackPanel.betGoldLabel.setText("ベット:"+bet);
	}
	public static void setGoldLabel(int gold) {
		BlackjackPanel.goldLabel.setText("所持G:"+gold);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(Integer.parseInt(e.getComponent().getName()) < 5) {
			BlackjackGame.getPlayer().decideAction(Integer.parseInt(e.getComponent().getName()));
		}else if(Integer.parseInt(e.getComponent().getName()) == 5){
			BlackjackGame.gameStart();
		}else if(Integer.parseInt(e.getComponent().getName()) < 8){
			BlackjackGame.setBetGold(e);
		}else if(Integer.parseInt(e.getComponent().getName()) == 8) {
			Observer.getMainWindow().setFrontPanelAndFocus(ScreenMode.FIELD);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
}
