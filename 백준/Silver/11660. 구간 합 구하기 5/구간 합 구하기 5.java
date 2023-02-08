
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // br.readLine();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] prefixSum = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				prefixSum[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 가로 누적합
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				prefixSum[i][j] += prefixSum[i][j - 1];
			}
		}

		// 세로 누적합
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				prefixSum[j][i] += prefixSum[j - 1][i];
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			System.out.println(
					prefixSum[x2][y2] - prefixSum[x2][y1 - 1] - prefixSum[x1 - 1][y2] + prefixSum[x1 - 1][y1 - 1]);
		}

	} // end of main
}
