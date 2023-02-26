import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int N, K, A, B; // 화분 개수, 초기 수분, A개의 화분에 B만큼 물을 준다
	static ArrayList<Integer> flower = new ArrayList<Integer>();;

	public static void main(String[] args) throws IOException {
		input();
		sol();
	}

	private static void sol() {
		int cnt = 0;
		while (!flower.contains(0)) {
			Collections.sort(flower);
			for (int i = 0; i < A; i++)
				flower.set(i, flower.get(i) + B);

			for (int i = 0; i < N; i++)
				flower.set(i, flower.get(i) - 1);
			cnt++;
		}
		System.out.println(cnt);
	}

	private static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++)
			flower.add(K);
	} // end of input
}