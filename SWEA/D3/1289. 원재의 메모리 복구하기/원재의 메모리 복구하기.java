import java.util.Scanner;

// 140 ms
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			String N = sc.next();
			char curNum = '0';
			int count = 0;
			
			for (int i = 0; i < N.length(); i++) {
				if (curNum == N.charAt(i))
					continue;
				curNum = N.charAt(i);
				count++;
			}

			System.out.printf("#%d %d%n", test_case, count);
		} // end of test_case
	} // end of main
}
