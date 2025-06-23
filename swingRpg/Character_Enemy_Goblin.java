package swingRpg;

import javax.swing.ImageIcon;

public class Character_Enemy_Goblin extends Character_Enemy{

	Character_Enemy_Goblin() {
		super("ゴブリン", 50, 60, 20, 20, 50);
		this.icon = new ImageIcon(("./images\\character_monster_goblin.png"));
		
	}

}
