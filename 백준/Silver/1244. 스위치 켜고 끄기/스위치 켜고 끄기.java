
import java.util.*;
import java.io.*;

public class Main {
	static List<Integer> list;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		StringTokenizer st = new StringTokenizer(br.readLine());
		list = new ArrayList<>();
		list.add(99999);
		while(st.hasMoreTokens())
			list.add(Integer.parseInt(st.nextToken()));
		
		int studentNumber = Integer.parseInt(br.readLine());
		
		// 남학생은 스위치 번호 배수를 바꾼다.
		// 여학생은 번호를 중심으로 양옆이 같으면 바꾼다.
		int gender = 0;
		int number = 0;
		
		while(studentNumber-->0) {
			st = new StringTokenizer(br.readLine());
			gender = Integer.parseInt(st.nextToken());
			number = Integer.parseInt(st.nextToken());
			
			if(gender == 1) 
				m(number);
			else 
				w(number);
		}
		
		for(int i = 1; i<list.size(); i++) {
			System.out.print(list.get(i) + " ");
			if(i % 20 == 0)
				System.out.println();
		}
			
	}
	
	public static void m(int number) {
		for(int i = number; i<list.size(); i+= number) 
			list.set(i, list.get(i) == 1 ? 0 : 1);
	}
	public static void w(int number) {
		int s = number - 1;
		int e = number + 1;
		
		while(s >= 1 && e < list.size()) {
			if(list.get(s) == list.get(e)) {
				s--;
				e++;
			}else 
				break;
		}
		
		s++;
		e--;
		
		for(int i = s; i<=e; i++) {
			list.set(i, list.get(i) == 1 ? 0 : 1);
		}
		
	}
}
