package swingRpg;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class TitleSelectModePanel extends JPanel implements KeyListener{
	final private static Font FONT = new Font(Font.SERIF, Font.PLAIN, 35);
	private static JLabel[] subjectLabel;
	
	private static JLabel selectionLabel;
	private static int selectionNum = 0;
	
	TitleSelectModePanel(){
		this.setBounds(100, 300, 600, 250);
		this.setLayout(null);
		this.setBackground(Color.BLACK);
		this.setBorder(new LineBorder(Color.white, 1));
		this.addKeyListener(this);
		
		this.prepareSelectionLabel();
		this.prepareSubjectLabel();
	}
	
	private void prepareSelectionLabel() {
		selectionLabel = new JLabel("→");
		selectionLabel.setBounds(40, 53, 50, 50);
//		selectionLabel.setBorder(new LineBorder(Color.white, 1));
		selectionLabel.setFont(FONT);
		selectionLabel.setHorizontalAlignment(JLabel.CENTER);
		selectionLabel.setForeground(Color.white);
		
		this.add(selectionLabel);
	}
	
	private void prepareSubjectLabel() {
		subjectLabel = new JLabel[2];
		for(int i=0; i < subjectLabel.length; i++) {
			subjectLabel[i] = new JLabel();
			subjectLabel[i].setForeground(Color.white);
			subjectLabel[i].setFont(FONT);
			subjectLabel[i].setBounds(100, 50 + (i * 100), 500, 55);
			this.add(subjectLabel[i]);
		}
		subjectLabel[0].setText("続きから");
		subjectLabel[1].setText("最初から");
	}
	
	public static void setSelectionLabel() {
		selectionLabel.setBounds(40, 53 + ( selectionNum * 100 ), 50, 50);
	}
	
	private static void moveSelectionLabel(KeyEvent e) {
		switch(e.getKeyCode()) {
		case 38:
			if(selectionNum == 0) {
				selectionNum = subjectLabel.length-1;
			}else {
				selectionNum--;
			}
			break;
		case 40:
			if(selectionNum == subjectLabel.length-1) {
				selectionNum = 0;
			}else{
				selectionNum++;
			}
		}
		setSelectionLabel();
	}
	
	private static void enterPressed() {
		switch(selectionNum) {
		case 0:
			SaveAndLoad.loadSave();
			Observer.getMainWindow().setFrontPanelAndFocus(ScreenMode.FIELD);
			break;
		case 1:
			MainWindow.getTitlePanel().switchPanel();
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == 38 || e.getKeyCode() == 40) {
			moveSelectionLabel(e);
		}else if(e.getKeyCode() == 10) {
			enterPressed();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
	
}
