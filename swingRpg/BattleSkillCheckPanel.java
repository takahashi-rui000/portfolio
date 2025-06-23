package swingRpg;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

public class BattleSkillCheckPanel extends JPanel implements KeyListener, ActionListener{
	private Timer timer = new Timer(14, this);
	private static JLabel guideLabel;
	private static JLabel runLabel;
	private static int runNum = -1;
	private static boolean critical = false;
	
	BattleSkillCheckPanel(){
		this.setBounds(25, 375, 750, 200);
		this.setBackground(Color.black);
		this.setBorder(new LineBorder(Color.white, 2));
		this.setLayout(null);
		this.addKeyListener(this);
		
		this.prepareLabels();
	}
	
	private void prepareLabels() {
		guideLabel = new JLabel();
		guideLabel.setBounds(365, 0, 20, 200);
		guideLabel.setBackground(Color.black);
		guideLabel.setOpaque(true);
		guideLabel.setBorder(new LineBorder(Color.white, 1));
		this.add(guideLabel);
		runLabel = new JLabel();
		runLabel.setBounds(0, 0, 6, 200);
		runLabel.setBackground(Color.red);
		runLabel.setOpaque(true);
		runLabel.setBorder(new LineBorder(Color.white, 1));
		this.add(runLabel);
	}
	
	//  スキルチェック開始
	public void startSkillCheck() {
		MainWindow.getBattlePanel().displaySkillCheckPanel();
		timer.start();
		this.changeBorderColor(BattleSystem.getAttackOrder().get(0));
		speedComparison(BattleSystem.getPlayer(), BattleSystem.getEnemys()[BattleEnemySelectPanel.getSelectedNum()]);
		
		runNum = 0;
	}
	
	private void pressedEnter(KeyEvent e) {
		if(runNum > -1) {
			timer.stop();
			this.setComponentZOrder(runLabel, 0);
			MainWindow.getBattlePanel().displayLogPanel();
			if(BattleSystem.getAttackOrder().get(0) instanceof Character_Player) {
				Character_Player player = (Character_Player) BattleSystem.getAttackOrder().get(0);
				player.attack(BattleSystem.getEnemys()[BattleEnemySelectPanel.getSelectedNum()], getAttackMagnification());
			}else if(BattleSystem.getAttackOrder().get(0) instanceof Character_Enemy) {
				Character_Enemy enemy = (Character_Enemy) BattleSystem.getAttackOrder().get(0);
				enemy.attack(BattleSystem.getPlayer(), getDefenceMagnification());
			}
			BattleSystem.getAttackOrder().remove(0);
		}
	}
	
	private void speedComparison(Character player, Character target) {
		double difference = player.getAgility() / target.getAgility();
		if(difference < 0.5) {
			difference = 0.5;
		}else if(difference > 1.5) {
			difference = 1.5;
		}
		timer.setDelay( (int) ( 15 * difference ) );
	}
	
	private double getAttackMagnification() {
		int differenceNum = Math.abs(36 - runNum);
		if(differenceNum == 0) {
			critical = true;
			return 2;
		}else if(differenceNum < 10) {
			return 1.2;
		}else if(differenceNum < 30) {
			return 1;
		}else if(differenceNum < 100) {
			return 0.6;
		}else {
			return 0.2;
		}
	}
	
	private double getDefenceMagnification() {
		int differenceNum = Math.abs(36 - runNum);
		if(differenceNum == 0) {
			critical = true;
			return 0.5;
		}else if(differenceNum < 10) {
			return 0.8;
		}else if(differenceNum < 20) {
			return 1;
		}else if(differenceNum < 30) {
			return 1.25;
		}else if(differenceNum < 100) {
			return 1.5;
		}else {
			return 3;
		}
	}
	
	//  攻撃クラスに合わせてボーダーの色を変更
	private void changeBorderColor(Character attacker) {
		if(attacker instanceof Character_Player) {
			this.setBorder(new LineBorder(Color.yellow, 2));
		}else if(attacker instanceof Character_Enemy) {
			this.setBorder(new LineBorder(Color.red, 2));
		}
	}
	
	//  ゲッター
	public static boolean isCritical() {
		return critical;
	}

	//  セッター
	public static void setCritical(boolean critical) {
		BattleSkillCheckPanel.critical = critical;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(runNum > -1) {
			if(runNum <= 200) {
				runNum++;
				runLabel.setBounds(runNum*10, 0, 6, 200);
				this.repaint();
			}else {
				timer.stop();
			}
		}
//		System.out.println(timer.getDelay());
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == 10) {
			this.pressedEnter(e);
			System.out.println(runNum);
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}


}
