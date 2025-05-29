package swingRpg;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class FieldEquipmentPanel extends JPanel implements KeyListener{
	final private static Font FONT = new Font(Font.SERIF, Font.PLAIN, 20);
	private static JLabel[] itemLabel;
	private static JLabel selectedLabel;
	private static int selectedNum = 0;
	private static int page = 0;
	private static ArrayList<Integer> itemIds;
	
	FieldEquipmentPanel(){
		this.setLayout(null);
		this.setBounds(150, 0, 250, 300);
		this.setBackground(Color.black);
		this.setBorder(new LineBorder(Color.white, 1));
		this.addKeyListener(this);
		
		this.prepareItemLabel();
		this.prepareSelectedLabel();
	}
	
	private void prepareItemLabel() {
		itemIds = new ArrayList<>();
		itemLabel = new JLabel[8];
		for(int i=0; i < itemLabel.length ; i++) {
			itemLabel[i] = new JLabel();
			itemLabel[i].setFont(FONT);
			itemLabel[i].setForeground(Color.white);
			itemLabel[i].setBounds(30, 10 + (i * 35), 240, 23);
			this.add(itemLabel[i]);
		}
	}
	
	private void prepareSelectedLabel() {
		selectedLabel = new JLabel();
		selectedLabel.setBounds(5, 20, 0, 0);
		selectedLabel.setBackground(Color.white);
		selectedLabel.setOpaque(true);
		
		this.add(selectedLabel);
	}
	
	//  所持中のアイテムIDを入れた可変長配列を返す
	private static void updateItemIds() {
		itemIds.clear();
		for(int i=50; i < 150; i++) {
			if(BattleSystem.getPlayer().getItemNum(i) > 0) {
				itemIds.add(i);
			}
		}
	}
	
	public void setLabel() {
		updateItemIds();
		if(itemIds.size() == 0) {
			itemLabel[0].setText("アイテムがありません");
			itemLabel[1].setText("（´・ω・｀）");
		}else {
			this.displayItems(page);
		}
	}
	
	//  装備のアイテム数に応じてページの内容切り替え
	private void displayItems(int index) {
		System.out.println("表示");
		for(int i=0; i < 8 ; i++) {
			itemLabel[i].setText("");
		}
		int max;
		if(itemIds.size() > (index * 8 + 8)) {
			max = 8;
		}else {
			max = itemIds.size() % 8;
		}
		if(itemIds.size() % 8 == 0) {
			max = 8;
		}
		System.out.println(max);
		for(int i=0; i < max ; i++) {
			if(BattleSystem.getPlayer().getEquippedWeapon() != itemIds.get(i + index * 8) && BattleSystem.getPlayer().getEquippedArmor() != itemIds.get(i + index * 8)) {
				itemLabel[i].setText(BattleSystem.getPlayer().getItemNum(itemIds.get(i + index * 8)) + "x" + Items.getItemName(itemIds.get(i + index * 8)) + "(" + Items.getItemEffect(itemIds.get(i + index * 8) ) + ")" );
			}else {
				itemLabel[i].setText(BattleSystem.getPlayer().getItemNum(itemIds.get(i + index * 8)) + "x[E]" + Items.getItemName(itemIds.get(i + index * 8)) + "(" + Items.getItemEffect(itemIds.get(i + index * 8) ) + ")" );
			}
			this.add(itemLabel[i]);
		}
	}
	
	//  選択ラベルを動かす
	private void moveSelectedLabel(KeyEvent e) {
		updateItemIds();
		switch(e.getKeyCode()) {
		case 38:
			if(itemIds.size() > page * 8 + 8 || itemIds.size() % 8 == 0) {
				if(selectedNum == 0) {
					selectedNum = 7;
				}else {
					selectedNum--;
				}
			}else {
				if(selectedNum == 0) {
					selectedNum = itemIds.size() % 8 -1;
				}else {
					selectedNum--;
				}
			}
			break;
		case 40:
			if(itemIds.size() > page * 8 + 8 || itemIds.size() % 8 == 0) {
				if(selectedNum == 7) {
					selectedNum = 0;
				}else {
					selectedNum++;
				}
			}else {
				if(selectedNum+1 == itemIds.size() % 8) {
					selectedNum = 0;
				}else {
					selectedNum++;
				}
			}
			break;
		}
		setSelectedLabel();
	}
	
	//  ページ切り替え
	private void pageSwitching(KeyEvent e) {
		switch(e.getKeyCode()) {
		case 37:
			if((page * 8 - 8 ) >= 0 ) {
				page--;
				displayItems(page);
			}
			selectedNum = 0;
			setSelectedLabel();
			break;
		case 39:
			if((page * 8 + 8) < itemIds.size() ) {
				page++;
				displayItems(page);
			}
			selectedNum = 0;
			setSelectedLabel();
			break;
		}
	}
	
	//  
	public static void setSelectedLabel() {
		selectedLabel.setBounds(5, 18 + selectedNum * 35, 10, 18);
	}
	
	//  ESCで戻る
	private static void escPressed() {
		selectedNum = 0;
		selectedLabel.setBounds(5, 18 + selectedNum * 35, 0, 0);
		FieldPanel.getFieldStatusSelectPanel().exitEquipmentPanel();
	}
	
	//  エンターで装備切り替え
	private void pressedEnter() {
		if(itemIds.get(selectedNum + page * 8) >= 50 && itemIds.get(selectedNum + page * 8) <= 99) {
			BattleSystem.getPlayer().setEquippedWeapon(itemIds.get(selectedNum + page * 8));
			FieldLogPanel.addTextArr( "武器を " + Items.getItemName(BattleSystem.getPlayer().getEquippedWeapon() ) + " ( " + Items.getItemEffect(BattleSystem.getPlayer().getEquippedWeapon()) +" ) " + "に変更しました");
		}else if(itemIds.get(selectedNum + page * 8) >= 100 && itemIds.get(selectedNum + page * 8) <= 149) {
			BattleSystem.getPlayer().setEquippedArmor(itemIds.get(selectedNum + page * 8));
			FieldLogPanel.addTextArr( "防具を " + Items.getItemName(BattleSystem.getPlayer().getEquippedArmor() ) + " ( " + Items.getItemEffect(BattleSystem.getPlayer().getEquippedArmor()) +" ) " + "に変更しました");
		}
		this.setLabel();
		this.repaint();
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == 38 || e.getKeyCode() == 40) {
			moveSelectedLabel(e);
		}else if(e.getKeyCode() == 37 || e.getKeyCode() == 39){
			pageSwitching(e);
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
