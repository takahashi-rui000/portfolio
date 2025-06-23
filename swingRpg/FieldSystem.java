package swingRpg;

import javax.swing.ImageIcon;

public class FieldSystem {
	private static int currentLocation_X = 1;
	private static int currentLocation_Y = 7;
	private static int currentFieldIndex;
	private static int currentField[][] = new int[20][15];
	private static int field_1[][] = new int[20][15];
	private static int field_2[][] = new int[20][15];
	private static int field_3[][] = new int[20][15];
	private static int field_4[][] = new int[20][15];
	private static int field_5[][] = new int[20][15];
	private static int field_6[][] = new int[20][15];
	private static int field_7[][] = new int[20][15];
	private static boolean[] bossFlag;
	private static boolean[] itemFlag;
	final private static ImageIcon grass = new ImageIcon("./images\\sozai\\kusa0.png");
	final private static ImageIcon grass2 = new ImageIcon("./images\\sozai\\kusa1.png");
	final private static ImageIcon grass4 = new ImageIcon("./images\\sozai\\kusa4.png");
	final private static ImageIcon grass5 = new ImageIcon("./images\\sozai\\kusa5");
	final private static ImageIcon grassChest = new ImageIcon("./images\\sozai\\grassChest.png");
	final private static ImageIcon grassCasino = new ImageIcon("./images\\sozai\\grassCasino.png");
	final private static ImageIcon rock = new ImageIcon("./images\\sozai\\iwa1.png");
	final private static ImageIcon dark = new ImageIcon("./images\\sozai\\cave\\dark.png");
	final private static ImageIcon demonWorldGrass = new ImageIcon("./images\\sozai\\demonWorldGrass.png");
	final private static ImageIcon demonWorldRock = new ImageIcon("./images\\sozai\\demonWorldRock.png");
	final private static ImageIcon demonWorldCity = new ImageIcon("./images\\sozai\\demonWorldCity.png");
	final private static ImageIcon demonWorldCasino = new ImageIcon("./images\\sozai\\demonWorldCasino.png");
	final private static ImageIcon demonWorldCastle = new ImageIcon("./images\\sozai\\demonWorldCastle.png");
	final private static ImageIcon caveWall_0 = new ImageIcon("./images\\sozai\\cave\\caveWall0.png");
	final private static ImageIcon caveWall_1 = new ImageIcon("./images\\sozai\\cave\\caveWall1.png");
	final private static ImageIcon caveWall_2 = new ImageIcon("./images\\sozai\\cave\\caveWall2.png");
	final private static ImageIcon caveWall_3 = new ImageIcon("./images\\sozai\\cave\\caveWall3.png");
	final private static ImageIcon caveCorner_0 = new ImageIcon("./images\\sozai\\cave\\caveCorner0.png");
	final private static ImageIcon caveCorner_1 = new ImageIcon("./images\\sozai\\cave\\caveCorner1.png");
	final private static ImageIcon caveCorner_2 = new ImageIcon("./images\\sozai\\cave\\caveCorner2.png");
	final private static ImageIcon caveCorner_3 = new ImageIcon("./images\\sozai\\cave\\caveCorner3.png");
	final private static ImageIcon caveRoad = new ImageIcon("./images\\sozai\\cave\\caveRoad.png");
	final private static ImageIcon city = new ImageIcon("./images\\sozai\\house1.png");
	final private static ImageIcon bossMass_0 = new ImageIcon("./images\\sozai\\bossMass\\bossSlime.png");
	final private static ImageIcon bossMass_1 = new ImageIcon("./images\\sozai\\bossMass\\bossGoblin.png");
	final private static ImageIcon bossMass_2 = new ImageIcon("./images\\sozai\\bossMass\\bossGoblin.png");
	final private static ImageIcon bossMass_3 = new ImageIcon("./images\\sozai\\bossMass\\bossGoblin.png");
	final private static ImageIcon bossMass_4 = new ImageIcon("./images\\sozai\\bossMass\\bossGoblin.png");
	final private static ImageIcon bossMass_5 = new ImageIcon("./images\\sozai\\bossMass\\bossGoblin.png");
	
	private static int encounter = 6;
	
	public static ImageIcon returnImage(int n) {
		switch(n) {
		//  0~9 道, 10~19 町, 20~29 カジノ,30~89 障害物, 90~99 アイテム, 100~ボス
		//  草
		case 0:
			return grass;
		case 1:
			return grass2;
		case 2:
			return caveRoad;
		case 3:
			return demonWorldGrass;
		case 9:
			return demonWorldCastle;
		//  町
		case 10:
			return city;
		case 11:
			return city;
		case 12:
			return demonWorldCity;
		case 20:
			return grassCasino;
		case 21:
			return demonWorldCasino;
		//  障害物
		case 30:
			return rock;
		case 31:
			return dark;
		case 32:
			return demonWorldRock;
		case 90:
			return grassChest;
		case 100:
			return bossMass_0;
		case 101:
			return bossMass_1;
		case 102:
			return bossMass_2;
		case 103:
			return bossMass_3;
		case 104:
			return bossMass_4;
		case 105:
			return bossMass_5;
		}
		return null;
	}
	
	public static void prepareFlags() {
		bossFlag = new boolean[10];
		for(int i=0; i < bossFlag.length ; i++) {
			bossFlag[i] = false;
		}
		itemFlag = new boolean[30];
		for(int i=0; i < bossFlag.length ; i++) {
			itemFlag[i] = false;
		}
	}
	
	public static void prepareField_1() {
		for(int x=0; x < 20; x++) {
			field_1[x][0] = 30;
			field_1[x][14] = 30;
		}
		for(int y=0; y < 15; y++) {
			if(y != 7) {
				field_1[0][y] = 30;
				field_1[19][y] = 30;
			}
		}
		field_1[3][7] = 10;
		field_1[5][7] = 20;
		field_1[18][7] = 100;
	}
	
	public static void prepareField_2() {
		for(int x=0; x < 20; x++) {
			for(int y=0; y < 15; y++) {
				field_2[x][y] = 0;
			}
		}
		for(int x=0; x < 20; x++) {
			field_2[x][0] = 30;
			field_2[x][1] = 30;
			field_2[x][14] = 30;
		}
		for(int y=0; y < 15; y++) {
			field_2[0][y] = 30;
			field_2[19][y] = 30;
		}
		
		field_2[0][7] = 0;
		field_2[8][1] = 0;
		field_2[9][1] = 0;
		field_2[10][1] = 0;
		field_2[9][0] = 0;
		field_2[1][2] = 30;
		field_2[2][2] = 30;
		field_2[3][2] = 30;
		field_2[4][2] = 90;
		field_2[16][2] = 30;
		field_2[17][2] = 30;
		field_2[18][2] = 30;
		field_2[18][3] = 30;
		field_2[18][12] = 30;
		field_2[18][13] = 30;
		field_2[1][12] = 30;
		field_2[1][13] = 90;
		field_2[9][1] = 101;
		field_2[9][7] = 11;
	}
	
	public static void prepareField_3() {
		for(int x=0; x < 20; x++) {
			for(int y=0; y < 15; y++) {
				field_3[x][y] = 31;
			}
		}
		field_3[9][5] = 2;
		field_3[9][6] = 2;
		field_3[9][7] = 2;
		field_3[9][8] = 2;
		field_3[9][9] = 2;
		field_3[9][10] = 2;
		field_3[9][11] = 2;
		field_3[9][12] = 2;
		field_3[9][13] = 2;
		field_3[9][14] = 2;
		field_3[8][9] = 2;
		field_3[8][10] = 2;
		field_3[8][11] = 2;
		field_3[8][12] = 2;
		field_3[8][13] = 2;
		field_3[10][4] = 2;
		field_3[10][5] = 2;
		field_3[10][6] = 2;
		field_3[10][7] = 2;
		field_3[10][8] = 2;
		field_3[10][9] = 2;
		field_3[10][10] = 2;
		field_3[10][11] = 2;
		field_3[10][12] = 2;
		field_3[10][13] = 2;
		field_3[11][3] = 2;
		field_3[11][4] = 2;
		field_3[11][5] = 2;
		field_3[11][6] = 2;
		field_3[11][7] = 2;
		field_3[11][8] = 2;
		field_3[11][9] = 2;
		field_3[12][2] = 2;
		field_3[12][3] = 2;
		field_3[12][4] = 2;
		field_3[12][5] = 2;
		field_3[13][2] = 2;
		field_3[13][3] = 2;
		field_3[13][4] = 2;
		field_3[14][2] = 2;
		field_3[14][3] = 2;
		field_3[14][4] = 2;
		field_3[15][2] = 2;
		field_3[15][3] = 2;
		field_3[15][4] = 2;
		field_3[16][2] = 2;
		field_3[16][3] = 2;
		field_3[16][4] = 2;
		field_3[17][2] = 2;
		field_3[17][3] = 2;
		field_3[17][4] = 2;
		field_3[18][2] = 2;
		field_3[18][3] = 2;
		field_3[18][4] = 2;
		field_3[19][2] = 2;
		field_3[19][3] = 2;
		field_3[19][4] = 2;
	}
	
	public static void prepareField_4() {
		for(int x=0; x < 20; x++) {
			for(int y=0; y < 15; y++) {
				field_4[x][y] = 3;
			}
		}
		
		for(int x=0; x < 20; x++) {
			field_4[x][0] = 32;
			field_4[x][14] = 32;
		}
		for(int y=0; y < 15; y++) {
			field_4[0][y] = 32;
			field_4[19][y] = 32;
		}
		field_4[0][2] = 3;
		field_4[0][3] = 3;
		field_4[0][4] = 3;
		field_4[5][5] = 12;
		field_4[5][7] = 21;
		field_4[9][1] = 102;
		field_4[9][13] = 103;
		field_4[1][7] = 104;
		field_4[18][7] = 105;
		field_4[9][7] = 9;
		
	}
	
	//  指定されたフィールドを現在のマップに適応
	public static void adaptField(int index) {
		switch(index) {
		case 0:
			if(bossFlag[0]) {
				field_1[18][7] = 0;
			}
			currentFieldIndex = 0;
			currentField = field_1;
			FieldMassPanel.setFIeldLabelImage(currentField);
			break;
		case 1:
			if(bossFlag[1]) {
				field_2[9][1] = 0;
			}
			if(itemFlag[0]) {
				field_2[1][13] = 0;
			}
			if(itemFlag[1]) {
				field_2[4][2] = 0;
			}
			currentFieldIndex = 1;
			currentField = field_2;
			FieldMassPanel.setFIeldLabelImage(currentField);
			System.out.println(bossFlag[1]);
			if(bossFlag[1]) {
				field_1[7][1] = 1;
			}
			break;
		case 2:
			currentFieldIndex = 2;
			currentField = field_3;
			FieldMassPanel.setFIeldLabelImage(currentField);
			break;
		case 3:
			if(bossFlag[2]) {
				field_4[18][7] = 3;
			}
			if(bossFlag[3]) {
				field_4[9][1] = 3;
			}
			if(bossFlag[4]) {
				field_4[1][7] = 3;
			}
			if(bossFlag[5]) {
				field_4[9][13] = 3;
			}
			currentFieldIndex = 3;
			currentField = field_4;
			FieldMassPanel.setFIeldLabelImage(currentField);
			break;
		}
	}
	
	//  障害物判定、障害物があるとtrue
	public static boolean isObstacle(int x, int y) {
	//  0~9 道, 10~19 町, 20~29 カジノ,30~89 障害物, 90~99 アイテム, 100~ボス
		if(currentField[x][y] < 30 || currentField[x][y] > 39) {
			return false;
		}
		return true;
	}
	
	//  エリア外判定
	public static boolean isOutsideArea(int x, int y) {
			System.out.println("index:"+currentFieldIndex);
		switch(currentFieldIndex) {
		case 0:
			if(currentLocation_X == 19) {
				currentLocation_X = 1;
				currentLocation_Y = 7;
				FieldSystem.adaptField(1);
				FieldMassPanel.repaintPlayer();
				return true;
			}
			break;
		case 1:
			if(currentLocation_X == 0) {
				currentLocation_X = 18;
				currentLocation_Y = 7;
				FieldSystem.adaptField(0);
				FieldMassPanel.repaintPlayer();
				return true;
			}else if(currentLocation_Y == 0) {
				currentLocation_X = 9;
				currentLocation_Y = 13;
				FieldSystem.adaptField(2);
				FieldMassPanel.repaintPlayer();
				return true;
			}
			break;
		case 2:
			if(currentLocation_Y == 14) {
				currentLocation_X = 9;
				currentLocation_Y = 1;
				FieldSystem.adaptField(1);
				FieldMassPanel.repaintPlayer();
				return true;
			}else if(currentLocation_X == 19) {
				currentLocation_X = 1;
				FieldSystem.adaptField(3);
				FieldMassPanel.repaintPlayer();
				return true;
			}
			break;
		case 3:
			if(currentLocation_X == 0) {
				currentLocation_X = 18;
				FieldSystem.adaptField(2);
				FieldMassPanel.repaintPlayer();
				return true;
			}
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		case 7:
			break;
		case 8:
			break;
		}
		return false;
	}
	
	//  イベント管理
	public static void eventManagement(int x, int y) {
		//  0~9 道, 10~19 町, 20~29 カジノ,30~89 障害物, 90~99 アイテム, 100~ボス
		switch(currentField[x][y]) {
		case 0:
		case 1:
		case 2:
		case 3:
			encount();
			break;
		case 9:
			inDemonCastle();
			break;
		case 10:
			inCity(0);
			break;
		case 11:
			inCity(1);
			break;
		case 12:
			inCity(2);
			break;
		case 20:
			BlackjackGame.setMaxBet(1000);
			Observer.getMainWindow().setFrontPanelAndFocus(ScreenMode.BLACKJACK);
			break;
		case 21:
			BlackjackGame.setMaxBet(20000);
			Observer.getMainWindow().setFrontPanelAndFocus(ScreenMode.BLACKJACK);
			break;
		case 90:
			itemCollect();
//				アイテム
			break;
		case 100:
		case 101:
		case 102:
		case 103:
		case 104:
		case 105:
		//  ボス
			bossBattle();
			break;
		}
	}
	
	private static void itemCollect() {
		int index = 0;
		if(currentLocation_X == 1 && currentLocation_Y == 13) {
			index = 2;
			itemFlag[0] = true;
		}else if(currentLocation_X == 4 && currentLocation_Y == 2) {
			index = 53;
			itemFlag[1] = true;
		}
		adaptField(currentFieldIndex);
		BattleSystem.getPlayer().getItems()[index]++;
		FieldLogPanel.addTextArr(Items.getItemName(index) + "を拾った！");
	}
	
	//  エンカウント
	public static void encount() {
		if(new java.util.Random().nextInt(encounter) == 0) {
			Character_Enemy[] enemy = returnEnemy();
			battleStart(enemy);
		}
		
	}
	
	//  戦闘開始
	public static void battleStart(Character_Enemy ... enemy) {
		BattleEnemyImagePanel.setEnemyImages(enemy);
		BattleSystem.containEnemys(enemy);
		BattleEnemySelectPanel.setEnemyLabel();
		Observer.getMainWindow().setFrontPanelAndFocus(ScreenMode.BATTLE);
		BattleDisplayStatusPanel.setLabels();
	}
	
	//  エンカウントする敵を設定
	public static Character_Enemy[] returnEnemy() {
		int rand;
		int enemyRand;
		Character_Enemy[] enemys = new Character_Enemy[0];
		switch(currentFieldIndex) {
		case 0:
			rand = new java.util.Random().nextInt(3);
			enemys = new Character_Enemy[rand+1];
			for(int i=0; i < rand+1; i++) {
				enemys[i] = new Character_Enemy_Slime();
			}
			break;
		case 1:
			rand = new java.util.Random().nextInt(3);
			enemys = new Character_Enemy[rand+1];
			for(int i=0; i < rand+1; i++) {
				enemys[i] = new Character_Enemy_Goblin();
			}
			break;
		case 2:
			rand = new java.util.Random().nextInt(3);
			enemys = new Character_Enemy[rand+1];
			for(int i=0; i < rand+1; i++) {
				enemys[i] = new Character_Enemy_Bat();
			}
			break;
		case 3:
			rand = new java.util.Random().nextInt(3);
			enemys = new Character_Enemy[rand+1];
			for(int i=0; i < rand+1; i++) {
				enemyRand = new java.util.Random().nextInt(4);
				switch(enemyRand){
					case 0:
						enemys[i] = new Character_Enemy_Suzume();
						break;
					case 1:
						enemys[i] = new Character_Enemy_Dragon();
						break;
					case 2:
						enemys[i] = new Character_Enemy_Ookami();
						break;
					case 3:
						enemys[i] = new Character_Enemy_Kame();
						break;
				}
			}
			break;
		}
		return enemys;
	}
	
	//  町出入り
	public static void inCity(int index) {
		MainWindow.getFieldPanel().add(FieldPanel.getCity(index));
		FieldPanel.getCity(index).repaint();
		MainWindow.getFieldPanel().setComponentZOrder(FieldPanel.getCity(index), 0);
		FieldPanel.getCity(index).requestFocus();
	}
	public static void outCity(int index) {
		MainWindow.getFieldPanel().remove(FieldPanel.getCity(index));
		MainWindow.getFieldPanel().repaint();
		FieldPanel.getFieldMassPanel().requestFocus();
	}
	
	//  魔王城入り
	private static void inDemonCastle() {
		if(!bossFlag[2] || !bossFlag[3] || !bossFlag[4] || !bossFlag[5]) {
			FieldLogPanel.addTextArr("魔王城に入るには四神を倒す必要があるようだ...");
			FieldLogPanel.addTextArr("倒していない四神...");
			if(!bossFlag[2]) {
				FieldLogPanel.addTextArr("東、青龍");
			}
			if(!bossFlag[3]) {
				FieldLogPanel.addTextArr("北、玄武");
			}
			if(!bossFlag[4]) {
				FieldLogPanel.addTextArr("西、白虎");
			}
			if(!bossFlag[5]) {
				FieldLogPanel.addTextArr("南、朱雀");
			}
		}else {
			FieldLogPanel.addTextArr("入城した");
		}
	}
	
	private static void bossBattle() {
		switch(currentField[currentLocation_X][currentLocation_Y]) {
		case 100:
			battleStart((Character_Enemy)(new Character_Enemy_Boss_Slime()));
			break;
		case 101:
			battleStart((Character_Enemy)(new Character_Enemy_Boss_Goblin()));
			break;
		case 102:
			battleStart((Character_Enemy)(new Character_Enemy_Boss_Genbu()));
			break;
		case 103:
			battleStart((Character_Enemy)(new Character_Enemy_Boss_Suzaku()));
			break;
		case 104:
			battleStart((Character_Enemy)(new Character_Enemy_Boss_Byakko()));
			break;
		case 105:
			battleStart((Character_Enemy)(new Character_Enemy_Boss_Seiryu()));
			break;
		}
	}
	
	//  敗北処理
	public static void die() {
		switch(currentFieldIndex) {
		case 0:
			currentLocation_X = 3;
			currentLocation_Y = 7;
			break;
		case 1:
			currentLocation_X = 9;
			currentLocation_Y = 7;
			break;
		case 2:
			adaptField(1);
			currentLocation_X = 9;
			currentLocation_Y = 7;
			break;
		case 3:
			adaptField(3);
			currentLocation_X = 5;
			currentLocation_Y = 5;
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		case 7:
			break;
		case 8:
			break;
		}
		FieldMassPanel.repaintPlayer();
		FieldLogPanel.addTextArr("所持金が" + BattleSystem.getPlayer().getGold() / 2 + "減りました");
		BattleSystem.getPlayer().setGold(BattleSystem.getPlayer().getGold() / 2);
		BattleSystem.getPlayer().setCurrentHp(BattleSystem.getPlayer().getMaxHp());
	}
	
	//  購入
	public static void buy(int index) {
		if(BattleSystem.getPlayer().getGold() >= Items.getItemValue(index)) {
			BattleSystem.getPlayer().addItem(index);
			BattleSystem.getPlayer().setGold(BattleSystem.getPlayer().getGold() - Items.getItemValue(index));
			FieldLogPanel.addTextArr(Items.getItemName(index) + "を購入しました。");
		}else {
			FieldLogPanel.addTextArr("Gが足りませんでした");
		}
	}
	
	//  回復
	public static void heal(int index) {
		if(BattleSystem.getPlayer().getItemNum(index) > 0) {
			BattleSystem.getPlayer().reduceItem(index);
			if( ( BattleSystem.getPlayer().getCurrentHp() + Items.getItemEffect(index) ) > BattleSystem.getPlayer().getMaxHp() ) {
				BattleSystem.getPlayer().setCurrentHp(BattleSystem.getPlayer().getMaxHp());
			}else {
				BattleSystem.getPlayer().setCurrentHp( BattleSystem.getPlayer().getCurrentHp() + Items.getItemEffect(index) );
			}
			FieldLogPanel.addTextArr( BattleSystem.getPlayer().getName() + "は、" + Items.getItemEffect(index) + "回復した！" );
			
		}
	}
	
	//  ゲッター
	public static int[][] getfield_1() {
		return field_1;
	}
	public static int[][] getCurrentField(){
		return currentField;
	}
	public static int getCurrentLocation_X() {
		return currentLocation_X;
	}
	public static int getCurrentLocation_Y() {
		return currentLocation_Y;
	}
	public static int getCurrentFieldIndex() {
		return currentFieldIndex;
	}
	public static boolean getBossFlag(int index) {
		return bossFlag[index];
	}
	public static boolean[] getBossFlag() {
		return bossFlag;
	}
	public static boolean[] getItemFlag() {
		return itemFlag;
	}




	//  セッター
	public static void setfield_1(int[][] field_1) {
		FieldSystem.field_1 = field_1;
	}
	public static void setCurrentField(int[][] currentField) {
		FieldSystem.currentField = currentField;
	}
	public static void setCurrentLocation_X(int currentLocation_X) {
		FieldSystem.currentLocation_X = currentLocation_X;
	}
	public static void setCurrentLocation_Y(int currentLocation_Y) {
		FieldSystem.currentLocation_Y = currentLocation_Y;
	}
	public static void setCurrentFieldIndex(int currentFieldIndex) {
		FieldSystem.currentFieldIndex = currentFieldIndex;
	}
	public static void setBossFlag(int index, boolean flag) {
		FieldSystem.bossFlag[index] = flag;
	}
	public static void setBossFlag(boolean[] bossFlag) {
		FieldSystem.bossFlag = bossFlag;
	}
	public static void setItemFlag(boolean[] itemFlag) {
		FieldSystem.itemFlag = itemFlag;
	}
	public static void setEncounter(int encounter) {
		FieldSystem.encounter = encounter;
	}
	
	public static void setFieldMass(int fieldIndex, int x, int y, int massIndex) {
		switch(fieldIndex) {
		case 0:
			field_1[x][y] = massIndex;
			break;
		case 1:
			field_2[x][y] = massIndex;
			break;
		case 2:
			field_3[x][y] = massIndex;
			break;
		case 3:
			field_4[x][y] = massIndex;
			break;
		case 4:
			field_5[x][y] = massIndex;
			break;
		case 5:
			field_6[x][y] = massIndex;
			break;
		case 6:
			field_7[x][y] = massIndex;
			break;
		}
	}
}
