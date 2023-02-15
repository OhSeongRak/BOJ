import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int papers = Integer.parseInt(br.readLine());

        // 색종이가 도화지 밖으로 나가는 경우는 없다.
        int[][] arr = new int[101][101];

        while(papers -- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for(int i = x; i<x + 10; i++){
                for(int j = y; j<y + 10; j++){
                    arr[i][j] = 1;
                }
            }
        }

        int count = 0;
        for(int i = 1; i<101; i++){
            for(int j = 1; j<101; j++){
                if(arr[i][j] == 1) count++;
            }
        }
        System.out.println(count);
    }
}
