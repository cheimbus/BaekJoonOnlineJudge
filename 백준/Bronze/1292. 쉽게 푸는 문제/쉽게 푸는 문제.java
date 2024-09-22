import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        ArrayList<Integer> li = new ArrayList<>();
        
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        
        for(int i = 1; i < 1001; i++) {
            for(int j = 1; j <= i; j++) {
                li.add(i);
            }
        }        
        
        int re = 0;
        for(int i = n-1; i <= m-1; i++) {
            re += li.get(i);
        }
        
        System.out.print(re);
    }
}