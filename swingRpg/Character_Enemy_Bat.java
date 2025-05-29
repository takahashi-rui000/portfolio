package swingRpg;

import javax.swing.ImageIcon;

public class Character_Enemy_Bat extends Character_Enemy{

	Character_Enemy_Bat() {
		super("コウモリ", 50, 110, 110, 50, 1000);
		this.setIcon(new ImageIcon("./images\\enemys\\bat.png"));
	}

}
