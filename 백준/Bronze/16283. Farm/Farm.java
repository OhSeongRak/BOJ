
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		int n = sc.nextInt();
		int w = sc.nextInt();
		int sheep = 0;
		int goat = 0;
		boolean can = false;

		for (int s = 1; s < n; s++) {
			int g = n - s;
			if (s * a + g * b == w && can == false) {
				can = true;
				sheep = s;
				goat = g;
			} else if (s * a + g * b == w && can == true) {
				System.out.println(-1);
				return;
			}
		}

		if (can)
			System.out.println(sheep + " " + goat);
		else
			System.out.println(-1);
	} // end of main
}
