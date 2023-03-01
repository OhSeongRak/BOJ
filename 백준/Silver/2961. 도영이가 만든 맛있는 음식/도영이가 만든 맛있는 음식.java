import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int minDiff = Integer.MAX_VALUE;
	static int N;
	static int[] bitter;
	static int[] sour;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		bitter = new int[N];
		sour = new int[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			bitter[i] = Integer.parseInt(st.nextToken());
			sour[i] = Integer.parseInt(st.nextToken());
		}

		generateSubset(0, 1, 0, false);
		System.out.println(minDiff);
	}

	private static void generateSubset(int cnt, int bitterMulti, int sourSum, boolean flag) {
		if (flag && minDiff > Math.abs(bitterMulti - sourSum)) {
			minDiff = Math.abs(bitterMulti - sourSum);
		}
		if (cnt == N)
			return;

		generateSubset(cnt + 1, bitterMulti * bitter[cnt], sourSum + sour[cnt], true);
		generateSubset(cnt + 1, bitterMulti, sourSum, flag || false);

	}
}
