package swingRpg;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FieldMassPanel extends JPanel implements KeyListener{
	private static JLabel playerImage;
	private static JLabel[][] fieldLabel;
	private static int walk = -1;
	private static int angle;
	
	private static ImageIcon east1;
	private static ImageIcon east2;
	private static ImageIcon east3;
	private static ImageIcon south1;
	private static ImageIcon south2;
	private static ImageIcon south3;
	private static ImageIcon west1;
	private static ImageIcon west2;
	private static ImageIcon west3;
	private static ImageIcon north1;
	private static ImageIcon north2;
	private static ImageIcon north3;
	
	public FieldMassPanel() {
		this.setLayout(null);
		this.setBackground(Color.black);
		this.setBounds(0,0,800+8,600+36);
		this.addKeyListener(this);
		prepareImages();
		this.prepareFieldLabel();
		this.preparePlayerImage();
	}
	
	//  マス目のラベル準備、追加
	private void prepareFieldLabel() {
		fieldLabel = new JLabel[20][15];
		
		for(int x=0; x < 20; x++) {
			for(int y=0; y < 15; y++) {
				fieldLabel[x][y] = new JLabel();
				fieldLabel[x][y].setOpaque(false);
				fieldLabel[x][y].setPreferredSize(new Dimension(40, 40)); 
				fieldLabel[x][y].setBounds(x*40, y*40, 40, 40);
				fieldLabel[x][y].setOpaque(true);
				fieldLabel[x][y].setBackground(Color.white);
//				fieldLabel[x][y].setBorder(new LineBorder(Color.black, 1));
				
				this.add(fieldLabel[x][y]);
			}
		}
	}
	
	//  渡された二次元配列に従ってフィールドに見た目を作成
	public static void setFIeldLabelImage(int[][] arr) {
		for(int x=0; x<20; x++) {
			for(int y=0; y<15; y++) {
				fieldLabel[x][y].setIcon(FieldSystem.returnImage(arr[x][y]));
			}
		}
	}
	
	public void preparePlayerImage() {
		playerImage = new JLabel();
		playerImage.setBounds(1*40, 7*40, 40, 40);
		playerImage.setIcon(west1);
//		playerImage.setOpaque(true);
		this.add(playerImage);
		this.setComponentZOrder(playerImage, 0);
	}
	
	//  歩く
	public static void walk() {
		if(FieldMassPanel.getWalk() != -1) {
			FieldMassPanel.setWalk(FieldMassPanel.getWalk() + 1);
			FieldMassPanel.walkAnime(FieldSystem.getCurrentLocation_X(), FieldSystem.getCurrentLocation_Y());
			if(FieldMassPanel.getWalk() > 4) {
				FieldMassPanel.setWalk(-1);
				switch(FieldMassPanel.getAngle()) {
				case 0:
					FieldPanel.setPlayer(-1,0);
					break;
				case 1:
					FieldPanel.setPlayer(0,-1);
					break;
				case 2:
					FieldPanel.setPlayer(1,0);
					break;
				case 3:
					FieldPanel.setPlayer(0,1);
				}
			}
		}
	}
	
	//  歩くアニメーション
	public static void walkAnime(int x, int y) {
		switch(angle) {
		case 0:
			switch(walk) {
			case 2:
				setPlayerAngleImage(1);
				break;
			case 4:
				setPlayerAngleImage(2);
				break;
				default:
					setPlayerAngleImage(0);
			}
			playerImage.setBounds(x * 40 - (walk * 10 - 10), y * 40, 40, 40);
			break;
		case 1:
			switch(walk) {
			case 2:
				setPlayerAngleImage(1);
				break;
			case 4:
				setPlayerAngleImage(2);
				break;
				default:
					setPlayerAngleImage(0);
			}
			playerImage.setBounds(x * 40, y * 40 - (walk * 10 - 10), 40, 40);
			break;
		case 2:
			switch(walk) {
			case 2:
				setPlayerAngleImage(1);
				break;
			case 4:
				setPlayerAngleImage(2);
				break;
				default:
					setPlayerAngleImage(0);
			}
			playerImage.setBounds(x * 40 + (walk * 10 - 10), y * 40, 40, 40);
			
			break;
		case 3:
			switch(walk) {
			case 2:
				setPlayerAngleImage(1);
				break;
			case 4:
				setPlayerAngleImage(2);
				break;
				default:
					setPlayerAngleImage(0);
			}
			playerImage.setBounds(x * 40, y * 40 + (walk * 10 - 10), 40, 40);
		}
	}
	
	//  入力処理
	private static void inputArrow(KeyEvent e) {
		if(walk == -1) {
			switch(e.getKeyCode()) {
			case 37:
				if(!FieldSystem.isOutsideArea(-1, 0)) {
					angle = 0;
					setPlayerAngleImage(0);
					if(!FieldSystem.isObstacle(FieldSystem.getCurrentLocation_X()-1, FieldSystem.getCurrentLocation_Y())) {
						walk = 1;
					}
				}
				break;
			case 38:
				if(!FieldSystem.isOutsideArea(0, -1)) {
					angle = 1;
					setPlayerAngleImage(0);
					if(!FieldSystem.isObstacle(FieldSystem.getCurrentLocation_X(), FieldSystem.getCurrentLocation_Y()-1)) {
						walk = 1;
					}
				}
				break;
			case 39:
				if(!FieldSystem.isOutsideArea(1, 0)) {
					angle = 2;
					setPlayerAngleImage(0);
					if(!FieldSystem.isObstacle(FieldSystem.getCurrentLocation_X()+1, FieldSystem.getCurrentLocation_Y())) {
						walk = 1;
					}
				}
				break;
			case 40:
				if(!FieldSystem.isOutsideArea(0, 1)) {
					angle = 3;
						setPlayerAngleImage(0);
					if(!FieldSystem.isObstacle(FieldSystem.getCurrentLocation_X(), FieldSystem.getCurrentLocation_Y()+1)) {
						walk = 1;
					}
				}
				break;
			}
		}
	}
	
	//  画像準備
	private static void prepareImages() {
		east1 = new ImageIcon("./images\\player\\player_east.png");
		east2 = new ImageIcon("./images\\player\\player_east_1.png");
		east3 = new ImageIcon("./images\\player\\player_east_2.png");
		south1 = new ImageIcon("./images\\player\\player_south.png");
		south2 = new ImageIcon("./images\\player\\player_south_1.png");
		south3 = new ImageIcon("./images\\player\\player_south_2.png");
		west1 = new ImageIcon("./images\\player\\player_west.png");
		west2 = new ImageIcon("./images\\player\\player_west_1.png");
		west3 = new ImageIcon("./images\\player\\player_west_2.png");
		north1 = new ImageIcon("./images\\player\\player_north.png");
		north2 = new ImageIcon("./images\\player\\player_north_1.png");
		north3 = new ImageIcon("./images\\player\\player_north_2.png");
	}
	
	//  プレイヤーの方向
	public static void setPlayerAngleImage(int n) {
		switch(angle) {
		case 0:
			switch(n) {
			case 1:
			FieldMassPanel.getPlayerImage().setIcon(east3);
				break;
			case 2:
				FieldMassPanel.getPlayerImage().setIcon(east2);
				break;
				default:
				FieldMassPanel.getPlayerImage().setIcon(east1);
			}
			break;
		case 1:
			switch(n) {
			case 1:
			FieldMassPanel.getPlayerImage().setIcon(south3);
				break;
			case 2:
				FieldMassPanel.getPlayerImage().setIcon(south2);
				break;
				default:
				FieldMassPanel.getPlayerImage().setIcon(south1);
			}
			break;
		case 2:
			switch(n) {
			case 1:
			FieldMassPanel.getPlayerImage().setIcon(west3);
				break;
			case 2:
				FieldMassPanel.getPlayerImage().setIcon(west2);
				break;
				default:
				FieldMassPanel.getPlayerImage().setIcon(west1);
			}
			break;
		case 3:
			switch(n) {
			case 1:
			FieldMassPanel.getPlayerImage().setIcon(north3);
				break;
			case 2:
				FieldMassPanel.getPlayerImage().setIcon(north2);
				break;
				default:
				FieldMassPanel.getPlayerImage().setIcon(north1);
			}
		}
	}
	
	public static void setImg(int x, int y, int index) {
		fieldLabel[x][y].setIcon(FieldSystem.returnImage(index));
	}
	
	public static void repaintPlayer() {
		playerImage.setBounds(FieldSystem.getCurrentLocation_X() * 40, FieldSystem.getCurrentLocation_Y() * 40, playerImage.getWidth(), playerImage.getHeight());
	}
	
	//  ゲッター
	public static JLabel getPlayerImage() {
		return playerImage;
	}
	public static JLabel[][] getFieldLabel() {
		return fieldLabel;
	}
	public static int getWalk() {
		return walk;
	}
	public static int getAngle() {
		return angle;
	}
	
	//  セッター
	public static void setPlayerImage(JLabel playerImage) {
		FieldMassPanel.playerImage = playerImage;
	}
	public static void setFieldLabel(JLabel[][] fieldLabel) {
		FieldMassPanel.fieldLabel = fieldLabel;
	}
	public static void setWalk(int walk) {
		FieldMassPanel.walk = walk;
	}



	@Override
	public void keyTyped(KeyEvent e) {
		// TODO 自動生成されたメソッド・スタブ
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() >= 37 && e.getKeyCode() <= 40) {
			inputArrow(e);
		}else if(e.getKeyCode() == 27) {
			if(walk == -1) {
				MainWindow.getFieldPanel().statusDisplay();
			}
		}else if(e.getKeyCode() == 155) {
			MainWindow.getFieldPanel().showCommandPanel();
		}
	}



	@Override
	public void keyReleased(KeyEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
	
}
