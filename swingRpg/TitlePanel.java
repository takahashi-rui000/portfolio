package swingRpg;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class TitlePanel extends JPanel{
	final private static Font FONT70 = new Font(Font.SERIF, Font.PLAIN, 70);
	private static int panelMode = 0;
	private static JLabel titleLabel;
	private static TitleSelectModePanel titleSelectModePanel;
	private static TitlePlayerNamePanel titlePlayerNamePanel;
	
	TitlePanel(){
		this.setLayout(null);
		this.setBackground(Color.black);
		this.setBounds(0,0,800+8,600+36);
		
		this.prepareLabels();
		
		titleSelectModePanel = new TitleSelectModePanel();
		titlePlayerNamePanel = new TitlePlayerNamePanel();
		
		this.add(titleSelectModePanel);
	}
	
	private void prepareLabels() {
		titleLabel = new JLabel();
		titleLabel.setFont(FONT70);
		titleLabel.setBounds(150, 100, 500, 75);
		titleLabel.setForeground(Color.white);
		titleLabel.setText("SWING RPG");
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
//		titleLabel.setBorder(new LineBorder(Color.white, 1));
		this.add(titleLabel);
	}
	
	//  画面切り替え
	public void switchPanel() {
		switch(panelMode) {
		case 0:
			this.remove(titleSelectModePanel);
			this.add(titlePlayerNamePanel);
			this.repaint();
			panelMode = 1;
			break;
		case 1:
			this.remove(titlePlayerNamePanel);
			this.add(titleSelectModePanel);
			titleSelectModePanel.requestFocus();
			this.repaint();
			panelMode = 0;
		}
	}
	
	//  ゲッター
	public static TitleSelectModePanel getTitleSelectModePanel() {
		return titleSelectModePanel;
	}
	
	//  セッター
	public static void setTitleSelectModePanel(TitleSelectModePanel titleSelectModePanel) {
		TitlePanel.titleSelectModePanel = titleSelectModePanel;
	}
	
}
