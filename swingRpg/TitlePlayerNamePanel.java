package swingRpg;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

public class TitlePlayerNamePanel extends JPanel implements ActionListener, KeyListener{
	final private static Font FONT = new Font(Font.SERIF, Font.PLAIN, 18);
	final private static Font BIGFONT = new Font(Font.SERIF, Font.PLAIN, 55);
	private static JLabel[] labels;
	private static JLabel nameLabel;
	private static JButton[] buttons;
	private static JTextField textField;
	private final Timer TIMER = new Timer(100, this);
	private static int blinkNum = -1;
	
	TitlePlayerNamePanel(){
		this.setBounds(100, 300, 600, 250);
		this.setLayout(null);
		this.setBackground(Color.BLACK);
		this.setBorder(new LineBorder(Color.white, 1));
		TIMER.start();
		this.addKeyListener(this);
		
		this.preparelabels();
		this.prepareTextField();
		this.prepareButtons();
	}
	
	private void preparelabels() {
		labels = new JLabel[3];
		for(int i=0; i < labels.length; i++) {
			labels[i] = new JLabel();
			labels[i].setBounds(20, 10 + (i * 30), 400, 50);
			labels[i].setForeground(Color.white);
			labels[i].setFont(FONT);
			this.add(labels[i]);
		}
		
		labels[0].setText("勇者の名前を入力してください。");
		labels[1].setText("2文字以上6文字以下で決定してださい。");
	}
	
	private void prepareButtons() {
		buttons = new JButton[2];
		for(int i=0; i < buttons.length; i++) {
			buttons[i] = new JButton();
			buttons[i].setFont(FONT);
			buttons[i].setBounds(200, 200, 200, 40);
			buttons[i].setHorizontalAlignment(JButton.CENTER);
			buttons[i].setBackground(Color.black);
			buttons[i].setForeground(Color.white);
			buttons[i].setBorder(new LineBorder(Color.white, 1));
			buttons[i].addActionListener(this);
			this.add(buttons[i]);
		}
		buttons[0].setActionCommand("decision");
		buttons[0].setText("決定");
		buttons[1].setActionCommand("return");
		buttons[1].setBounds(540, 10, 50, 30);
		buttons[1].setText("戻る");
	}
	
	private void prepareTextField() {
		textField = new JTextField();
		textField.setFont(BIGFONT);
		textField.setBounds(50, 90, 500, 100);
		textField.setBackground(Color.black);
		textField.setBorder(new LineBorder(Color.white, 1));
		textField.setForeground(Color.white);
		textField.setHorizontalAlignment(JTextField.CENTER);
		textField.setHorizontalAlignment(JLabel.CENTER);
		textField.setText("勇者タロウ");
		this.add(textField);
	}
	
	private static void textCheck() {
		if(textField.getText().length() <= 6 && textField.getText().length() >= 2) {
			labels[1].setText("可能な名前です");
			blinkNum = -1;
			labels[1].setForeground(Color.white);
		}else if(blinkNum == -1) {
			if(textField.getText().length() > 6 || textField.getText().length() < 3) {
				labels[1].setText("3文字以上6文字以下で決定してださい。");
				blinkNum = 0;
			}
		}else {
			blinkNum++;
			if(blinkNum == 20) {
				labels[1].setForeground(Color.white);
				blinkNum = -1;
			}else if(blinkNum % 4 == 0) {
				labels[1].setForeground(Color.white);
			}else if(blinkNum % 2 == 0) {
				labels[1].setForeground(Color.red);
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "decision") {
			if(textField.getText().length() <= 6 && textField.getText().length() >= 2) {
				BattleSystem.getPlayer().setName(textField.getText());
				Observer.getMainWindow().setFrontPanelAndFocus(ScreenMode.FIELD);
			}
		}else if(e.getActionCommand() == "return"){
			MainWindow.getTitlePanel().switchPanel();
		}else {
			textCheck();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
	
}
