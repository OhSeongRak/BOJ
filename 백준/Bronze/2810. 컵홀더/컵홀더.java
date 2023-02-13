
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		String seats = br.readLine();

		int cnt = 1;
		boolean coupleFlag = false;
		for (int i = 0; i < seats.length(); i++) {
			char s = seats.charAt(i);
			if (s == 'S')
				cnt++;
			else {
				if (!coupleFlag) {
					coupleFlag = true;
				} else {
					cnt++;
					coupleFlag = false;
				}
			}
		} // end of for

		System.out.println(Math.min(cnt, n));
	} // end of main
}
