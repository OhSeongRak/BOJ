
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] score;
	static int[][] fight = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 0, 4 }, { 0, 5 }, { 1, 2 }, { 1, 3 }, { 1, 4 }, { 1, 5 },
			{ 2, 3 }, { 2, 4 }, { 2, 5 }, { 3, 4 }, { 3, 5 }, { 4, 5 } };
	static int possible;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < 4; t++) {
			score = new int[6][3];
			possible = 0;
			// input
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 3; j++) {
					score[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// input end

			find(0);
			sb.append(possible).append(" ");
		}
		System.out.println(sb.toString());

	} // end of main

	private static void find(int cnt) {
		if (possible == 1)
			return;

		if (cnt == 15) {
			for (int i = 0; i < 6; i++)
				for (int j = 0; j < 3; j++)
					if (score[i][j] != 0)
						return;

			possible = 1;
			return;
		}
		
		// i 승리
		if (score[fight[cnt][0]][0] != 0 && score[fight[cnt][1]][2] != 0) {
			score[fight[cnt][0]][0]--;
			score[fight[cnt][1]][2]--;
			find(cnt + 1);
			score[fight[cnt][0]][0]++;
			score[fight[cnt][1]][2]++;
		}

		// 무승부
		if (score[fight[cnt][0]][1] != 0 && score[fight[cnt][1]][1] != 0) {
			score[fight[cnt][0]][1]--;
			score[fight[cnt][1]][1]--;
			find(cnt + 1);
			score[fight[cnt][0]][1]++;
			score[fight[cnt][1]][1]++;
		}

		// i 패배
		if (score[fight[cnt][0]][2] != 0 && score[fight[cnt][1]][0] != 0) {
			score[fight[cnt][0]][2]--;
			score[fight[cnt][1]][0]--;
			find(cnt + 1);
			score[fight[cnt][0]][2]++;
			score[fight[cnt][1]][0]++;
		}
	}
}
