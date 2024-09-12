import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Collections;

public class Main {
    public static int n,m;
    public static ArrayList<Integer> bucket = new ArrayList<>();
    
    public static void reverseBucket(int x, int y) {
        
        x = x -1;
        
        ArrayList<Integer> subList = new ArrayList<>(bucket.subList(x, y));
        Collections.reverse(subList);
        
        for(int i = 0; i < subList.size(); i++) {
            bucket.set(x+i, subList.get(i));
        }
    }
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
       
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        
        for(int i = 1; i <= n; i++) {
            bucket.add(i);
        }
        
        for(int i = 0; i < m; i++) {
            stk = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());
            
            reverseBucket(x, y);
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i : bucket) {
            sb.append(i).append(" ");
        }
        System.out.print(sb);
    }
}