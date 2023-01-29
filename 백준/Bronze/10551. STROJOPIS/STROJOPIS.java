import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        String[] keybords = { "1QAZ", "2WSX", "3EDC", "4RFV5TGB", "6YHN7UJM", "8IK,", "9OL.", "0P;/-['=]" };		int[] finger = new int[8];
		String str = sc.next();

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			for (int j = 0; j < keybords.length; j++) {
				if (keybords[j].contains(c + "")) {
					finger[j]++;
					break;
				}
			}
		}
		for (int i = 0; i < finger.length; i++) {
			System.out.println(finger[i]);
		}
	} // end of main
}
