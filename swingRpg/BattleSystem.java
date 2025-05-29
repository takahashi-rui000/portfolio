package swingRpg;

import java.util.ArrayList;

public class BattleSystem {
	
	private static ArrayList<Character> attackOrder = new ArrayList<>();
	private static Character_Player player = new Character_Player();
	private static int attackCount=0;
	private static Character_Enemy[] enemys;
	
	//  敵配列に入れる
	public static void containEnemys(Character ... enemy) {
		enemys = new Character_Enemy[enemy.length];
		for(int i=0; i < enemy.length; i++) {
			enemys[i] = (Character_Enemy) enemy[i];
		}
	}
	
	//  戦闘に関するアレコレ
	public static void battleObserver() {
		BattlePanel.getBattleEnemyImagePanel().deleteEnemyImage();
		
		BattleLogPanel.clearLogLabel();
		if( getAttackOrder().size() == 0 ) {
			if(battleEndJudge()) {
				battleEnd();
			}else {
				MainWindow.getBattlePanel().displayCommandSelectPanel();
			}
		}else if(!BattleLogPanel.isAttack()) {
			if(BattleSystem.getAttackOrder().get(0).isAlive()) {
				BattleLogPanel.addBattleLogTextArr(attackOrder.get(0).getName() + "の攻撃！");
				BattleLogPanel.roadLogLabelArr();
				BattleLogPanel.setAttack(true);
			}else {
				BattleSystem.getAttackOrder().remove(0);
			}
		}else {
//			 全員の行動が終わっていたら、バトル終了か判定する
				if( getAttackOrder().get(0).isAlive() ) {
					attack(enemys[BattleEnemySelectPanel.getSelectedNum()]);
				}else {
//					BattleLogPanel.setTargetNum(BattleLogPanel.getTargetNum()+1);
					attackOrder.remove(0);
				}
			BattleEnemySelectPanel.setEnemyLabel();
		}

	}
	
	//  バトル終了判定
	public static boolean battleEndJudge() {
		switch(BattleSystem.getEnemys().length) {
		case 1:
			if( !player.isAlive() || !BattleSystem.getEnemys()[0].isAlive() ) {
				return true;
			}
			break;
		case 2:
			if( !player.isAlive() || (!BattleSystem.getEnemys()[0].isAlive() && !BattleSystem.getEnemys()[1].isAlive() ) ) {
				return true;
			}
			break;
		case 3:
			if( !player.isAlive() || !BattleSystem.getEnemys()[0].isAlive() && !BattleSystem.getEnemys()[1].isAlive() && !BattleSystem.getEnemys()[2].isAlive()) {
				return true;
			}
		}
		return false;
	}
	
	//  バトル終了
	private static void battleEnd() {
		if(player.isAlive()) {
			boolean boss = false;
			for(Character_Enemy enemy : enemys) {
				if(enemy instanceof Character_Enemy_Boss) {
					boss = true;
					bossFlagManagement(enemy);
				}
			}
			if(boss) {
				
			}
			BattleEnemySelectPanel.setSelectedNum(0);
			BattleDisplayStatusPanel.setLabels();
			BattleLogPanel.addBattleLogTextArr("敵をやっつけた！");
			int exp = 0;
			for(Character_Enemy e : enemys) {
				exp += e.getExp();
			}
			BattleLogPanel.addBattleLogTextArr("EXPとGを " + exp + " 手に入れた！");
			BattleLogPanel.setBattleEnd(true);
			BattleSystem.getPlayer().calculateExp(exp);
			player.setGold(player.getGold() + exp);
//			BattleLogPanel.roadBattleEndLog();
		}else {
			BattleLogPanel.addBattleLogTextArr("");
			BattleLogPanel.addBattleLogTextArr("死んでしまった！");
			BattleLogPanel.setBattleEnd(true);
			FieldSystem.die();
//			BattleLogPanel.roadBattleEndLog();
		}
	}
	
	private static void bossFlagManagement(Character_Enemy boss) {
		if(boss instanceof Character_Enemy_Boss_Slime) {
			FieldSystem.setBossFlag(true, 0);
		}else if(boss instanceof Character_Enemy_Boss_Goblin) {
			FieldSystem.setBossFlag(true, 1);
		}else if(boss instanceof Character_Enemy_Boss_Seiryu) {
			FieldSystem.setBossFlag(true, 2);
		}else if(boss instanceof Character_Enemy_Boss_Genbu) {
			FieldSystem.setBossFlag(true, 3);
		}else if(boss instanceof Character_Enemy_Boss_Byakko) {
			FieldSystem.setBossFlag(true, 4);
		}else if(boss instanceof Character_Enemy_Boss_Suzaku) {
			FieldSystem.setBossFlag(true, 5);
		}else if(boss instanceof Character_Enemy_Boss_Mao) {
			FieldSystem.setBossFlag(true, 6);
			FieldSystem.gameClear();
		}
		FieldSystem.adaptField(FieldSystem.getCurrentFieldIndex());
	}
	
	//  攻撃
	public static void attack(Character target) {
		BattleLogPanel.setAttack(false);
//		if(attackOrder.get(0) instanceof Character_Enemy) {
//			攻撃側のクラスがEnemyならプレイヤーを対象に攻撃
//			attackOrder.get(0).attack(player);
		BattlePanel.getBattleSkillCheckPanel().startSkillCheck();
//		}else {
//			敵以外の攻撃なら選択された相手を攻撃
//			attackOrder.get(0).attack(target);
//			BattlePanel.getBattleSkillCheckPanel().startSkillCheck();
//		}
//		attackOrder.remove(0);
	}
	
	//  素早さ比較して配列に入れる
	public static void comparisonSpeed(boolean rest, Character ... inpArr) {
		Character[] c;
		if(!rest) {
			c = new Character[inpArr.length+1];
			for(int i=0; i < inpArr.length; i++) {
				c[i] = inpArr[i];
			}
			c[c.length-1] = player;
		}else {
			c = inpArr;
		}
		
		boolean[] jud = new boolean[c.length];
		int index = 0;
		int max = -1;
		for(int i=0; i < c.length; i++) {
			index = 0;
			max = 0;
			for(int j=0; j < c.length; j++) {
				if(!jud[j]) {
					if(max < c[j].getAgility()) {
						index = j;
						max = c[j].getAgility();
					}
				}
			}
			jud[index] = true;
			if(c[index].isAlive()) {
				attackOrder.add(c[index]);
			}
		}
	}
	
	//  回復
	public static void heal(int index) {
		if(BattleSystem.getPlayer().getCurrentHp() + Items.getItemEffect(index) > BattleSystem.getPlayer().getMaxHp()) {
			BattleSystem.getPlayer().setCurrentHp(BattleSystem.getPlayer().getMaxHp());
		}else {
			BattleSystem.getPlayer().setCurrentHp(BattleSystem.getPlayer().getCurrentHp() + Items.getItemEffect(index));
		}
		BattleLogPanel.addBattleLogTextArr(BattleSystem.getPlayer().getName() + "は、" + Items.getItemEffect(index) + "回復した！");
		comparisonSpeed(true, enemys);
		BattleSystem.getPlayer().reduceItem(index);
		MainWindow.getBattlePanel().displayLogPanel();
	}
	
	//  逃げる
	public static void run() {
		boolean boss = false;
		for(Character_Enemy enemy : enemys) {
			if(enemy instanceof Character_Enemy_Boss) {
				boss = true;
			}
		}
		if(boss) {
			BattleLogPanel.addBattleLogTextArr("ボスからは逃げられない！");
			comparisonSpeed(true, enemys);
			MainWindow.getBattlePanel().displayLogPanel();
		}else {
			if(new java.util.Random().nextBoolean()) {
				BattleLogPanel.setBattleEnd(true);
				BattleLogPanel.addBattleLogTextArr("逃げるのに成功した！");
				MainWindow.getBattlePanel().displayLogPanel();
				BattleLogPanel.roadBattleEndLog();
			}else {
				BattleLogPanel.addBattleLogTextArr("回り込まれた！");
				comparisonSpeed(true, enemys);
				MainWindow.getBattlePanel().displayLogPanel();
			}
		}
	}
	
	//  ゲッター
	public static Character_Player getPlayer() {
		return player;
	}
	public static ArrayList<Character> getAttackOrder() {
		return attackOrder;
	}
	public static int getAttackCount() {
		return attackCount;
	}
	public static Character[] getEnemys() {
		return enemys;
	}
	//  セッター
	public static void setPlayer(Character_Player player) {
		BattleSystem.player = player;
	}
	public static void setAttackOrder(ArrayList<Character> attackOrder) {
		BattleSystem.attackOrder = attackOrder;
	}
	public static void setAttackCount(int attackCount) {
		BattleSystem.attackCount = attackCount;
	}
	public static void setEnemys(Character_Enemy[] enemys) {
		BattleSystem.enemys = enemys;
	}
}
