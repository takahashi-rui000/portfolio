package swingRpg;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class BattleLogPanel extends JPanel implements KeyListener{
	final private static Font FONT = new Font(Font.SERIF, Font.PLAIN, 30);
	
	private static ArrayList<String> textArr = new ArrayList<>();
	private static JLabel[] battleLogLabel;
	private static boolean battleEnd = false;
	private static boolean attack = false;
	
	private static int targetNum=0;
	
	BattleLogPanel(){
		
		this.setBounds(25, 375, 750, 200);
		this.setBackground(Color.black);
		this.setBorder(new LineBorder(Color.white, 2));
		this.setLayout(null);
		this.addKeyListener(this);
		
		this.prepareLogArr();
	}
	
	//  ログパネルに入れるJLabelの配列を準備
	public void prepareLogArr() {
		battleLogLabel = new JLabel[3];
		for(int i=0; i < battleLogLabel.length; i++) {
			battleLogLabel[i] = new JLabel();
			battleLogLabel[i].setPreferredSize(new Dimension(700, 50));
			battleLogLabel[i].setBounds(40, 25+(i * 50), 760, 50);
			battleLogLabel[i].setFont(FONT);
			battleLogLabel[i].setForeground(Color.white);
		}
		for(JLabel l : battleLogLabel) {
			this.add(l);
		}
	}
	


	//  読み込む可変長配列に文字列をadd
	public static void addBattleLogTextArr(String text) {
		textArr.add(text);
	}
	
	//  中身をクリア
	public static void clearLogLabel() {
		battleLogLabel[0].setText("");
		battleLogLabel[1].setText("");
		battleLogLabel[2].setText("");
	}
	
	//  文字列型の可変長配列の文字列をログラベルにセットする サイズ０ならバトルメソッド呼び出し
	public static void roadLogLabelArr() {
		if(textArr.size() == 0) {
			battleLogLabel[0].setText("");
			battleLogLabel[1].setText("");
			battleLogLabel[2].setText("");
			BattleSystem.battleObserver();
		}else {
			battleLogLabel[0].setText(battleLogLabel[1].getText());
			battleLogLabel[1].setText(battleLogLabel[2].getText());
			battleLogLabel[2].setText(textArr.get(0));
			textArr.remove(0);
		}
	}
	
	//  バトル終了後のログ読み込み
	public static void roadBattleEndLog() {
		if(textArr.size() > 0) {
			battleLogLabel[0].setText(battleLogLabel[1].getText());
			battleLogLabel[1].setText(battleLogLabel[2].getText());
			battleLogLabel[2].setText(textArr.get(0));
			textArr.remove(0);
		}else {
			battleLogLabel[0].setText("");
			battleLogLabel[1].setText("");
			battleLogLabel[2].setText("");
			battleEnd = false;
			MainWindow.getBattlePanel().displayCommandSelectPanel();
			Observer.getMainWindow().setFrontPanelAndFocus(ScreenMode.FIELD);
		}
	}
	
	//  ゲッター
	public static ArrayList<String> getTextArr() {
		return textArr;
	}
	public static JLabel[] getBattleLogLabel() {
		return battleLogLabel;
	}
	public static int getTargetNum() {
		return targetNum;
	}
	public static boolean isBattleEnd() {
		return battleEnd;
	}
	public static boolean isAttack() {
		return attack;
	}



	//  セッター
	public static void setTextArr(ArrayList<String> textArr) {
		BattleLogPanel.textArr = textArr;
	}
	public static void setBattleLogLabel(JLabel[] battleLogLabel) {
		BattleLogPanel.battleLogLabel = battleLogLabel;
	}
	public static void setTargetNum(int targetNum) {
		BattleLogPanel.targetNum = targetNum;
	}
	public static void setBattleEnd(boolean battleEnd) {
		BattleLogPanel.battleEnd = battleEnd;
	}
	public static void setAttack(boolean attack) {
		BattleLogPanel.attack = attack;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(!battleEnd) {
			roadLogLabelArr();
		}else {
			roadBattleEndLog();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
}
