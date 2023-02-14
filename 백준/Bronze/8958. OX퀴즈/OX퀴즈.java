import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // br.readLine();
		int N = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < N; tc++) {
			String oxQuiz = br.readLine();
			int sum = 0;
			int cnt = 1;
			for (int i = 0; i < oxQuiz.length(); i++) {
				if (oxQuiz.charAt(i) == 'O')
					sum += cnt++;
				else
					cnt = 1;
			}
			System.out.println(sum);
		}

	} // end of main
}
