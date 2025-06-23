package swingRpg;

public class Observer {
	private static MainWindow mainWindow;
	Observer(){
		System.out.println("aaaaa");
		Items.prepareItems();
		mainWindow = new MainWindow();
		mainWindow.setVisible(true);
	}
	
	public static MainWindow getMainWindow() {
		return mainWindow;
	}
	
}
