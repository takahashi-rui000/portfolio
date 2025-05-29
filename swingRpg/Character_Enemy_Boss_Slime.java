package swingRpg;

import javax.swing.ImageIcon;

public class Character_Enemy_Boss_Slime extends Character_Enemy_Boss {

	Character_Enemy_Boss_Slime() {
		super("ボススライム", 300, 70, 60, 70, 1000);
		this.setIcon(new ImageIcon("./images\\enemys\\boss\\slime.png"));
	}

}
