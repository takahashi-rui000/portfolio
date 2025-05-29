package swingRpg;

import javax.swing.ImageIcon;

public class Character_Enemy_Boss_Goblin extends Character_Enemy_Boss{

	Character_Enemy_Boss_Goblin() {
		super("長ゴブリン", 600, 120, 20, 60, 3000);
		this.setIcon(new ImageIcon("./images\\enemys\\goblin.png"));
	}

}
