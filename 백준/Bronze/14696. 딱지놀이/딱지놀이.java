
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] ddakA;
	static int[] ddakB;
	static int N, a, b;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;

		N = Integer.parseInt(br.readLine());
		loop: for (int t = 0; t < N; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			ddakA = new int[5];
			for (int i = 1; i <= a; i++)
				ddakA[Integer.parseInt(st.nextToken())]++;

			st = new StringTokenizer(br.readLine(), " ");
			b = Integer.parseInt(st.nextToken());
			ddakB = new int[5];
			for (int i = 1; i <= b; i++)
				ddakB[Integer.parseInt(st.nextToken())]++;

			for (int i = 4; i > 0; i--) {
				if (ddakA[i] < ddakB[i]) {
					System.out.println("B");
					continue loop;
				} else if (ddakA[i] > ddakB[i]) {
					System.out.println("A");
					continue loop;
				}
			}
			System.out.println("D");

		}
	} // end of main
}
