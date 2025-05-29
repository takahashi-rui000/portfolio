package swingRpg;

public class Items {
	private static int[] itemValue;
	private static String[] itemName;
	private static int[] itemEffect;
	
	public static void prepareItems() {
		itemValue = new int[150];
		itemName = new String[150];
		itemEffect = new int[150];
		
		for(int i=0; i < 150; i++) {
			itemName[i] = "NULL";
			itemValue[i] = 2147483647;
			itemEffect[i] = 0;
		}
		
		//  0~49  アイテム類
		itemName[0] = "薬草";
		itemValue[0] = 10;
		itemEffect[0] = 30;
		itemName[1] = "上薬草";
		itemValue[1] = 50;
		itemEffect[1] = 100;
		itemName[2] = "特薬草";
		itemValue[2] = 100;
		itemEffect[2] = 300;
		itemName[3] = "特上薬草";
		itemValue[3] = 600;
		itemEffect[3] = 600;
		
		//  50~99  武器類
		itemName[50] = "こぶし";
		itemValue[50] = 0;
		itemEffect[50] = 0;
		itemName[51] = "えのきのぼう";
		itemValue[51] = 50;
		itemEffect[51] = 10;
		itemName[52] = "さびた剣";
		itemValue[52] = 300;
		itemEffect[52] = 25;
		itemName[53] = "なまくらの剣";
		itemValue[53] = 600;
		itemEffect[53] = 30;
		itemName[54] = "銅の剣";
		itemValue[54] = 4000;
		itemEffect[54] = 45;
		itemName[55] = "鉄の剣";
		itemValue[55] = 20000;
		itemEffect[55] = 70;
		itemName[56] = "斬鉄の剣";
		itemValue[56] = 100000;
		itemEffect[56] = 90;
		itemName[57] = "黄金の剣";
		itemValue[57] = 2147483647;
		itemEffect[57] = 5;
		itemName[58] = "金剛石の剣";
		itemValue[58] = 300000;
		itemEffect[58] = 150;
		
		itemName[60] = "エクスカリバー";
		itemValue[60] = 0;
		itemEffect[60] = 300;
		
		//  100~149  装備類
		itemName[100] = "ぼろきれ";
		itemValue[100] = 0;
		itemEffect[100] = 0;
		itemName[101] = "布の服";
		itemValue[101] = 30;
		itemEffect[101] = 10;
		itemName[102] = "頑丈な布の服";
		itemValue[102] = 260;
		itemEffect[102] = 25;
		itemName[103] = "さびた鎧";
		itemValue[103] = 3200;
		itemEffect[103] = 45;
		itemName[104] = "鉄の鎧";
		itemValue[104] = 17000;
		itemEffect[104] = 70;
		itemName[105] = "鋼鉄の鎧";
		itemValue[105] = 80000;
		itemEffect[105] = 90;
		itemName[106] = "黄金の鎧";
		itemValue[106] = 2147483647;
		itemEffect[106] = 5;
		itemName[107] = "金剛石の鎧";
		itemValue[107] = 250000;
		itemEffect[107] = 150;
		
		itemName[110] = "伝説の鎧";
		itemValue[110] = 5000000;
		itemEffect[110] = 1000;
	}
	
	
	public static int getItemValue(int index) {
		return itemValue[index];
	}
	public static String getItemName(int index) {
		return itemName[index];
	}
	public static int getItemEffect(int index) {
		return itemEffect[index];
		
	}
	

	public static void setItemValue(int[] itemValue) {
		Items.itemValue = itemValue;
	}
	public static void setItemName(String[] itemName) {
		Items.itemName = itemName;
	}
	
}
