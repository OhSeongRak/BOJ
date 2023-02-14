
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int M;
	static int[] inputs;
	static int answer;

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			inputs = new int[N];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < inputs.length; i++) {
				inputs[i] = Integer.parseInt(st.nextToken());
			}

			answer = -1;
			for (int i = 0; i < inputs.length; i++) {
				for (int j = i + 1; j < inputs.length; j++) {
					int sum = inputs[i] + inputs[j];
					if (sum <= M && M - sum < M - answer)
						answer = sum;
				}
			}
			System.out.printf("#%d %d \n", test_case, answer);
		}

	} // end of main

	public static void comb(int idx, int sum, int cnt) {
		if (M < sum)
			return;

		if (cnt == 2) {
			if (M - sum < M - answer)
				answer = sum;
		}

		for (int i = idx; i < inputs.length; i++) {
			comb(i + 1, sum + inputs[i], cnt + 1);
		}
	}
} // end of class
