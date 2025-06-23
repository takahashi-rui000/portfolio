package swingRpg;

import javax.swing.ImageIcon;

public class Character_Enemy extends Character{
	ImageIcon icon;
	int exp;
	
	Character_Enemy(String name, int maxHp, int attack, int agility, int defence, int exp) {
		super(name, maxHp, attack, agility, defence);
		this.icon = new ImageIcon("./images\\null.png");
		this.exp = exp;
	}
	
	//  攻撃
	public void attack(Character target, double magnification) {
		int damage = calculateDamage( target , magnification );
		if(BattleSkillCheckPanel.isCritical()) {
			BattleLogPanel.addBattleLogTextArr("大成功!");
			BattleSkillCheckPanel.setCritical(false);
		}
		BattleLogPanel.addBattleLogTextArr(target.getName() + "へ" +  damage + "ダメージ");
		takeDamage( target, damage );
	}
	
	//  ダメージ計算
	protected int calculateDamage(Character target, double magnification) {
		//  計算式... ( ( 乱数( 攻撃力 * 0.1 ) + 攻撃力 ) / 2 ) - ( ( 防御力 + 防具防御力 ) / 5 )
		System.out.println("倍率:" + (magnification));
		int damage = (int) ( ( ( new java.util.Random().nextInt( (int) ( this.getAttack() * 0.1 ) ) + this.getAttack() * 0.5 ) - ( ( target.getDefence() + Items.getItemEffect( ( ( Character_Player ) target ).getEquippedArmor() ) ) * 0.2 ) ) * ( magnification ) );
		if(damage > 0) {
			return damage;
		}
		return 0;
	}

	//  ゲッター
	public ImageIcon getIcon() {
		return icon;
	}
	public int getExp() {
		return exp;
	}
	
	//  セッター
	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	
}
