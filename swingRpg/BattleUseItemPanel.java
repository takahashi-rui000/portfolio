package swingRpg;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class BattleUseItemPanel extends JPanel implements KeyListener{
	private static final Font FONT = new Font(Font.SERIF, Font.PLAIN, 30);
	private static JLabel[] itemLabel;
	private static JLabel selectedLabel;
	private static int selectedNum = 0;
	
	BattleUseItemPanel(){
		this.setBounds(240,375,530,200);
		this.setLayout(null);
		this.setBackground(Color.black);
		this.setBorder(new LineBorder(Color.white, 1));
		this.addKeyListener(this);
		
		this.prepareItemLabels();
		this.prepareSelectedLabel();
	}
	
	//  アイテムラベル準備
	private void prepareItemLabels() {
		itemLabel = new JLabel[4];
		for(int i=0; i < itemLabel.length; i++) {
			itemLabel[i] = new JLabel();
			itemLabel[i].setFont(FONT);
			itemLabel[i].setForeground(Color.white);
			itemLabel[i].setBounds(40, 20+(40 * i), 480, 32);
			
			this.add(itemLabel[i]);
		}
	}
	
	//  選択ラベルを準備
	private void prepareSelectedLabel() {
		selectedLabel = new JLabel();
		selectedLabel.setBounds(10, 23+(40*0), 20, 30);
		selectedLabel.setOpaque(true);
		selectedLabel.setBackground(Color.white);
		this.add(selectedLabel);
	}
	
	//  アイテムラベル設定
	public static void setItemLabel() {
		itemLabel[0].setText(BattleSystem.getPlayer().getItemNum(0) + " x " + Items.getItemName(0));
		itemLabel[1].setText(BattleSystem.getPlayer().getItemNum(1) + " x " + Items.getItemName(1));
		itemLabel[2].setText(BattleSystem.getPlayer().getItemNum(2) + " x " + Items.getItemName(2));
		itemLabel[3].setText(BattleSystem.getPlayer().getItemNum(3) + " x " + Items.getItemName(3));
	}
	
	//  選択ラベルを動かす
	private void moveSelectedLabel(KeyEvent e) {
		switch(e.getKeyCode()) {
		case 38:
			if(selectedNum == 0) {
				selectedNum = 3;
			}else {
				selectedNum--;
			}
			break;
		case 40:
			if(selectedNum == 3) {
				selectedNum = 0;
			}else {
				selectedNum++;
			}
			break;
		}
		setSelectedLabel();
	}
	
	//  選択中ラベル描写
	public static void setSelectedLabel() {
		selectedLabel.setBounds(10, 20+(40*selectedNum), 20, 32);
	}
	
	//  ESCで戻る 未完成
	private static void escPressed() {
		selectedNum = 0;
		selectedLabel.setBounds(5, 18 + selectedNum * 35, 0, 0);
		MainWindow.getBattlePanel().displayCommandSelectPanel();
	}
	
	//  エンター
	private void pressedEnter() {
		if(BattleSystem.getPlayer().getItemNum(selectedNum) > 0) {
			BattleSystem.heal(selectedNum);
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == 38 || e.getKeyCode() == 40) {
			moveSelectedLabel(e);
		}else if(e.getKeyCode() == 27) {
			escPressed();
		}else if(e.getKeyCode() == 10) {
			this.pressedEnter();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

}
