
import java.util.Scanner;

public class Main {
	static int N;
	static int cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		cnt = 0;
		while (N % 5 != 0) {
			N -= 3;
			cnt++;
		}
		if (N >= 5 || N == 0)
			System.out.println(cnt + N / 5);
		else
			System.out.println(-1);
	} // end of main
}
