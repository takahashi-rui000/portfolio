package swingRpg;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class FieldCity_2 extends FieldCity_Origin implements KeyListener{

	FieldCity_2() {
		super(1);
		this.prepareShop(0, 1, 52, 102);
		this.addKeyListener(this);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == 38 || e.getKeyCode() == 40) {
			this.moveSelectedLabel(e);
		}else if(e.getKeyCode() == 10){
			this.enterPressed();
		}else if(e.getKeyCode() == 27) {
			this.escPressed();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

}
