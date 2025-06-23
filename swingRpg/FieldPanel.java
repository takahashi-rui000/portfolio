package swingRpg;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class FieldPanel extends JPanel implements ActionListener{
	private static FieldMassPanel fieldMassPanel;
	private static FieldLogPanel fieldLogPanel;
	private static FieldSideInfoPanel fieldSideInfoPanel;
	private static FieldCity_Origin[] city;
	private static FieldStatusSelectPanel fieldStatusSelectPanel;
	private static CommandPanel commandPanel;
	private static int interval = 10;
	
	final private static Font FONT = new Font(Font.SERIF, Font.PLAIN, 30);
	final private Timer TIMER = new Timer(100, this);
	
	
	private int time = 0;
	
	FieldPanel() {
		this.setLayout(null);
		this.setBackground(Color.black);
		this.setBounds(0,0,800+8,600+36);
		TIMER.start();
	}
	
	public void preparePanels() {
		fieldLogPanel = new FieldLogPanel();
		fieldSideInfoPanel = new FieldSideInfoPanel();
		fieldMassPanel = new FieldMassPanel();
		fieldStatusSelectPanel = new FieldStatusSelectPanel();
		commandPanel = new CommandPanel();
		city = new FieldCity_Origin[6];
		city[0] = new FieldCity_1();
		city[1] = new FieldCity_2();
		city[2] = new FieldCity_3();
		
		this.add(fieldMassPanel);
		this.add(fieldSideInfoPanel);
//		this.add(city1);
		this.setComponentZOrder(fieldMassPanel, this.getComponentCount()-1);
	}
	
	public static void setPlayer(int x, int y) {
		if(!FieldSystem.isObstacle(FieldSystem.getCurrentLocation_X() + x, FieldSystem.getCurrentLocation_Y() + y)) {
			FieldSystem.setCurrentLocation_X(FieldSystem.getCurrentLocation_X() + x);
			FieldSystem.setCurrentLocation_Y(FieldSystem.getCurrentLocation_Y() + y);
			FieldSystem.eventManagement(FieldSystem.getCurrentLocation_X(), FieldSystem.getCurrentLocation_Y());
		}
	}
	
	public static void repaintPlayer() {
		fieldMassPanel.getPlayerImage().setBounds(FieldSystem.getCurrentLocation_X()*40, FieldSystem.getCurrentLocation_Y()*40, 40, 40);
	}
	
	// タイマー
	public void stopFieldTimer() {
		this.TIMER.stop();
	}
	public void startFieldTimer() {
		this.TIMER.start();
	}
	
	//  ステータス表示 / 非表示
	public void statusDisplay() {
		System.out.println("display");
		this.add(fieldStatusSelectPanel);
		this.setComponentZOrder(fieldStatusSelectPanel, 0);
		fieldStatusSelectPanel.requestFocus();
		fieldStatusSelectPanel.switchDisplay();
		this.repaint();
	}
	public void statusHiden() {
		this.remove(fieldStatusSelectPanel);
		fieldMassPanel.requestFocus();
		this.repaint();
	}
	
	public void showCommandPanel() {
		this.add(commandPanel);
		commandPanel.requestFocus();
		this.setComponentZOrder(commandPanel, 0);
		this.repaint();
	}
	
	public void hideCommandPanel() {
		this.remove(commandPanel);
		fieldMassPanel.requestFocus();
		this.repaint();
	}
	
	//  ゲッター
	public static FieldMassPanel getFieldMassPanel() {
		return fieldMassPanel;
	}

	public static FieldLogPanel getFieldLogPanel() {
		return fieldLogPanel;
	}
	public static FieldSideInfoPanel getFieldSideInfoPanel() {
		return fieldSideInfoPanel;
	}
	public static FieldCity_Origin getCity(int index) {
		return city[index];
	}
	public static FieldStatusSelectPanel getFieldStatusSelectPanel() {
		return fieldStatusSelectPanel;
	}
	
	//  セッター
	public static void setFieldMassPanel(FieldMassPanel fieldMassPanel) {
		FieldPanel.fieldMassPanel = fieldMassPanel;
	}
	public static void setFieldLogPanel(FieldLogPanel fieldLogPanel) {
		FieldPanel.fieldLogPanel = fieldLogPanel;
	}
	
	public static void setFieldSideInfoPanel(FieldSideInfoPanel fieldSideInfoPanel) {
		FieldPanel.fieldSideInfoPanel = fieldSideInfoPanel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		fieldLogPanel.repaint();
		fieldSideInfoPanel.setLabels(BattleSystem.getPlayer());
		time++;
		if(time % interval == 0) {
			FieldLogPanel.roadLogText();
			FieldStatusPanel.setStatusLabel();
			if(FieldLogPanel.getTextArr().size() <= 3) {
				interval = 10;
			}else if(FieldLogPanel.getTextArr().size() <= 6) {
				interval = 8;
			}else if(FieldLogPanel.getTextArr().size() <= 9) {
				interval = 6;
			}else if(FieldLogPanel.getTextArr().size() <= 12) {
				interval = 4;
			}else if(FieldLogPanel.getTextArr().size() <= 15) {
				interval = 2;
			}else if(FieldLogPanel.getTextArr().size() >= 18) {
				interval = 1;
			}
		}

		FieldMassPanel.walk();
		
	}
}
