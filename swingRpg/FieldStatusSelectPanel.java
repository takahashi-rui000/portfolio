package swingRpg;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class FieldStatusSelectPanel extends JPanel implements KeyListener{
	private static JLabel[] subjectLabel;
	private static JLabel selectedLabel;
	private static int selectedNum = 0;
	final private static Font FONT = new Font(Font.SERIF, Font.PLAIN, 20);
	
	private static FieldStatusPanel fieldStatusPanel;
	private static FieldItemPanel fieldItemPanel;
	private static FieldEquipmentPanel fieldEquipmentPanel;
	
	FieldStatusSelectPanel(){
		this.setBounds(170, 10, 400, 300);
		this.setBackground(Color.black);
		this.setBorder(new LineBorder(Color.white, 1, true));
		this.addKeyListener(this);
		this.setLayout(null);
		
		this.prepareSubjectlabel();
		this.prepareSelectedLabel();
		
		fieldStatusPanel = new FieldStatusPanel();
		fieldItemPanel = new FieldItemPanel();
		fieldEquipmentPanel = new FieldEquipmentPanel();
		
		this.add(fieldStatusPanel);
	}
	
	private void prepareSubjectlabel() {
		String[] subject = {"ステータス", "アイテム", "装備", "セーブ", "閉じる"};
		subjectLabel = new JLabel[subject.length];
		for(int i=0; i < subjectLabel.length; i++) {
			subjectLabel[i] = new JLabel(subject[i]);
			subjectLabel[i].setBounds(20, 10 + i * 35, 200, 30);
			subjectLabel[i].setFont(FONT);
			subjectLabel[i].setForeground(Color.white);
			this.add(subjectLabel[i]);
		}
	}
	
	private void prepareSelectedLabel() {
		selectedLabel = new JLabel();
		selectedLabel.setBounds(5, 20, 10, 18);
		selectedLabel.setBackground(Color.white);
		selectedLabel.setOpaque(true);
		
		this.add(selectedLabel);
	}
	
	private void moveSelectedLabel(KeyEvent e) {
		switch(e.getKeyCode()) {
		case 38:
			if(selectedNum == 0) {
				selectedNum = subjectLabel.length-1;
			}else {
				selectedNum--;
			}
			break;
		case 40:
			if(selectedNum == subjectLabel.length-1) {
				selectedNum = 0;
			}else {
				selectedNum++;
			}
			break;
		}
		setSelectedLabel();
		this.switchDisplay();
	}
	
	private static void setSelectedLabel() {
		selectedLabel.setBounds(5, 18 + selectedNum * 35, 10, 18);
	}
	
	public void switchDisplay() {
		switch(selectedNum) {
		case 0:
			this.remove(fieldItemPanel);
			this.remove(fieldEquipmentPanel);
			this.add(fieldStatusPanel);
			break;
		case 1:
			this.remove(fieldStatusPanel);
			this.remove(fieldEquipmentPanel);
			fieldItemPanel.setLabel();
			this.add(fieldItemPanel);
			break;
		case 2:
			this.remove(fieldItemPanel);
			this.add(fieldEquipmentPanel);
			fieldEquipmentPanel.setLabel();
			break;
		case 3:
			this.remove(fieldEquipmentPanel);
			break;
		case 4:
			this.remove(fieldStatusPanel);
		}
		this.repaint();
	}
	
	public void exitEquipmentPanel() {
		this.requestFocus();
	}
	
	private void enterPressed() {
		switch(selectedNum) {
		case 1:
			FieldItemPanel.setSelectionLabel();
			fieldItemPanel.requestFocus();
			break;
		case 2:
			FieldEquipmentPanel.setSelectedLabel();
			fieldEquipmentPanel.requestFocus();
			break;
		case 3:
			FieldLogPanel.addTextArr("セーブしました(未実装)");
			SaveAndLoad.dataSave();
			break;
		case 4:
			selectedNum = 0;
			setSelectedLabel();
			MainWindow.getFieldPanel().statusHiden();
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == 38 || e.getKeyCode() == 40) {
			this.moveSelectedLabel(e);
		}else if(e.getKeyCode() == 27) {
			selectedNum = 0;
			setSelectedLabel();
			MainWindow.getFieldPanel().statusHiden();
		}else if(e.getKeyCode() == 10) {
			this.enterPressed();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	public static FieldItemPanel getFieldItemPanel() {
		return fieldItemPanel;
	}

	public static void setFieldItemPanel(FieldItemPanel fieldItemPanel) {
		FieldStatusSelectPanel.fieldItemPanel = fieldItemPanel;
	}
}
