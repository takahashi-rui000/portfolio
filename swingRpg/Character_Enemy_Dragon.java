package swingRpg;

import javax.swing.ImageIcon;

public class Character_Enemy_Dragon extends Character_Enemy{

	Character_Enemy_Dragon() {
		super("竜", 150, 100, 70, 80, 1000);
		this.setIcon(new ImageIcon("./images\\enemys\\ryu.png"));
	}

}
