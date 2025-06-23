package swingRpg;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class CommandPanel extends JPanel implements KeyListener{
	private static JLabel[] log;
	private static String inputCommand="";
	final private static Font FONT = new Font(Font.SERIF, Font.PLAIN, 18); 
	
	
	CommandPanel(){
		this.addKeyListener(this);
		this.setBounds(25, 375, 750, 200);
		this.setBackground(Color.black);
		this.setBorder(new LineBorder(Color.white, 2));
		this.setLayout(null);
		this.prepare();
	}
	
	private void prepare() {
		log = new JLabel[8];
		for(int i=0; i < log.length; i++) {
			log[i] = new JLabel();
			log[i].setFont(FONT);
			log[i].setForeground(Color.green);
			log[i].setBounds(20, 12 + i * 22, 700, 20);
			this.add(log[i]);
		}
	}
	
	public static void addLog(String text) {
		updataCommand();
		log[log.length-1].setText(text);
	}
	
	private static void pressedEnterKey() {
		CommandSystem.commandDecision(inputCommand);
		updataCommand();
	}
	
	private static void updataCommand() {
		for(int i=0; i < log.length-1; i++) {
			log[i].setText(log[i+1].getText());
		}
		inputCommand = "";
		log[log.length-1].setText(inputCommand);
	}
	
	private static void inputCommandSystem(char c) {
		inputCommand = inputCommand + c;
		log[log.length-1].setText(inputCommand);
	}
	
	private static void pressedBackSpaceKey() {
		if(inputCommand.length() > 0) {
			inputCommand = inputCommand.substring(0, inputCommand.length() - 1);
			log[log.length-1].setText(inputCommand);
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == 10) {
			pressedEnterKey();
		}else if(e.getKeyCode() == 8) {
			pressedBackSpaceKey();
		}else if(e.getKeyCode() == 155){
			MainWindow.getFieldPanel().hideCommandPanel();
		}else if(e.getKeyCode() == 38) {
			inputCommand = log[log.length - 3].getText();
			log[log.length-1].setText(inputCommand);
		}else if( ( e.getKeyCode() >= 65 && e.getKeyCode() <= 90 ) || ( e.getKeyCode() >= 48 && e.getKeyCode() <= 57 ) || ( e.getKeyCode() == 32 ) ){
			inputCommandSystem(e.getKeyChar());
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
	
}
