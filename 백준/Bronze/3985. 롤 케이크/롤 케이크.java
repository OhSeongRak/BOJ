
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // br.readLine();
		StringTokenizer st;
		StringBuilder sb;
//		st = new StringTokenizer(br.readLine()); // Integer.parseInt(st.nextToken());

		int L = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int[] rollCake = new int[L + 1];
		int[] expect = new int[2]; // 0: 자신의 번호, 1: 예상롤케익 개수
		int[] winner = new int[2]; // 0: 자신의 번호, 1: 롤케익 개수
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			if (expect[1] < end - start + 1) {
				expect[0] = i + 1;
				expect[1] = end - start + 1;
			}
			int cnt = 0;
			for (int j = start; j <= end; j++) {
				if (rollCake[j] == 0) {
					rollCake[j] = i + 1;
					cnt++;
				}
			}
			if (winner[1] < cnt) {
				winner[0] = i + 1;
				winner[1] = cnt;
			}
		}

		System.out.println(expect[0]);
		System.out.println(winner[0]);

	} // end of main
}
