package swingRpg;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class BattleEnemySelectPanel extends JPanel implements KeyListener{
	private static final Font FONT = new Font(Font.SERIF, Font.PLAIN, 30);
	private static JLabel[] enemyLabel;
	private static JLabel selectedLabel;
	private static int selectedNum = 0;
	
	
	BattleEnemySelectPanel(){
		this.setBounds(240,375,530,200);
		this.setLayout(null);
		this.setBackground(Color.black);
		this.setBorder(new LineBorder(Color.white, 1));
		this.addKeyListener(this);
		
		this.prepareEnemyLabels();
		this.prepareSelectedLabel();
	}
	
	//  敵ラベルを準備
	public void prepareEnemyLabels() {
		enemyLabel = new JLabel[3];
		for(int i=0; i < enemyLabel.length; i++) {
			enemyLabel[i] = new JLabel();
			enemyLabel[i].setBounds(40, 20+(62 * i), 500, 35);
			enemyLabel[i].setForeground(Color.white);
			enemyLabel[i].setFont(FONT);
			this.add(enemyLabel[i]);
		}
	}
	
	//  選択ラベルを準備
	private void prepareSelectedLabel() {
		selectedLabel = new JLabel();
		selectedLabel.setBounds(15, 23+(62*0), 20, 32);
		selectedLabel.setOpaque(true);
		selectedLabel.setBackground(Color.white);
		this.add(selectedLabel);
	}
	
	//  敵ラベルに敵の名前を設定 HPが0ならテキストが赤くなる
	public static void setEnemyLabel() {
		for(JLabel l : enemyLabel) {
			l.setText("");
		}
		for(int i=0; i < BattleSystem.getEnemys().length; i++) {
			enemyLabel[i].setText(BattleSystem.getEnemys()[i].getName());
			enemyLabel[i].setForeground(Color.white);
		}
		switch(BattleSystem.getEnemys().clone().length) {
		case 1:
			if(!BattleSystem.getEnemys()[0].isAlive()) {
				enemyLabel[0].setForeground(Color.red);
			}
			enemyLabel[0].setText(BattleSystem.getEnemys()[0].getName());
			break;
			
		case 2:
			if(!BattleSystem.getEnemys()[0].isAlive()) {
				enemyLabel[0].setForeground(Color.red);
			}
			if(!BattleSystem.getEnemys()[1].isAlive()) {
				enemyLabel[1].setForeground(Color.red);
			}
			enemyLabel[0].setText(BattleSystem.getEnemys()[0].getName());
			enemyLabel[1].setText(BattleSystem.getEnemys()[1].getName());
			break;
			
		case 3:
			if(!BattleSystem.getEnemys()[0].isAlive()) {
				enemyLabel[0].setForeground(Color.red);
			}
			if(!BattleSystem.getEnemys()[1].isAlive()) {
				enemyLabel[1].setForeground(Color.red);
			}
			if(!BattleSystem.getEnemys()[2].isAlive()) {
				enemyLabel[2].setForeground(Color.red);
			}
		}
	}
	
	//  選択中ラベル描写
	private static void setSelectedLabel() {
		selectedLabel.setBounds(15, 23+(62*selectedNum), 20, 32);
	}
	
	//  選択ラベルの初期値設定
	public static void SelectedLabelInitialValue() {
		selectedNum = 0;
		switch(BattleSystem.getEnemys().length) {
		case 2:
			if(BattleSystem.getEnemys()[0].isAlive()) {
				selectedNum = 0;
			}else {
				selectedNum = 1;
			}
			break;
		case 3:
			if(BattleSystem.getEnemys()[0].isAlive()) {
				selectedNum = 0;
			}else if(BattleSystem.getEnemys()[1].isAlive()) {
				selectedNum = 1;
			}else {
				selectedNum = 2;
			}
		}
		setSelectedLabel();
	}
	
	//  選択中ラベル移動
	private static void moveSelectedLabel(KeyEvent e) {
		switch(e.getKeyCode()) {
		//  上入力
		case 38:
			switch(BattleSystem.getEnemys().length) {
			//  敵二体
			case 2:
				switch(selectedNum) {
				case 0:
					if(BattleSystem.getEnemys()[1].isAlive()) {
						selectedNum = 1;
					}
					break;
				case 1:
					if(BattleSystem.getEnemys()[0].isAlive()) {
						selectedNum = 0;
					}
				}
				break;
				
			//  敵三体
			case 3:
				switch(selectedNum){
				case 0:
					if(BattleSystem.getEnemys()[2].isAlive()) {
						selectedNum = 2;
					}else if(!BattleSystem.getEnemys()[2].isAlive()) {
						if(BattleSystem.getEnemys()[1].isAlive()) {
							selectedNum = 1;
						}
					}
					break;
				case 1:
					if(BattleSystem.getEnemys()[0].isAlive()) {
						selectedNum = 0;
					}else if(!BattleSystem.getEnemys()[0].isAlive()) {
						if(BattleSystem.getEnemys()[2].isAlive()) {
							selectedNum = 2;
						}
					}
					break;
				case 2:
					if(BattleSystem.getEnemys()[1].isAlive()) {
						selectedNum = 1;
					}else if(!BattleSystem.getEnemys()[1].isAlive()) {
						if(BattleSystem.getEnemys()[0].isAlive()) {
							selectedNum = 0;
						}
					}
				}
				
			}
				break;
				
		//  下入力
		case 40:
			switch(BattleSystem.getEnemys().length) {
			//  敵二体
			case 2:
				switch(selectedNum) {
				case 0:
					if(BattleSystem.getEnemys()[1].isAlive()) {
						selectedNum = 1;
					}
					break;
				case 1:
					if(BattleSystem.getEnemys()[0].isAlive()) {
						selectedNum = 0;
					}
				}
				break;
			//  敵三体
			case 3:
				switch(selectedNum){
				case 0:
					if(BattleSystem.getEnemys()[1].isAlive()) {
						selectedNum = 1;
					}else if(!BattleSystem.getEnemys()[2].isAlive()) {
						if(BattleSystem.getEnemys()[0].isAlive()) {
							selectedNum = 0;
						}
					}
					break;
				case 1:
					if(BattleSystem.getEnemys()[2].isAlive()) {
						selectedNum = 2;
					}else if(!BattleSystem.getEnemys()[2].isAlive()) {
						if(BattleSystem.getEnemys()[1].isAlive()) {
							selectedNum = 1;
						}
					}
					break;
				case 2:
					if(BattleSystem.getEnemys()[0].isAlive()) {
						selectedNum = 0;
					}else if(!BattleSystem.getEnemys()[0].isAlive()) {
						if(BattleSystem.getEnemys()[1].isAlive()) {
							selectedNum = 1;
						}
					}
				}
			}
		}
		setSelectedLabel();
	}
	
	//  ESCでコマンドパネル戻る
	private static void escPressed() {
		selectedNum = 0;
		setSelectedLabel();
		MainWindow.getBattlePanel().displayCommandSelectPanel();
	}
	
	//  ENTERで攻撃開始
	private static void enterPressed() {
        BattleSystem.comparisonSpeed(false, BattleSystem.getEnemys());
//        BattleSystem.attack(BattleSystem.getEnemys()[selectedNum]);
        MainWindow.getBattlePanel().displayLogPanel();
	}
	
	public static int getSelectedNum() {
		return selectedNum;
	}
	
	public static void setSelectedNum(int selectedNum) {
		BattleEnemySelectPanel.selectedNum = selectedNum;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO 自動生成されたメソッド・スタブ
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == 38 || e.getKeyCode() == 40) {
			moveSelectedLabel(e);
		}else if(e.getKeyCode() == 10){
			enterPressed();
		}else if(e.getKeyCode() == 27) {
			escPressed();
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

}
