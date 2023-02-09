import java.util.*;
import java.io.*;


public class Main {
	
	static SSSS[] sss;
	static SSSS[] temp;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int count = Integer.parseInt(br.readLine());
		int loop = count;
		sss = new SSSS[count];
		
		int idx = 0;
		while(count --> 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int ss= Integer.parseInt(st.nextToken());
			
			sss[idx++] = new SSSS(s, ss);
		}
		
		
		for(int i = 1; i<= loop; i++) {
			temp = new SSSS[i];
			comb(i, 0, 0);
		}
		
		System.out.println(min);
		
	}
	
	public static void comb(int limit, int n, int idx) {
		if(limit == n) {
			int sMul = 1;
			int ssSum = 0;
			
			for(SSSS s : temp) {
				sMul *= s.sin;
				ssSum += s.ssn;
			}
			min = Math.min(min, Math.abs(sMul - ssSum));
			return;
		}
		
		for(int i = idx; i<sss.length; i++) {
			temp[n] = sss[i];
			comb(limit, n + 1, i + 1);
		}
	}
}

class SSSS{
	int sin, ssn;
	public SSSS(int s, int ss) {
		this.sin = s;
		this.ssn =ss;
	}
	
	@Override
	public String toString() {
		return this.sin + " " +this.ssn;
	}
}