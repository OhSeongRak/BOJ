
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int D = sc.nextInt();
		int M = sc.nextInt();
		int[] calendar = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		String[] day = { "Thursday", "Friday", "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday" };

		for (int m = 1; m < M; m++) {
			D += calendar[m];
		}

		System.out.println(day[(D - 1) % 7]);
	} // end of main
}
