package swingRpg;

import javax.swing.ImageIcon;

public class Character_Enemy_Boss_Goblin extends Character_Enemy_Boss{

	Character_Enemy_Boss_Goblin() {
		super("長ゴブリン", 600, 120, 20, 60, 2000);
		this.icon = new ImageIcon("./images\\character_monster_goblin.png");
	}

}
