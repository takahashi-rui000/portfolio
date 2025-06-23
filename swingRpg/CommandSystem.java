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
		if(command.length() >= 16) {
			if(command.substring(0, 14).equals("addStatusPoint")) {
				addStatusPoint(command);
				jud = true;
			}
		}
		if(command.length() >= 12) {
			if(command.substring(0, 8).equals("teleport")) {
				teleport(command);
				jud = true;
			}else if(command.substring(0, 10).equals("setEncount")) {
				setEncount(command);
				jud = true;
			}
		}
		if(command.length() >= 7) {
			if(command.substring(0, 8).equals("giveItem")) {
				giveItem(command);
				jud = true;
			}
			if(command.substring(0, 7).equals("addGold")) {
				addGold(command);
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
	
	//  テレポート
	private static void teleport(String command) {
		if(command.substring(0, 8).equals("teleport")) {
			String[] arr = command.substring(9).split(" ");
			try {
				if(Integer.parseInt(arr[0]) <= 19 && Integer.parseInt(arr[1])  <= 15) {
					FieldSystem.setCurrentLocation_X(Integer.parseInt(arr[0]));
					FieldSystem.setCurrentLocation_Y(Integer.parseInt(arr[1]));
					FieldPanel.repaintPlayer();
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
	
	//  セーブ
	private static void save() {
		SaveAndLoad.dataSave();
		CommandPanel.addLog("セーブしました");
	}
	
	//  ロード
	private static void load() {
		SaveAndLoad.loadSave();
		CommandPanel.addLog("セーブしました");
	}
	

	
}
