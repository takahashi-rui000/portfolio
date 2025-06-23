package swingRpg;

import javax.swing.ImageIcon;

public class Character_Enemy_Kame extends Character_Enemy {

	Character_Enemy_Kame() {
		super("亀", 150, 50, 60, 150, 1000);
		this.icon = new ImageIcon(("./images\\bigkame.png"));
	}

}
