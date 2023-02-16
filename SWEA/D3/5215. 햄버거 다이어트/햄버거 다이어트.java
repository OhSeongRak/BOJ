import java.util.*;
import java.io.*;
 
/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
     
    static int max = 0;
    static int calLimit = 0;
    static List<Stuff> cal;
    static List<Stuff> temp;
     
    public static void main(String args[]) throws Exception
    {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
 
        for(int i =1; i<=count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            calLimit = Integer.parseInt(st.nextToken());
 
            temp = new ArrayList<>();
            cal = new ArrayList<>();
 
            for(int j = 0; j<size; j++) {
                temp.add(new Stuff(0, 0));
                st = new StringTokenizer(br.readLine());
                cal.add(new Stuff(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }
 
            // 조합인데, 칼로리를 넘으면 안되고, 그 중에서 최고의 맛.
            for(int j = 1; j<=size; j++){
                bt(j, 0, 0, 0,0);
            }
 
            System.out.println("#" + i + " " + max);
 
            max = 0;
            calLimit = 0;
        }
    }
 
    public static void bt(int limit, int n, int idx, int calTest, int maxSum){
        if(calTest > calLimit)
            return;
         
        if(limit == n){
            if(calLimit >= calTest ) {
                max = Math.max(max,maxSum);
            }
            return;
        }
 
        for(int i = idx; i<cal.size(); i++){
            temp.set(n, cal.get(i));
            bt(limit, n + 1, i + 1, calTest + cal.get(i).cal, maxSum + cal.get(i).tasty);
        }
    }
}
 
class Stuff{
    int tasty, cal;
    public Stuff(int tasty, int cal){
        this.tasty = tasty;
        this.cal = cal;
    }
 
    @Override
    public String toString() {
        return this.tasty + " "+ this.cal;
    }
}