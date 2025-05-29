package swingRpg;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class BattleEnemyImagePanel extends JPanel{
	private static JLabel[] enemyImages;
	
	BattleEnemyImagePanel(){
		this.setBounds(20, 50, 750, 300);
		this.setLayout(null);
		this.setBackground(Color.black);
		
		prepareLabels();
		for(int i=0; i < enemyImages.length; i++) {
			this.add(enemyImages[i]);
		}
	}
	
	private static void prepareLabels() {
		enemyImages = new JLabel[3];
		for(int i=0; i < enemyImages.length; i++) {
			enemyImages[i] = new JLabel();
		}
	}
	
	public static void setEnemyImages(Character_Enemy ... enemy) {
		enemyImages[1].setIcon(null);
		enemyImages[2].setIcon(null);
		for(int i=0; i < enemy.length; i++) {
			enemyImages[i].setIcon(enemy[i].getIcon());
		}
		switch(enemy.length) {
		case 1:
			enemyImages[0].setBounds(275, 50, 200, 200);
			enemyImages[0].setIcon(enemy[0].getIcon());
			break;
		case 2:
			enemyImages[0].setBounds(150, 50, 200, 200);
			enemyImages[1].setBounds(400, 50, 200, 200);
			break;
		case 3:
			enemyImages[0].setBounds(0, 50, 200, 200);
			enemyImages[1].setBounds(275, 50, 200, 200);
			enemyImages[2].setBounds(550, 50, 200, 200);
		}
	}
	
	public void deleteEnemyImage() {
		for(int i=0; i < BattleSystem.getEnemys().length; i++) {
			if(!BattleSystem.getEnemys()[i].isAlive()) {
				enemyImages[i].setIcon(null);
			}
		}
	}
	
}
