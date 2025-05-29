package swingRpg;

public class CommandSystem {
	
	public static void commandDecision(String command) {
		try {
				
		}catch(NumberFormatException e) {
			CommandPanel.addLog("");
		}
		boolean jud = false;
		if(command.length() >= 20) {
			if(command.substring(0, 12).equals("setFieldMass")) {
				setFieldMass(command);
				jud = true;
			}
		}
		if(command.length() >= 19) {
			if(command.substring(0, 9).equals("setStatus")) {
				setStatus(command);
				jud = true;
			}
		}
		if(command.length() >= 18) {
			if(command.substring(0, 14).equals("useStatusPoint")) {
				useStatusPoint(command);
				jud = true;
			}
		}
		if(command.length() >= 16) {
			if(command.substring(0, 14).equals("addStatusPoint")) {
				addStatusPoint(command);
				jud = true;
			}
		}
		if(command.length() >= 12) {
			if(command.equals("displayTitle")) {
				displayTitle();
				jud = true;
			}else if(command.substring(0, 8).equals("teleport")) {
				teleport(command);
				jud = true;
			}else if(command.substring(0, 10).equals("setEncount")) {
				setEncount(command);
				jud = true;
			} 
		}
		if(command.length() >= 11) {
			if(command.substring(0, 11).equals("resetStatus")) {
				resetStatus();
				jud = true;
			}
		}
		if(command.length() >= 9) {
			if(command.substring(0, 9).equals("changeMap")) {
				changeMap(command);
				jud = true;
			}
		}
		if(command.length() >= 8) {
			if(command.substring(0, 8).equals("giveItem")) {
				giveItem(command);
				jud = true;
			}
			if(command.substring(0, 8).equals("clearLog")) {
				clearLog();
				jud = true;
			}
		}
		if(command.length() >= 7) {
			if(command.substring(0, 7).equals("addGold")) {
				addGold(command);
				jud = true;
			}
			if(command.substring(0, 7).equals("newGame")) {
				newGame();
				jud = true;
			}
		}
		if(command.length() >= 6) {
			if(command.substring(0, 6).equals("addExp")) {
				addExp(command);
				jud = true;
			}
		}
		if(command.length() >= 4) {
			if(command.substring(0, 4).equals("save")) {
				save();
				jud = true;
			}else if(command.substring(0, 4).equals("load")) {
				load();
				jud = true;
			}
		}
		if(!jud) {
			CommandPanel.addLog("コマンドが見つかりませんでした。");
		}
	}
	
	//  フィールドのマス変更
	private static void setFieldMass(String command) {
		String[] arr = command.substring(13).split(" ");
		//  フィールド番号, x, y, マス番号
		try {
			FieldSystem.setFieldMass(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]), Integer.parseInt(arr[2]), Integer.parseInt(arr[3]));
			FieldSystem.adaptField(Integer.parseInt(arr[0]));
			CommandPanel.addLog(arr[0] + "番目のフィールド(" + arr[1] + "" + arr[2] + "を" + arr[3] + "へ書き換えました。");
		}catch(NumberFormatException e) {
			CommandPanel.addLog("数字を認識できませんでした。[giveGold int]で入力してください");
		}
	}
	//  ステータス変更
	private static void setStatus(String command) {
		String[] arr = command.substring(10).split(" ");
		try{
			BattleSystem.getPlayer().setStatus(arr[0], Integer.parseInt(arr[1]), Integer.parseInt(arr[2]), Integer.parseInt(arr[3]), Integer.parseInt(arr[4]));
			CommandPanel.addLog("ステータスの変更に成功しました。");
		}catch(NumberFormatException e) {
			CommandPanel.addLog("数字を認識できませんでした。[setStatus String int int int int]で入力してください");
		}catch(java.lang.ArrayIndexOutOfBoundsException e) {
			CommandPanel.addLog("数字を認識できませんでした。[setStatus String int int int int]で入力してください");
		}
	}
	
	//  ステータスポイント増加
	private static void addStatusPoint(String command) {
		try {
			BattleSystem.getPlayer().setStatusPoint(BattleSystem.getPlayer().getStatusPoint() + Integer.parseInt(command.substring(15)));
			CommandPanel.addLog("ステータスポイントを" + command.substring(15) + "増やしました。");
		}catch(NumberFormatException e) {
			CommandPanel.addLog("数字を認識できませんでした。[addStatusPoint int]で入力してください。");
		}
	}
	
	//  タイトルパネルへ偏移
	private static void displayTitle() {
		Observer.getMainWindow().setFrontPanelAndFocus(ScreenMode.TITLE);
	}
	
	//  テレポート
	private static void teleport(String command) {
		if(command.substring(0, 8).equals("teleport")) {
			String[] arr = command.substring(9).split(" ");
			try {
				if(Integer.parseInt(arr[0]) <= 19 && Integer.parseInt(arr[1])  <= 15) {
					FieldSystem.setCurrentLocation_X(Integer.parseInt(arr[0]));
					FieldSystem.setCurrentLocation_Y(Integer.parseInt(arr[1]));
					FieldPanel.repaintPlayer();
					CommandPanel.addLog("テレポートしました。");
				}else {
					CommandPanel.addLog("数字が大きすぎます。19以下,14以下で打ってください。");
				}
			}catch(NumberFormatException e) {
				CommandPanel.addLog("数字を認識できませんでした。[teleport int int]で入力してください。");
			}
		}
	}
	
	//  エンカウント率変更
	private static void setEncount(String command) {
		try {
			FieldSystem.setEncounter(Integer.parseInt(command.substring(11)));
			CommandPanel.addLog("エンカウント率を" + command.substring(11) + "へ変更しました。");
		}catch(NumberFormatException e) {
			CommandPanel.addLog("数字を認識できませんでした。[setEncount int]で入力してください。");
		}

	}
	
	//  Exp加算
	private static void addExp(String command) {
		try {
			BattleSystem.getPlayer().setExp(BattleSystem.getPlayer().getExp() + Integer.parseInt(command.substring(7)));
			CommandPanel.addLog("EXPを" + Integer.parseInt(command.substring(7)) + "増やしました。");
		}catch(NumberFormatException e) {
			CommandPanel.addLog("数字を認識できませんでした。[giveExp int]で入力してください。");
		}
	}
	
	//  ゴールド加算
	public static void addGold(String command) {
		try {
			BattleSystem.getPlayer().setGold(BattleSystem.getPlayer().getGold() + Integer.parseInt(command.substring(8)));
			CommandPanel.addLog("Goldを" + Integer.parseInt(command.substring(8)) + "増やしました。");
		}catch(NumberFormatException e) {
			CommandPanel.addLog("数字を認識できませんでした。[giveGold int]で入力してください。");
		}
	}
	
	//  アイテム贈与
	private static void giveItem(String command) {
		String[] arr = command.substring(9).split(" ");
		try {
			BattleSystem.getPlayer().addItem(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
			CommandPanel.addLog(Items.getItemName(Integer.parseInt(arr[0])) + "を" + Integer.parseInt(arr[1]) + "個与えました。");
		}catch(java.lang.ArrayIndexOutOfBoundsException e) {
			CommandPanel.addLog("アイテムが存在しません。149以下の数値を入力してください");
		}catch(NumberFormatException e) {
			CommandPanel.addLog("数字を認識できませんでした。[giveItem int int]で入力してください。");
		}
	}
	
	//  ステータスリセット
	private static void resetStatus() {
		for(int i=50; i < BattleSystem.getPlayer().getMaxHp(); i += 5) {
			BattleSystem.getPlayer().setStatusPoint(BattleSystem.getPlayer().getStatusPoint() + 1);
		}
		for(int i=30; i < BattleSystem.getPlayer().getAttack(); i += 2) {
			BattleSystem.getPlayer().setStatusPoint(BattleSystem.getPlayer().getStatusPoint() + 1);
		}
		for(int i=30; i < BattleSystem.getPlayer().getDefence(); i += 2) {
			BattleSystem.getPlayer().setStatusPoint(BattleSystem.getPlayer().getStatusPoint() + 1);
		}
		for(int i=30; i < BattleSystem.getPlayer().getAgility(); i += 2) {
			BattleSystem.getPlayer().setStatusPoint(BattleSystem.getPlayer().getStatusPoint() + 1);
		}
		BattleSystem.getPlayer().setMaxHp(50);
		BattleSystem.getPlayer().setAttack(30);
		BattleSystem.getPlayer().setDefence(30);
		BattleSystem.getPlayer().setAgility(30);
		if(BattleSystem.getPlayer().getCurrentHp() > BattleSystem.getPlayer().getMaxHp()) {
			BattleSystem.getPlayer().setCurrentHp(BattleSystem.getPlayer().getMaxHp());
		}
	}
	
	//  ステポイント使用
	private static void useStatusPoint(String command) {
		//  useStatusPoint statusIndex point
		String[] arr = command.substring(15).split(" ");
		if(BattleSystem.getPlayer().getStatusPoint() >= Integer.parseInt(arr[1])) {
			for(int i=0; i < Integer.parseInt(arr[1]); i++) {
				BattleSystem.getPlayer().statusUp(Integer.parseInt(arr[0]));
			}
			CommandPanel.addLog("ステータスポイントを" + arr[1] + "回使用しました。");
		}else {
			CommandPanel.addLog("ステータスポイントが足りていません。");
		}
	}
	
	//  マップ変更
	private static void changeMap(String command) {
		if(Integer.parseInt(command.substring(10)) >= 1 && Integer.parseInt(command.substring(10)) <= 5) {
			FieldSystem.adaptField(Integer.parseInt(command.substring(10)));
			CommandPanel.addLog(command.substring(10) + "番目のフィールドへ変更しました");
		}
	}
	
	//  ニューゲーム
	private static void newGame() {
		for(int i=0; i<FieldSystem.getBossFlag().length; i++) {
			FieldSystem.setBossFlag(false, i);
		}
		for(int i=0; i<FieldSystem.getItemFlag().length; i++) {
			FieldSystem.setItemFlag(false, i);
		}
		FieldSystem.adaptField(0);
		FieldSystem.setCurrentLocation_X(1);
		FieldSystem.setCurrentLocation_Y(7);
		FieldMassPanel.repaintPlayer();
		resetStatus();
		BattleSystem.getPlayer().setExp(0);
		BattleSystem.getPlayer().setLevel(1);
		BattleSystem.getPlayer().setNextLevelExp(50);
	}
	
	//  セーブ
	private static void save() {
		SaveAndLoad.dataSave();
		CommandPanel.addLog("ロードしました");
	}
	
	//  ロード
	private static void load() {
		SaveAndLoad.loadSave();
		CommandPanel.addLog("セーブしました");
	}
	
	//  消去ログ
	private static void clearLog() {
		FieldLogPanel.getTextArr().clear();
		CommandPanel.addLog("溜まっているログをクリアしました。");
	}
	
}
