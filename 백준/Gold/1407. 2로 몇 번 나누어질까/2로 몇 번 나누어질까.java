import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static long A, B, answer;

	public static void main(String[] args) throws IOException {
		input();
		sol();
	} // end of main

	private static void sol() {
		System.out.println(function(B) - function(A - 1));
	}

	private static long function(long x) {
		long n = 1;
		long sum = 0;
		while (x >= n) {
			long cnt = 1 + (x - n) / (n * 2);
			sum += n * cnt;
			n *= 2;
		}
		return sum;
	}

	private static void input() throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		A = Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken());
	}
}