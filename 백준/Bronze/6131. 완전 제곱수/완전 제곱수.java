
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int cnt = 0;
		for (int B = 1; B <= 999; B++) {
			for (int A = B; A <= 1000; A++) {
				if (A * A == B * B + N)
					cnt++;
			}
		}
		System.out.println(cnt);
	} // end of main
}
