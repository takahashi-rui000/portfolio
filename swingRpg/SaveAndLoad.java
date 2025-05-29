package swingRpg;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class SaveAndLoad {
	
	public static void dataSave() {
		Savedata savedata = new Savedata(BattleSystem.getPlayer(), FieldSystem.getCurrentLocation_X(), FieldSystem.getCurrentLocation_Y(), FieldSystem.getCurrentFieldIndex(), FieldSystem.getBossFlag(), FieldSystem.getItemFlag());
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			objectMapper.writeValue(new File("savedata.json"), savedata);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void loadSave() {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			Savedata loadedSavedata = objectMapper.readValue(new File("savedata.json"), Savedata.class);
			BattleSystem.setPlayer(loadedSavedata.getPlayer());
			FieldSystem.setCurrentFieldIndex(loadedSavedata.getCurrentLocation_Y());
			FieldSystem.setBossFlag(loadedSavedata.getBossFlag());
			FieldSystem.setItemFlag(loadedSavedata.getItemFlag());
			FieldSystem.adaptField(loadedSavedata.getCurrentFieldIndex());
			FieldSystem.setCurrentLocation_X(loadedSavedata.getCurrentLocation_X());
			FieldSystem.setCurrentLocation_Y(loadedSavedata.getCurrentLocation_Y());
			FieldMassPanel.repaintPlayer();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
}
