package swingRpg;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class FieldSideInfoPanel extends JPanel{
	final private static Font FONT = new Font(Font.SERIF, Font.PLAIN, 30);
	private static JLabel hpLabel;
	private static JLabel nameLabel;
	private static JLabel goldLabel;
		
	FieldSideInfoPanel(){ 
		this.setLayout(null);
		this.setBounds(10,10,260,110);
		this.setBackground(new Color(0,0,0,185));
		this.setBorder(new LineBorder(Color.white, 2));
		
		prepareLabels();
		this.add(hpLabel);
		this.add(nameLabel);
		this.add(goldLabel);
	}
	
	//  情報パネルの中のラベルを準備
	private static void prepareLabels() {
		nameLabel = new JLabel();
		nameLabel.setBounds(5,5,260,32);
		nameLabel.setFont(FONT);
		nameLabel.setForeground(Color.white);
		hpLabel = new JLabel();
		hpLabel.setBounds(5,33,300,32);
		hpLabel.setFont(FONT);
		hpLabel.setForeground(Color.white);
		goldLabel = new JLabel();
		goldLabel.setBounds(5, 61, 150, 32);
		goldLabel.setFont(FONT);
		goldLabel.setForeground(Color.white);
	}
	
	//  情報ラベルの中身を更新
	public static void setLabels(Character c) {
		nameLabel.setText(c.getName() + "Lv." + BattleSystem.getPlayer().getLevel());
		hpLabel.setText("HP  " + c.getCurrentHp() + " / " + c.getMaxHp());
		goldLabel.setText("G  " + Integer.valueOf(BattleSystem.getPlayer().getGold()));
		
	}
}
