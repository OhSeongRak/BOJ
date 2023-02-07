import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	static int[] swichArr = new int[101];
	static int[] flag = { 1, 0 };

	static void man(int sNum, int N) {
		int k = sNum;
		while (k <= N) {
			swichArr[k] = flag[swichArr[k]];
			k += sNum;
		}
	}

	static void woman(int sNum, int N) {
		swichArr[sNum] = flag[swichArr[sNum]];
		int k = 1;
		while (true) {
			if (sNum - k < 1 || sNum + k > N || (swichArr[sNum + k] != swichArr[sNum - k]))
				break;
			swichArr[sNum + k] = flag[swichArr[sNum + k]];
			swichArr[sNum - k] = flag[swichArr[sNum - k]];
			k++;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // br.readLine();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			swichArr[i] = Integer.parseInt(st.nextToken());
		}

		int studentNum = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
		for (int i = 0; i < studentNum; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int person = Integer.parseInt(st.nextToken());
			int sNum = Integer.parseInt(st.nextToken());
			if (person == 1)
				man(sNum, N);
			else
				woman(sNum, N);
		}

		for (int i = 1; i <= N; i++) {
			System.out.print(swichArr[i] + " ");
			if (i % 20 == 0)
				System.out.println();
		}

	} // end of main
}
