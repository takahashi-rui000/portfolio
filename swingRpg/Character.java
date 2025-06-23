package swingRpg;

public abstract class Character {
	private String name;
	private int maxHp;
	private int currentHp;
	private int attack;
	private int agility;
	private int defence;
	
	Character(String name, int maxHp,int attack, int agility, int defence){
		this.name = name;
		this.maxHp = maxHp;
		this.currentHp = maxHp;
		this.attack = attack;
		this.agility = agility;
		this.defence = defence;
	}
	
	//  攻撃
//	public abstract void attack(Character target);
//		System.out.println( " normla " );
//		int damage = calculateDamage( target );
//		BattleLogPanel.addBattleLogTextArr(this.getName() + "の攻撃");
//		BattleLogPanel.addBattleLogTextArr(target.getName() + "へ" +  damage + "ダメージ");
//		takeDamage( target, damage );
	
	//  HP計算
	protected void takeDamage(Character target, int damage) {
		target.setCurrentHp(target.getCurrentHp() - damage);
		if(target.getCurrentHp() < 0) {
			target.setCurrentHp(0);
		}
	}
	
	//  ダメージ計算
//	protected abstract int calculateDamage(Character target);
//		計算式... ( 攻撃力 / 2 ) - ( 防御力 / 5 )
//		return (int)( this.getAttack * 0.5 ) - ( target.getDefence() * 0.20 );
//		return (int)( this.getAttack() * (1 -  target.getDefence() / (double)( target.getDefence() +100 ) ) );
	
	//  死亡判定
	public boolean isAlive() {
		if(this.currentHp == 0) {
			return false;
		}else if(this.currentHp < 0){
			this.setCurrentHp(0);
			System.out.println("HPが0未満になってるよ");
			return false;
		}
		return true;
	}

	//  ゲッター
	public int getMaxHp() {return maxHp;}
	public int getCurrentHp() {return currentHp;}
	public String getName() {return name;}
	public int getAttack() {return attack;}
	public int getAgility() {return agility;}
	public int getDefence() {return defence;}
		
	//  セッター
	public void setMaxHp(int maxHp) {this.maxHp = maxHp;}
	public void setCurrentHp(int hp) {this.currentHp = hp;}
	public void setName(String name) {this.name = name;}
	public void setAttack(int attack) {this.attack = attack;}
	public void setAgility(int agility) {this.agility = agility;}
	public void setDefence(int defence) {this.defence = defence;}
}
