import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int N;
	static int[] x;
	static int[] y;

	public static void main(String[] args) throws IOException {
		input();
		sol();
	}

	private static void sol() {
		Arrays.sort(x);
		Arrays.sort(y);

		long distance = 0;
		for (int i = 0; i < N / 2; i++) {
			distance += x[N - i - 1] - x[i];
			distance += y[N - i - 1] - y[i];
		}
//		int midX = x[N / 2];
//		int midY = y[N / 2];
//		for (int i = 0; i < x.length; i++) {
//			distance += Math.abs(midX - x[i]) + Math.abs(midY - y[i]);
//		}

		System.out.println(distance);
	} // end of sol

	private static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		x = new int[N];
		y = new int[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
		}
	} // end of input
}