package swingRpg;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class FieldLogPanel extends JPanel{
	final private static Font FONT = new Font(Font.SERIF, Font.PLAIN, 30);
	private static JLabel[] fieldLogLabel;
	private static ArrayList<String> textArr = new ArrayList<>();
	private static boolean displayLogPanel = false;
	
	FieldLogPanel() {
		this.setBounds(25, 375, 750, 200);
		this.setBackground(Color.black);
		this.setBorder(new LineBorder(Color.white, 2));
		this.setLayout(null);
		
		this.prepareFieldLogLabel();
	}
	
	//  ログパネルの中のテキストラベルを準備
	private void prepareFieldLogLabel() {		
		fieldLogLabel = new JLabel[3];
		for(int i=0; i < fieldLogLabel.length; i++) {
			fieldLogLabel[i] = new JLabel();
			fieldLogLabel[i].setPreferredSize(new Dimension(700, 50));
			fieldLogLabel[i].setBounds(40, 10+(i*65), 760, 50);
			fieldLogLabel[i].setText("");
			fieldLogLabel[i].setFont(FONT);
			fieldLogLabel[i].setForeground(Color.white);
		}
		for(int i=0; i < 3; i++) {
			this.add(fieldLogLabel[i]);
		}
	}
	


	//  ログラベルに用いる可変長配列に文字列をadd
	public static void addTextArr(String text) {
		textArr.add(text);
	}
	
	//  ログパネルに表示するテキストを読み込む
	public static void roadLogText() {
		if(textArr.size() != 0 && !displayLogPanel) {
			displayLogPanel = true;
			MainWindow.getFieldPanel().add(FieldPanel.getFieldLogPanel());
			MainWindow.getFieldPanel().repaint();
			MainWindow.getFieldPanel().setComponentZOrder(FieldPanel.getFieldLogPanel(), 0);
		}
		if(textArr.size() != 0) {
			fieldLogLabel[0].setText(fieldLogLabel[1].getText());
			fieldLogLabel[1].setText(fieldLogLabel[2].getText());
			fieldLogLabel[2].setText(textArr.get(0));
			textArr.remove(0);
		}else if(fieldLogLabel[0].getText().equals("") && fieldLogLabel[1].getText().equals("") && fieldLogLabel[2].getText().equals("")){
			displayLogPanel = false;
			MainWindow.getFieldPanel().remove(FieldPanel.getFieldLogPanel());
			MainWindow.getFieldPanel().repaint();
		}else {
			fieldLogLabel[0].setText(fieldLogLabel[1].getText());
			fieldLogLabel[1].setText(fieldLogLabel[2].getText());
			fieldLogLabel[2].setText("");
		}
	}
	
	
	//  ゲッター
	public static JLabel[] getFieldLogLabel() {
		return fieldLogLabel;
	}
	public static ArrayList<String> getTextArr() {
		return textArr;
	}
	
	//  セッター
	public static void setFieldLogLabel(JLabel[] fieldLogLabel) {
		FieldLogPanel.fieldLogLabel = fieldLogLabel;
	}
	public static void setTextArr(ArrayList<String> textArr) {
		FieldLogPanel.textArr = textArr;
	}
}
