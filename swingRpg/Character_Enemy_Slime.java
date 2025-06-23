package swingRpg;

import javax.swing.ImageIcon;

public class Character_Enemy_Slime extends Character_Enemy{
	Character_Enemy_Slime() {
		super("スライム", 20, 30, 20, 30, 20);
		this.icon = new ImageIcon("./images\\character_monster_slime_green.png");
	}
}
