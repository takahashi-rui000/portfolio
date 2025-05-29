package swingRpg;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class FieldCity_Origin extends JPanel{
	private int cityIndex = -1;
	private JLabel[] shop;
	private int shopItemIndex[];
	private JLabel selectedLabel;
	private int selectedNum=0;
	final private static Font FONT = new Font(Font.SERIF, Font.PLAIN, 20);
	
	FieldCity_Origin(int cityIndex){
		this.cityIndex = cityIndex;
		this.setBounds(450, 50, 330, 350);
		this.setLayout(null);
		this.setBackground(Color.black);
		this.setBorder(new LineBorder(Color.white, 1));
		prepareSelectedLabel();
	}
	
	public void prepareShop(int ... index) {
		shop = new JLabel[index.length+1];
		this.shopItemIndex = new int[index.length];
		for(int i=0; i < shop.length; i++) {
			if(i == shop.length-1) {
				shop[i] = new JLabel("外へ出る");
			}else {
				this.shopItemIndex[i] = index[i];
				shop[i] = new JLabel(String.format("%5dG  " + Items.getItemName(index[i]), Items.getItemValue(index[i]) ) );
			}
			shop[i].setForeground(Color.white);
			shop[i].setFont(FONT);
			shop[i].setBounds(20, 10 + (i * 35), 290, 32);
			this.add(shop[i]);
		}
	}
	
	public void prepareSelectedLabel() {
		selectedLabel = new JLabel();
		selectedLabel.setBounds(5, 12, 10, 18);
		selectedLabel.setOpaque(true);
		selectedLabel.setBackground(Color.white);
		this.add(selectedLabel);
	}
	
	//  選択ラベル再表示
	public void repaintSelecteLabel() {
		this.selectedLabel.setBounds(5, 20 + this.selectedNum * 35, 10, 18);
	}
	
	//  選択ラベルを動かす
	public void moveSelectedLabel(KeyEvent e) {
		switch(e.getKeyCode()) {
		case 38:
			if(this.selectedNum == 0) {
				this.selectedNum = this.shop.length-1;
			}
			else {
				this.selectedNum--;
			}
			break;
		case 40:
			if(this.selectedNum == this.shop.length-1) {
				this.selectedNum = 0;
			}
			else {
				this.selectedNum++;
			}
		}
		this.repaintSelecteLabel();
	}
	
	public void enterPressed() {
		if(this.selectedNum == this.shop.length-1) {
			this.selectedNum = 0;
			this.repaintSelecteLabel();
			FieldSystem.outCity(cityIndex);
		}else {
			FieldSystem.buy(this.shopItemIndex[this.selectedNum]);
		}
	}
	
	public void escPressed() {
		System.out.println("city"+cityIndex);
		FieldSystem.outCity(cityIndex);
	}
}
