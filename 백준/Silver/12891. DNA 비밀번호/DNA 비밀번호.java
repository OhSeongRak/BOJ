import java.io.*;
import java.util.*;
import java.util.function.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    static int[] arr;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        //int numberCount = Integer.parseInt(st.nextToken());

        int strLen = Integer.parseInt(st.nextToken());
        int slidingSize = Integer.parseInt(st.nextToken());

        String[] dna = {"A","C","G","T"};
        String str = br.readLine();

        st= new StringTokenizer(br.readLine());
        int[] strCount = new int[4];
        for(int i = 0; i<strCount.length; i++){
            strCount[i] = Integer.parseInt(st.nextToken());

        }

        // 총 문자열에서 0부터 slidingSize 만큼 반복한다.
        // 시작위치 + slidingSize > 총문자열의 마지막길이 보다 커지면 종료.
        int[] check = new int[4];
        int rcount = 0;
        int start = 0;
        int s = 0;
        int e = slidingSize - 1;
        //미리 넣어두기
        for(int i = 0; i<slidingSize; i++){
            for(int j = 0; j<4; j++)
                if((str.charAt(i) +"").equals(dna[j])){
                    check[j]++;
                }
        }


        // 
        while(start + slidingSize <= str.length()){ // 슬라이딩
            //숫자가 이상인지 검증
            int counts = 0;
            for(int i = 0; i< check.length; i++){
                if(check[i] >= strCount[i])
                    counts++;
            }
            if(counts == 4)
                rcount++;
            s++;
            e++;
            start++;
            if(e == str.length()){
                break;
            }
            // check 배열에서 s-1 인거 버리고, 현재 e인거 추가
            for(int i =0; i<4; i++){
                if((str.charAt(s-1)+"").equals(dna[i])){
                    check[i]--;
                }
                if((str.charAt(e)+"").equals(dna[i])){
                    check[i]++;
                }
            }
        }
        System.out.println(rcount);
    }
}


