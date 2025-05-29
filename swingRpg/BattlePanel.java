package swingRpg;

import java.awt.Color;

import javax.swing.JPanel;

public class BattlePanel extends JPanel{
	private static BattleLogPanel battleLogPanel;
	private static BattleCommandSelectPanel battleCommandSelectPanel;
	private static BattleDisplayStatusPanel battleDisplayStatusPanel;
	private static BattleEnemySelectPanel  battleEnemySelectPanel;
	private static BattleEnemyImagePanel battleEnemyImagePanel;
	private static BattleUseItemPanel battleUseItemPanel;
	private static BattleSkillCheckPanel battleSkillCheckPanel;
	
	BattlePanel(){
		this.setLayout(null);
		this.setBackground(Color.black);
		this.setBounds(0,0,800+8,600+36);
	}
	
	public void preparePanels() {
		battleLogPanel = new BattleLogPanel();
		battleCommandSelectPanel = new BattleCommandSelectPanel();
		battleDisplayStatusPanel = new BattleDisplayStatusPanel();
		battleEnemySelectPanel = new BattleEnemySelectPanel();
		battleEnemyImagePanel = new BattleEnemyImagePanel();
		battleUseItemPanel = new BattleUseItemPanel();
		battleSkillCheckPanel = new BattleSkillCheckPanel();
		
		
//		this.add(battleLogPanel);
		this.add(battleCommandSelectPanel);
		this.add(battleDisplayStatusPanel);
//		this.add(battleEnemySelectPanel);
		this.add(battleEnemyImagePanel);
	}
	
	//  ステータスパネルを消して敵選択パネルを追加
	public void displayEnemySelectPanel() {
		this.remove(battleDisplayStatusPanel);
		this.add(battleEnemySelectPanel);
		battleEnemySelectPanel.requestFocus();
		BattleEnemySelectPanel.SelectedLabelInitialValue();
		this.repaint();
	}
	
	//  敵選択パネルとコマンドパネルを消して戦闘ログパネルを追加
	public void displayLogPanel() {
		this.remove(battleDisplayStatusPanel);
		this.remove(battleCommandSelectPanel);
		this.remove(battleEnemySelectPanel);
		this.remove(battleUseItemPanel);
		this.remove(battleSkillCheckPanel);
		this.add(battleLogPanel);
		battleLogPanel.requestFocus();
		this.repaint();
	}
	
	//  ログパネルを消してコマンドパネルとステータスパネルを表示
	public void displayCommandSelectPanel() {
		this.remove(battleUseItemPanel);
		this.remove(battleLogPanel);
		this.remove(battleEnemySelectPanel);
		this.add(battleCommandSelectPanel);
		this.add(battleDisplayStatusPanel);
		battleCommandSelectPanel.requestFocus();
		BattleDisplayStatusPanel.setLabels();
		this.repaint();
	}
	
	//  アイテム使用パネルを表示
	public void displayUseItemPanel() {
		this.remove(battleDisplayStatusPanel);
		this.add(battleUseItemPanel);
		BattleUseItemPanel.setItemLabel();
		BattleUseItemPanel.setSelectedLabel();
		battleUseItemPanel.requestFocus();
		this.repaint();
	}
	
	//  スキルチェックパネルを表示
	public void displaySkillCheckPanel() {
		this.remove(battleLogPanel);
		this.add(battleSkillCheckPanel);
		battleSkillCheckPanel.requestFocus();
		this.repaint();
	}
	
	//  ゲッター
	public static JPanel getBattleLogPanel() {
		return battleLogPanel;
	}
	public static BattleCommandSelectPanel getBattleCommandSelectPanel() {
		return battleCommandSelectPanel;
	}
	public static BattleDisplayStatusPanel getBattleDisplayStatusPanel() {
		return battleDisplayStatusPanel;
	}
	public static BattleEnemySelectPanel getBattleEnemySelectPanel() {
		return battleEnemySelectPanel;
	}
	public static BattleSkillCheckPanel getBattleSkillCheckPanel() {
		return battleSkillCheckPanel;
	}
	public static BattleEnemyImagePanel getBattleEnemyImagePanel() {
		return battleEnemyImagePanel;
	}




	//  セッター
	public static void setBattleLogPanel(BattleLogPanel battleLogPanel) {
		BattlePanel.battleLogPanel = battleLogPanel;
	}
	public static void setBattleCommandSelectPanel(BattleCommandSelectPanel battleCommandSelectPanel) {
		BattlePanel.battleCommandSelectPanel = battleCommandSelectPanel;
	}
	public static void setBattleDisplayStatusPanel(BattleDisplayStatusPanel battleDisplayStatusPanel) {
		BattlePanel.battleDisplayStatusPanel = battleDisplayStatusPanel;
	}
	public static void setBattleEnemySelectPanel(BattleEnemySelectPanel battleEnemySelectPanel) {
		BattlePanel.battleEnemySelectPanel = battleEnemySelectPanel;
	}
	public static void setBattleSkillCheckPanel(BattleSkillCheckPanel battleSkillCheckPanel) {
		BattlePanel.battleSkillCheckPanel = battleSkillCheckPanel;
	}
	public static void setBattleEnemyImagePanel(BattleEnemyImagePanel battleEnemyImagePanel) {
		BattlePanel.battleEnemyImagePanel = battleEnemyImagePanel;
	}
}
