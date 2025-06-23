package swingRpg;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class FieldStatusPanel extends JPanel implements ActionListener{
	final private static ImageIcon statusButtonImage = new ImageIcon("./images\\sozai\\statusButton.jpg");
	final private static Font FONT = new Font(Font.SERIF, Font.PLAIN, 20);
	private static JLabel[] statusLabel;
	private static JButton[] statusUpButton;
	
	FieldStatusPanel(){
		this.setLayout(null);
		this.setBounds(150, 0, 250, 300);
		this.setBackground(Color.black);
		this.setBorder(new LineBorder(Color.white, 1));
		
		this.prepareStatusLabel();
		this.prepareStatusUpButton();
		setStatusLabel();
	}
	
	private void prepareStatusLabel() {
		statusLabel = new JLabel[8];
		for(int i=0; i < statusLabel.length; i++) {
			statusLabel[i] = new JLabel(i + "番目");
			statusLabel[i].setFont(FONT);
			statusLabel[i].setBounds(10, 10 + (i * 35), 140, 23);
			statusLabel[i].setForeground(Color.white);
			this.add(statusLabel[i]);
		}
		statusLabel[0].setBounds(10, 10, 300, 23);
	}
	
	private void prepareStatusUpButton() {
		statusUpButton = new JButton[4];
		for(int i=0; i < statusUpButton.length; i++) {
			statusUpButton[i] = new JButton("ポイント使用");
			statusUpButton[i].setBounds(160, 10 + ((i+1) * 35), 80, 23);
			statusUpButton[i].addActionListener(this);
			statusUpButton[i].setActionCommand(i+"");
			statusUpButton[i].setBorder(new LineBorder(Color.white, 1));
			statusUpButton[i].setForeground(Color.white);
			statusUpButton[i].setBackground(Color.black);
			this.add(statusUpButton[i]);
		}
	}
	
	public static void setStatusLabel() {
		
		statusLabel[0].setText(BattleSystem.getPlayer().getName() + "  Lv." + BattleSystem.getPlayer().getLevel());
		statusLabel[1].setText("体力    " + BattleSystem.getPlayer().getCurrentHp() + " / " + BattleSystem.getPlayer().getMaxHp());
		statusLabel[2].setText("攻撃力  " + BattleSystem.getPlayer().getAttack());
		statusLabel[3].setText("素早さ  " + BattleSystem.getPlayer().getAgility());
		statusLabel[4].setText("防御力  " + BattleSystem.getPlayer().getDefence());
		statusLabel[5].setText("EXP：" + BattleSystem.getPlayer().getExp() + " / " + BattleSystem.getPlayer().getNextLevelExp());
		statusLabel[6].setText("所持G：" + BattleSystem.getPlayer().getGold());
		statusLabel[7].setText("ポイント" + BattleSystem.getPlayer().getStatusPoint());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		BattleSystem.getPlayer().statusUp(Integer.parseInt(e.getActionCommand()));
		MainWindow.getFieldPanel().repaint();
		FieldPanel.getFieldStatusSelectPanel().requestFocus();
	}
	
}
