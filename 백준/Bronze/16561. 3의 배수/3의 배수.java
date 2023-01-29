
import java.util.Scanner;

public class Main {
	static int cnt = 0;

	static void div(int N, int depth) {

		if (depth == 3) {
			cnt++;
			return;
		}
		for (int i = 3; i <= N; i += 3) {
			if (N - i <= 0)
				break;
			div(N - i, depth + 1);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		div(N, 1);
		System.out.println(cnt);
	} // end of main
}
