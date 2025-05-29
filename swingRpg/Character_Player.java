package swingRpg;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Character_Player extends Character{
	private int equippedWeapon;
	private int equippedArmor;
	private int exp;
	private int level;
	private int nextLevelExp;
	private int gold;
	private int statusPoint;
	private int items[];
	
    @JsonProperty("alive")
    private boolean alive;
	
	Character_Player() {
//		name, maxHp, attack, agility, defence
		super("勇者", 50, 30, 30, 30);
		equippedWeapon = 50;
		equippedArmor = 100;
		exp = 0;
		level = 1;
		nextLevelExp = 50;
		gold = 0;
		statusPoint = 0;
		items = new int[150];
		items[0] += 3;
		items[50]++;
		items[100]++;
	}
	
	//  レベルアップ判定
	public void calculateExp(int exp) {
		this.exp += exp;
		while(nextLevelExp <= this.exp) {
			BattleLogPanel.addBattleLogTextArr("レベルが上がった！");
			BattleLogPanel.addBattleLogTextArr(level + "→" + (level+1));
			this.level++;
			this.exp = this.exp - this.nextLevelExp;
			this.nextLevelExp = (int)(this.nextLevelExp * 1.3);
			this.levelUp();
		}
	}
	
	//  レベルアップ処理
	public void levelUp() {
		int r;
		r = new java.util.Random().nextInt(10)+4;
		this.setMaxHp(this.getMaxHp() + r);
		BattleLogPanel.addBattleLogTextArr("最大体力が" + r + "上がった！");
		r = new java.util.Random().nextInt(3)+1;
		this.setAttack(this.getAttack() + r);
		BattleLogPanel.addBattleLogTextArr("攻撃力が" + r + "上がった！");
		r = new java.util.Random().nextInt(3)+1;
		this.setAgility(this.getAgility() + r);
		BattleLogPanel.addBattleLogTextArr("素早さが" + r + "上がった！");
		r = new java.util.Random().nextInt(3)+1;
		this.setDefence(this.getDefence() + r);
		BattleLogPanel.addBattleLogTextArr("防御力が" + r + "上がった！");
		r = new java.util.Random().nextInt(3)+3;
		this.statusPoint += r;
		BattleLogPanel.addBattleLogTextArr(" ");
	}
	
	public void statusUp(int i) {
		if(this.statusPoint > 0) {
			switch(i) {
			case 0:
				this.setMaxHp( this.getMaxHp() + 5 );
				this.setStatusPoint(this.getStatusPoint() - 1);
				FieldLogPanel.addTextArr("最大体力が 5 上がった！");
				break;
			case 1:
				this.setAttack( this.getAttack() + 2 );
				this.setStatusPoint(this.getStatusPoint() - 1);
				FieldLogPanel.addTextArr("攻撃力が 2 上がった！");
				break;
			case 2:
				this.setAgility( this.getAgility() + 2 );
				this.setStatusPoint(this.getStatusPoint() - 1);
				FieldLogPanel.addTextArr("素早さが 2 上がった！");
				break;
			case 3:
				this.setDefence( this.getDefence() + 2 );
				this.setStatusPoint(this.getStatusPoint() - 1);
				FieldLogPanel.addTextArr("防御力が 2 上がった！");
			}
		}else {
			FieldLogPanel.addTextArr("ステータスポイントが足りませんでした。");
		}

	}
	
	//  攻撃
	public void attack(Character target, double magnification) {
		int damage = calculateDamage( target, magnification );
		if(BattleSkillCheckPanel.isCritical()) {
			BattleLogPanel.addBattleLogTextArr("大成功!");
			BattleSkillCheckPanel.setCritical(false);
		}
		BattleLogPanel.addBattleLogTextArr(target.getName() + "へ" +  damage + "ダメージ");
		takeDamage( target, damage );
		if(!target.isAlive()) {
			BattleLogPanel.addBattleLogTextArr(target.getName() + "を倒した！");
		}
	}
	
	//  ダメージ計算
	protected int calculateDamage(Character target, double magnification) {
		//  計算式... ( ( ( 乱数( 攻撃力 + 武器攻撃力 ) + ( 攻撃力 + 武器攻撃力 ) / 2 ) - ( 防御力 / 5 ) ) * 倍率
		int damage = (int) ( ( ( ( new java.util.Random().nextInt( (int)( this.getAttack() + Items.getItemEffect ( this.equippedWeapon ) ) ) * 0.1 ) + ( this.getAttack() + Items.getItemEffect ( this.equippedWeapon ) ) * 0.5 ) - ( target.getDefence() * 0.2 ) ) * magnification );
		if(damage > 0) {
			return damage;
		}
		return 0;
	}
	
	//  プレイヤーステータス全体変更

//	name, maxHp, attack, agility, defence
	public void setStatus(String name, int maxHp, int attack, int agility, int defence) {
		this.setName(name);
		this.setMaxHp(maxHp);
		this.setAttack(attack);
		this.setAgility(agility);
		this.setDefence(defence);
	}
	
	//  ゲッター
	public int getEquippedWeapon() {
		return equippedWeapon;
	}
	public int getEquippedArmor() {
		return equippedArmor;
	}
	public int getExp() {
		return exp;
	}
	public int getLevel() {
		return level;
	}
	public int getGold() {
		return gold;
	}
	public int getNextLevelExp() {
		return nextLevelExp;
	}
	public int getStatusPoint() {
		return statusPoint;
	}
	
	public int getItemNum(int index) {
		return items[index];
	}
	
	public int[] getItems() {
		return items;
	}

	public void setNextLevelExp(int nextLevelExp) {
		this.nextLevelExp = nextLevelExp;
	}


	//  セッター
	public void setEquippedWeapon(int equippedWeapon) {
		this.equippedWeapon = equippedWeapon;
	}
	public void setEquippedArmor(int equippedArmor) {
		this.equippedArmor = equippedArmor;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	public void setGold(int gold) {
		this.gold = gold;
	}
	public void setStatusPoint(int statusPoint) {
		this.statusPoint = statusPoint;
	}
	public void setItems(int[] items) {
		this.items = items;
	}
	
	public void addItem(int index) {
		this.items[index]++;
	}
	public void addItem(int index, int amount) {
		this.items[index] += amount;
	}
	public void reduceItem(int index) {
		this.items[index]--;
	}
}
