package swingRpg;

public class Savedata {

	private Character_Player player;
	private int currentLocation_X;
	private int currentLocation_Y;
	private int currentFieldIndex;
	private boolean[] bossFlag;
	private boolean[] itemFlag;
	
	Savedata(Character_Player player, int currentLocation_X, int currentLocation_Y, int currentFieldIndex, boolean[] bossFlag, boolean[] itemFlag){
		this.player = player;
		this.currentLocation_X = currentLocation_X;
		this.currentLocation_Y = currentLocation_Y;
		this.currentFieldIndex = currentFieldIndex;
		this.bossFlag = bossFlag;
		this.itemFlag = itemFlag;
	}
	
	Savedata(){
	}
	
	
	
	
	
	
	public Character_Player getPlayer() {
		return player;
	}
	public int getCurrentLocation_X() {
		return currentLocation_X;
	}
	public int getCurrentLocation_Y() {
		return currentLocation_Y;
	}
	public int getCurrentFieldIndex() {
		return currentFieldIndex;
	}
	public boolean[] getBossFlag() {
		return bossFlag;
	}
	public boolean[] getItemFlag() {
		return itemFlag;
	}

	public void setPlayer(Character_Player player) {
		this.player = player;
	}
	public void setCurrentLocation_X(int currentLocation_X) {
		this.currentLocation_X = currentLocation_X;
	}
	public void setCurrentLocation_Y(int currentLocation_Y) {
		this.currentLocation_Y = currentLocation_Y;
	}
	public void setCurrentFieldIndex(int currentFieldIndex) {
		this.currentFieldIndex = currentFieldIndex;
	}
	public void setBossFlag(boolean[] bossFlag) {
		this.bossFlag = bossFlag;
	}
		public void setItemFlag(boolean[] itemFlag) {
		this.itemFlag = itemFlag;
	}
}
