
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int L = sc.nextInt();

		if (M == 1) {
			System.out.println(0);
			return;
		}

		int[] friend = new int[N];

		int pos = 0;
		int count = 0;
		friend[pos] = 1;
		while (true) {
			if (friend[pos] % 2 == 0) {
				pos = (pos + L) % N;
				friend[pos]++;
			} else {
				if (pos - L >= 0)
					pos -= L;
				else
					pos = N - (L - pos);
				friend[pos]++;
			}

			count++;
			if (friend[pos] == M)
				break;
		}

		System.out.println(count);
	} // end of main
}
