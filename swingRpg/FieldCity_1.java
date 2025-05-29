package swingRpg;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class FieldCity_1 extends FieldCity_Origin implements KeyListener{
	
	FieldCity_1(){
		super(0);
		this.prepareShop(0, 1, 51, 101, 106);
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
