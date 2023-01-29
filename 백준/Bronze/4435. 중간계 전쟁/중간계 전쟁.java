
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] gan = { 1, 2, 3, 3, 4, 10 };
		int[] sau = { 1, 2, 2, 2, 3, 5, 10 };
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int ganScore = 0;
			int sauScore = 0;
			for (int i = 0; i < gan.length; i++) {
				ganScore += sc.nextInt() * gan[i];
			}
			for (int i = 0; i < sau.length; i++) {
				sauScore += sc.nextInt() * sau[i];
			}
			System.out.printf("Battle %d: ", tc);
			if (ganScore < sauScore)
				System.out.println("Evil eradicates all trace of Good");
			else if (sauScore < ganScore)
				System.out.println("Good triumphs over Evil");
			else
				System.out.println("No victor on this battle field");

		}
	} // end of main
}
