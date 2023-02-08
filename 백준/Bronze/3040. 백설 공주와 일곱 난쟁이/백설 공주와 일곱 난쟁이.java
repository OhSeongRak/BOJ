import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // br.readLine();
		
		nineDwarfs = new int[9];
		sevenDwarfs = new int[7];
		for (int i = 0; i < 9; i++) {
			nineDwarfs[i] = Integer.parseInt(br.readLine());
		}

		int cnt = 0;
		int sum = 0;
		int start = 0;
		findDwarf(sum, cnt, start);

	} // end of main

	static int[] nineDwarfs;
	static int[] sevenDwarfs;

	static StringBuilder sb = new StringBuilder();
	public static void findDwarf(int sum, int cnt, int start) {
		if (cnt == 7) {
			if (sum == 100) {
				for (int k : sevenDwarfs)
					sb.append(k).append("\n");
				System.out.println(sb.toString());
			}
			return;
		}

		for (int i = start; i < 9; i++) {
			sevenDwarfs[cnt] = nineDwarfs[i];
			findDwarf(sum + nineDwarfs[i], cnt + 1, i + 1);
		}

	} // end of fdMethod
} // end of class
