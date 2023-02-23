
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int N;
	static int[] home;
	static int[][] customer; // 0번째는 회사
	static int[] numbers; // 순열에서 뽑은 숫자 담을 배열
	static boolean[] isSelected; // 사용한 숫자인지 체크할 플래그 배열
	static int total;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			input();
			permutation(1, 0);
			sb = new StringBuilder();
			sb.append("#").append(test_case).append(" ").append(total);
			System.out.println(sb.toString());
		}
	} // end of main

	private static void input() throws IOException {
		// input
		N = Integer.parseInt(br.readLine());
		home = new int[2];
		customer = new int[N + 1][2];
		numbers = new int[N + 1];
		isSelected = new boolean[N + 1];
		total = Integer.MAX_VALUE;
		st = new StringTokenizer(br.readLine());
		customer[0][0] = Integer.parseInt(st.nextToken());
		customer[0][1] = Integer.parseInt(st.nextToken());
		home[0] = Integer.parseInt(st.nextToken());
		home[1] = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= N; i++) {
			customer[i][0] = Integer.parseInt(st.nextToken());
			customer[i][1] = Integer.parseInt(st.nextToken());
		}
		// input end
	}

	public static void permutation(int index, int sum) {
		if (sum > total)
			return;

		if (index > N) {
			sum += distance(customer[numbers[index - 1]][0], customer[numbers[index - 1]][1], home[0], home[1]);
			total = Math.min(sum, total);
			return;
		}

		for (int i = 1; i <= N; i++) {
			if (isSelected[i])
				continue;

			numbers[index] = i;
			isSelected[i] = true;
			permutation(index + 1, sum + distance(customer[numbers[index - 1]][0], customer[numbers[index - 1]][1],
					customer[numbers[index]][0], customer[numbers[index]][1]));
			isSelected[i] = false;
		}
	}

	public static int distance(int x1, int y1, int x2, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}
}
