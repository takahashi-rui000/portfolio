package swingRpg;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class FieldItemPanel extends JPanel implements KeyListener{
	final private static Font FONT = new Font(Font.SERIF, Font.PLAIN, 20);
	private static JLabel[] itemLabel;
	private static JLabel selectedLabel;
	private static int selectedNum = 0;
	private static ArrayList<Integer> itemIds;
	
	FieldItemPanel(){
		this.setLayout(null);
		this.setBounds(150, 0, 250, 300);
		this.setBackground(Color.black);
		this.setBorder(new LineBorder(Color.white, 1));
		this.addKeyListener(this);
		itemIds = new ArrayList<>();
		
		this.prepareItemLabel();
		this.prepareSelectedLabel();
	}
	
	//  アイテムラベル準備
	private void prepareItemLabel() {
		itemLabel = new JLabel[8];
		for(int i=0; i < itemLabel.length ; i++) {
			itemLabel[i] = new JLabel();
		}
	}
	
	
	//  選択ラベル準備
	private void prepareSelectedLabel() {
		selectedLabel = new JLabel("");
		selectedLabel.setBackground(Color.white);
		selectedLabel.setOpaque(true);
		this.add(selectedLabel);
	}
	
	private static void updateItemIds() {
		itemIds.clear();
		for(int i=0; i <= 49; i++) {
			if(BattleSystem.getPlayer().getItemNum(i) > 0) {
				itemIds.add(i);
			}
		}
	}
	
	//  ラベル設定
	public void setLabel() {
		for(JLabel l : itemLabel) {
			this.remove(l);
		}
		
		updateItemIds();
		
		if(itemIds.size() == 0) {
			for(int i=0; i < 2 ; i++) {
				itemLabel[i].setFont(FONT);
				itemLabel[i].setForeground(Color.white);
				itemLabel[i].setBounds(30, 10 + (i * 35), 240, 23);
				this.add(itemLabel[i]);
			}
			itemLabel[0].setText("アイテムがありません");
			itemLabel[1].setText("（´・ω・｀）");
		}else {
			for(int i=0; i < itemIds.size() ; i++) {
				itemLabel[i].setText(BattleSystem.getPlayer().getItemNum(itemIds.get(i)) + "  x  " + Items.getItemName(itemIds.get(i)));
				itemLabel[i].setFont(FONT);
				itemLabel[i].setForeground(Color.white);
				itemLabel[i].setBounds(20, 10 + (i * 35), 240, 23);
				this.add(itemLabel[i]);
			}
		}
	}
	
	//  選択ラベル設定
	public static void setSelectionLabel() {
		System.out.println(selectedNum);
		selectedLabel.setBounds(5, 13 + (selectedNum * 35), 10, 20);
	}
	
	//  選択ラベル動かす
	private static void moveSelectionLabel(KeyEvent e) {
		switch(e.getKeyCode()) {
		case 38:
			if(selectedNum == 0) {
				selectedNum = itemIds.size() - 1;
			}else {
				selectedNum--;
			}
			break;
		case 40:
			if(selectedNum == itemIds.size() - 1) {
				selectedNum = 0;
			}else {
				selectedNum++;
			}
		}
		setSelectionLabel();
	}
	
	private static void escPressed() {
		FieldPanel.getFieldStatusSelectPanel().requestFocus();
		selectedLabel.setBounds(0, 0, 0, 0);
	}
	
	private static void pressedEnter() {
		FieldSystem.heal(itemIds.get(selectedNum));
	} 
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == 38 || e.getKeyCode() == 40) {
			moveSelectionLabel(e);
		}else if(e.getKeyCode() == 27) {
			escPressed();
		}else if(e.getKeyCode() == 10) {
			pressedEnter();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
	
	
	
}
