
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int N;
	static int[] input; // 사용자 입력받은 숫자 배열
	static int[] home;
	static int[] company;
	static int[][] customer;
	static int[] numbers; // 순열에서 뽑은 숫자 담을 배열
	static boolean[] isSelected; // 사용한 숫자인지 체크할 플래그 배열
	static int total;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			input();
			permutation(0);
			sb = new StringBuilder();
			sb.append("#").append(test_case).append(" ").append(total);
			System.out.println(sb.toString());
		}
	} // end of main

	private static void input() throws IOException {
		// input
		N = Integer.parseInt(br.readLine());
		input = new int[N];
		home = new int[2];
		company = new int[2];
		customer = new int[N][2];
		numbers = new int[N];
		isSelected = new boolean[N];
		total = Integer.MAX_VALUE;
		st = new StringTokenizer(br.readLine());
		company[0] = Integer.parseInt(st.nextToken());
		company[1] = Integer.parseInt(st.nextToken());
		home[0] = Integer.parseInt(st.nextToken());
		home[1] = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			input[i] = i;
			customer[i][0] = Integer.parseInt(st.nextToken());
			customer[i][1] = Integer.parseInt(st.nextToken());
		}
		// input end
	}

	public static void permutation(int index) {
		if (index == N) {
			int sum = 0;
			sum += distance(company[0], company[1], customer[numbers[0]][0], customer[numbers[0]][1]);
			for (int i = 0; i < N - 1; i++) {
				sum += distance(customer[numbers[i]][0], customer[numbers[i]][1], customer[numbers[i + 1]][0],
						customer[numbers[i + 1]][1]);
			}
			sum += distance(home[0], home[1], customer[numbers[N - 1]][0], customer[numbers[N - 1]][1]);
			total = Math.min(sum, total);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (isSelected[i])
				continue;

			numbers[index] = input[i];
			isSelected[i] = true;
			permutation(index + 1);
			isSelected[i] = false;
		}
	}

	public static int distance(int x1, int y1, int x2, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}
}
