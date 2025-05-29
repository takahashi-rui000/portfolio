package swingRpg;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class BattleCommandSelectPanel extends JPanel implements KeyListener{
	private static final Font FONT = new Font(Font.SERIF, Font.PLAIN, 35);
	private static JLabel[] commandLabel;
	private static int selectedNum = 0;
	private static JLabel selectedLabel;
	
	BattleCommandSelectPanel(){
		this.setBounds(20,375,200,200);
		this.setLayout(null);
		this.setBackground(Color.black);
		this.setBorder(new LineBorder(Color.white, 1));
		this.addKeyListener(this);
		
		this.prepareCommandLabels();
		this.prepareSelectedLabel();
	}
	
	private void prepareCommandLabels() {
		commandLabel = new JLabel[3];
		for(int i=0; i < commandLabel.length; i++) {
			commandLabel[i] = new JLabel();
			commandLabel[i].setFont(FONT);
			commandLabel[i].setBounds(40, 20+(62 * i), 150, 35);
			commandLabel[i].setForeground(Color.white);
			this.add(commandLabel[i]);
		}
		commandLabel[0].setText("たたかう");
		commandLabel[1].setText("かいふく");
		commandLabel[2].setText("にげる");
	}
	
	private void prepareSelectedLabel() {
		selectedLabel = new JLabel();
		selectedLabel.setBounds(15, 23+(62*0), 20, 32);
		selectedLabel.setOpaque(true);
		selectedLabel.setBackground(Color.white);
		this.add(selectedLabel);
	}
	
	private static void setSelectedLabel() {
		selectedLabel.setBounds(15, 23+(62*selectedNum), 20, 32);
	}
	
	private static void moveSelectedLabel(KeyEvent e) {
		switch(e.getKeyCode()) {
		case 38:
			if(selectedNum == 0) {
				selectedNum = 2;
			}else {
				selectedNum--;
			}
			break;
		case 40:
			if(selectedNum == 2) {
				selectedNum = 0;
			}else {
				selectedNum++;
			}
			break;
		}
		setSelectedLabel();
	}
	
	private static void enterPressed() {
		switch(selectedNum) {
		case 0:
			MainWindow.getBattlePanel().displayEnemySelectPanel();
			break;
		case 1:
			MainWindow.getBattlePanel().displayUseItemPanel();
			break;
		case 2:
			selectedNum = 0;
			setSelectedLabel();
			BattleSystem.run();
			break;
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == 38 || e.getKeyCode() == 40) {
			moveSelectedLabel(e);
		}else if(e.getKeyCode() == 10) {
			enterPressed();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

}
