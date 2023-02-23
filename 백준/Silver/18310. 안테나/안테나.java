import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

//0 4 6 8 -> +4 -4 -4 -4
//4 0 2 4 -> +2 +2 -2 -2
//6 2 0 2
public class Main {
	static void pro(int[] home, int N) {
		Arrays.sort(home);
		long total = 0;
		int pos = home[0];

		for (int i = 1; i < home.length; i++) {
			total += home[i] - home[0];
		}

		long curSum = total;
		for (int i = 1; i < home.length; i++) {
			curSum -= (home[i] - home[i - 1]) * (N - i);
			curSum += (home[i] - home[i - 1]) * i;

			if (curSum < total) {
				total = curSum;
				pos = home[i];
			}
		}

		System.out.println(pos);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // br.readLine();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " "); 
		int[] home = new int[N];
		for (int i = 0; i < N; i++) {
			home[i] = Integer.parseInt(st.nextToken());
		}

		pro(home, N);
	} // end of main
}
