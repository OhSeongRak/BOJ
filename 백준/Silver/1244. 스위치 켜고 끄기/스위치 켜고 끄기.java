
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] switchs = new int[101];
	static int[] flag = { 1, 0 };

	static void man(int pos, int N) {
		int k = pos; // k : 시작 위치
		while (k <= N) {
			switchs[k] = flag[switchs[k]];
			k += pos; // pos만큼 증가
		}
	}

	static void woman(int pos, int N) {
		switchs[pos] = flag[switchs[pos]];
		int k = 1;
		while (true) {
			// pos가 범위를 벗어났거나, 대칭이 아니라면 break
			if (pos - k < 1 || pos + k > N || (switchs[pos + k] != switchs[pos - k]))
				break;
			switchs[pos + k] = flag[switchs[pos + k]];
			switchs[pos - k] = flag[switchs[pos - k]];
			k++;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // br.readLine();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			switchs[i] = Integer.parseInt(st.nextToken());
		}

		int studentNum = Integer.parseInt((br.readLine()));
		for (int i = 0; i < studentNum; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int person = Integer.parseInt(st.nextToken());
			int pos = Integer.parseInt(st.nextToken());
			if (person == 1)
				man(pos, N);
			else
				woman(pos, N);
		}

		for (int i = 1; i <= N; i++) {
			System.out.print(switchs[i] + " ");
			if (i % 20 == 0)
				System.out.println();
		}

	} // end of main
}
