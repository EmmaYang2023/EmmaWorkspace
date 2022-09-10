package utilities;

public class Utilities {

	public static int generateRandomNumbers() {
		return (int) (Math.random() * 10000);
	}

	public static void wait(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
