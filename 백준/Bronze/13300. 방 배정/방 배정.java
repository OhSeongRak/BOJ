
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] grade = new int[7][2];
	static int N, K, answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			grade[g][s]++;
		}

		for (int i = 1; i <= 6; i++) {
			for (int j = 0; j < 2; j++) {
				answer += Math.ceil((double) grade[i][j] / K);
			}
		}

		System.out.println(answer);
	} // end of main
}