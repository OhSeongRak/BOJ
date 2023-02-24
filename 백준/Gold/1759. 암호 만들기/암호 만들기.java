
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	static int L, C;
	static char[] alpha;
	static char[] password;
	static String vowels = "aeiou";

	public static void main(String[] args) throws IOException {
		input();
		combination(0, 0, 0, 0);
	} // end of main

	private static void combination(int cnt, int idx, int vowelCnt, int consCnt) {
		if (cnt == L) {
			if (vowelCnt >= 1 && consCnt >= 2) {
				sb = new StringBuilder();
				for (int i = 0; i < password.length; i++)
					sb.append(password[i]);
				System.out.println(sb.toString());
			}
			return;
		}

		for (int i = idx; i < C; i++) {
			password[cnt] = alpha[i];
			if (vowels.contains(alpha[i] + ""))
				combination(cnt + 1, i + 1, vowelCnt + 1, consCnt);
			else
				combination(cnt + 1, i + 1, vowelCnt, consCnt + 1);
		}
	}

	private static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		alpha = new char[C];
		password = new char[L];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < alpha.length; i++) {
			alpha[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(alpha);
	} // end of input
} // end of class
