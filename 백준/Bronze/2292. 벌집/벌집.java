import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int N, min, max = 1, i = 1, cnt = 2;
		int ans = 1;

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		if (N != 1) {
			ans = 2;
			while (true) {
				min = max;
				max = 1 + 6 * i;
				i += cnt;
				cnt++;
				if (min < N && N <= max) 
					break;
				else
					ans++;
			}
		}

		System.out.println(ans);

	}
}
