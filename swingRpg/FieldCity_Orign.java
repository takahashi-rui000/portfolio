package swingRpg;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public abstract class FieldCity_Orign extends JPanel implements KeyListener{
	private JLabel[] shop;
	private JLabel selectedLabel;
	final private static Font FONT = new Font(Font.SERIF, Font.PLAIN, 30);
	
	FieldCity_Orign(){
		this.setBounds(500, 50, 280, 350);
		this.setLayout(null);
		this.setBackground(Color.black);
		this.setBorder(new LineBorder(Color.white, 1));
		prepareSelectedLabel();
	}
	
	public void prepareShop(String ...s) {
		shop = new JLabel[s.length];
		for(int i=0; i < shop.length; i++) {
			shop[i] = new JLabel(s[i]);
			shop[i].setForeground(Color.white);
			shop[i].setFont(FONT);
			shop[i].setBounds(40, 10 + (i * 35), 200, 32);
			this.add(shop[i]);
		}
	}
	
	public void prepareSelectedLabel() {
		selectedLabel = new JLabel();
		selectedLabel.setBounds(15, 12, 20, 30);
		selectedLabel.setOpaque(true);
		selectedLabel.setBackground(Color.white);
		this.add(selectedLabel);
	}
	
	public abstract void shopManagement();
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
}
