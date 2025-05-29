package swingRpg;

import java.awt.CardLayout;

import javax.swing.JFrame;

public class MainWindow extends JFrame{
	private static CardLayout layout;
	private static TitlePanel titlePanel;
	private static FieldPanel fieldPanel;
	private static BattlePanel battlePanel;
	private static BlackjackPanel blackjackPanel;
	
	MainWindow(){
		layout = new CardLayout();
		this.setLayout(layout);
		this.setSize(800+8,600+36);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.getContentPane();
		
		//  ↓タイトルパネル準備
		titlePanel = new TitlePanel();
		this.getContentPane().add(titlePanel, "titlePanel");
		titlePanel.getTitleSelectModePanel().setFocusable(true);
		
		//  ↓フィールド画面準備
		FieldSystem.prepareFlags();
		FieldSystem.prepareField_1();
		FieldSystem.prepareField_2();
		FieldSystem.prepareField_3();
		FieldSystem.prepareField_4();
		FieldSystem.prepareField_5();
		fieldPanel = new FieldPanel();
		fieldPanel.preparePanels();
		FieldSystem.adaptField(0);
		this.getContentPane().add(fieldPanel, "fieldPanel");
		fieldPanel.getFieldSideInfoPanel().setLabels(BattleSystem.getPlayer());
		FieldPanel.getFieldMassPanel().setFocusable(true);
        
        //  ↓バトル画面準備
        battlePanel = new BattlePanel();
        this.getContentPane().add(battlePanel, "battlePanel");
        battlePanel.preparePanels();
        battlePanel.getBattleCommandSelectPanel().setFocusable(true);
        
        //  ↓ブラックジャック
        blackjackPanel = new BlackjackPanel();
        blackjackPanel.prepareComponents();
        this.getContentPane().add(blackjackPanel, "blackjackPanel");
	}
	
	//  画面遷移
	public void setFrontPanelAndFocus(ScreenMode s) {
		switch(s) {
		case BATTLE:
			layout.show(this.getContentPane(), "battlePanel");
			fieldPanel.stopFieldTimer();
			BattlePanel.getBattleCommandSelectPanel().requestFocus();
			break;
		case FIELD:
			layout.show(this.getContentPane(), "fieldPanel");
			fieldPanel.startFieldTimer();
			FieldPanel.getFieldMassPanel().requestFocus();
			break;
		case TITLE:
			layout.show(this.getContentPane(), "titlePanel");
			TitlePanel.getTitleSelectModePanel().requestFocus();
			break;
		case BLACKJACK:
			blackjackPanel.requestFocus();
			BlackjackGame.initializeDealerAndPlayer();
			layout.show(this.getContentPane(), "blackjackPanel");
		}
	}
	
	//  ゲッター
	public static FieldPanel getFieldPanel() {
		return fieldPanel;
	}
	public static BattlePanel getBattlePanel() {
		return battlePanel;
	}
	public static TitlePanel getTitlePanel() {
		return titlePanel;
	}
	public static BlackjackPanel getBlackjackPanel() {
		return blackjackPanel;
	}
	
	//  セッター
	public static void setFieldPanel(FieldPanel fieldPanel) {
		MainWindow.fieldPanel = fieldPanel;
	}
	public static void setBattlePanel(BattlePanel battlePanel) {
		MainWindow.battlePanel = battlePanel;
	}
	public static void setTitlePanel(TitlePanel titlePanel) {
		MainWindow.titlePanel = titlePanel;
	}
	public static void setBlackjackPanel(BlackjackPanel blackjackPanel) {
		MainWindow.blackjackPanel = blackjackPanel;
	}
}
