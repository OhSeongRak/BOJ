
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int R;
	static int C;

	public static void findRC(String str) {
		int n = str.length();
		for (int i = 1; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				R = i;
				C = n / i;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // br.readLine();
		StringBuilder sb = new StringBuilder();

		String str = br.readLine();
		findRC(str);
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sb.append(str.charAt(i + j * R));
			}
		}
		System.out.println(sb.toString());
	} // end of main

}
// R, C는 N의 약수
// R행 C열