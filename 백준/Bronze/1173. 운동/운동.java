import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());
        int T = Integer.parseInt(stk.nextToken());
        int R = Integer.parseInt(stk.nextToken());
        
        int currM = m;
        int cnt = 0;
        
        if(m + T > M) {
            System.out.print(-1);
            return;
        }
        
        while(N > 0) {
            if(currM + T <= M) {
                N--;
                currM += T;
                cnt++;
            }
            else {
                currM -= R;
                if(currM < m) {
                    currM = m;
                }
                cnt++;
            }
        }
        System.out.print(cnt);
    }
    
}