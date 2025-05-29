package swingRpg;

public class Main {

	public static void main(String[] args) {
		Observer o = new Observer();
		while(true) {
			CommandPanel.inputCommandSystem(new java.util.Scanner(System.in).nextLine());
			CommandPanel.enterPressed();
		}
	}
}
