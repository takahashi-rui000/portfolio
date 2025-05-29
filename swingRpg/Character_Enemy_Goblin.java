package swingRpg;

import javax.swing.ImageIcon;

public class Character_Enemy_Goblin extends Character_Enemy{

	Character_Enemy_Goblin() {
		super("ゴブリン", 50, 60, 20, 20, 200);
		this.setIcon(new ImageIcon("./images\\enemys\\goblin.png"));
		
	}

}
