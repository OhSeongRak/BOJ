import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static Set<String> numSet = new HashSet<>(); // 초기값 : 111~999

	// 중복 체크 함수
	static boolean canNumber(String s) {
		if (s.charAt(0) == s.charAt(1) || s.charAt(0) == s.charAt(2) || s.charAt(1) == s.charAt(2))
			return false;
		if (s.contains("0"))
			return false;

		return true;
	}

	// 1. 가능한 숫자를 찾아서 tmpSet에 추가
	// 2. numSet을 tmpSet과의 교집합만 남김.
	static void findPossibleNumber(String numStr, int strike, int ball) {
		Set<String> tmpSet = new HashSet<>();

		for (int i = 111; i < 1000; i++) {
			String tmp = String.valueOf(i);
			if (!numSet.contains(tmp)) // numSet에 있는 숫자 => 가능한 경우의 수
				continue;
			int sCount = 0; // tmp와 numStr 간의 strike 개수
			int bCount = 0; // tmp와 numStr 간의 ball 개수
			for (int j = 0; j < 3; j++) {
				if (tmp.charAt(j) == numStr.charAt(j)) // 위치가 같으면 sCount++
					sCount++;
				else if (numStr.contains(tmp.charAt(j) + "")) // 위치는 다르지만 포함하고 있다면 bCount++
					bCount++;
			}

			if (sCount == strike && bCount == ball) // 정보가 같다면 tmpSet에 추가
				tmpSet.add(tmp);
		}

		numSet = tmpSet; // numSet과 tmpSet의 교집합만 numSet에 남김
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // br.readLine();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		for (int i = 111; i < 1000; i++) {
			String tmp = String.valueOf(i);
			if (!canNumber(tmp)) // 숫자야구로 사용할 수 있는 숫자인지 판별
				continue;
			numSet.add(tmp); // 사용 가능한 숫자면 numSet에 넣어줌
		}

//		for (String s: numSet)
//			System.out.println(s);
//
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String numStr = st.nextToken();
			int strike = Integer.parseInt(st.nextToken());
			int ball = Integer.parseInt(st.nextToken());
			findPossibleNumber(numStr, strike, ball); // 주어진 입력값을 통해 가능한 경우의 모든 숫자를 numSet에 남김
		}
//
		System.out.println(numSet.size());

	} // end of main
}
