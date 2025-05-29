package swingRpg;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class BattleDisplayStatusPanel extends JPanel{
	private static final Font FONT = new Font(Font.SERIF, Font.PLAIN, 35);
	private static JLabel hpLabel;
	private static JLabel nameLabel;
	
	BattleDisplayStatusPanel(){
		this.setLayout(null);
		this.setBounds(240,375,530,200);
		this.setBackground(Color.BLACK);
		this.setBorder(new LineBorder(Color.white, 1));
		
		this.prepareLabels();
	}
	
	private void prepareLabels() {
		nameLabel = new JLabel();
		nameLabel.setBounds(20, 20, 200, 50);
		nameLabel.setText("HERO");
		nameLabel.setForeground(Color.white);
		nameLabel.setFont(FONT);
		hpLabel = new JLabel();
		hpLabel.setBounds(20, 70, 400, 60);
		hpLabel.setText("HP : " + BattleSystem.getPlayer().getCurrentHp() + " / " + BattleSystem.getPlayer().getMaxHp());
		hpLabel.setForeground(Color.white);
		hpLabel.setFont(FONT);
		
		this.add(hpLabel);
		this.add(nameLabel);
	}
	
	public static void setLabels() {
		nameLabel.setText(BattleSystem.getPlayer().getName());
		hpLabel.setText("HP : " + BattleSystem.getPlayer().getCurrentHp() + " / " + BattleSystem.getPlayer().getMaxHp());
	}
}
