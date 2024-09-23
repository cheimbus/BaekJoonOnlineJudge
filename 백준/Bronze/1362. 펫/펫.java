import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringBuilder sb = new StringBuilder();
         
        int scenario = 0;
        
        while(true) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int o = Integer.parseInt(stk.nextToken());
            int w = Integer.parseInt(stk.nextToken());
            
            scenario++;
            boolean isDead = false;
            
            if(o == 0 && w == 0) break;
            
            while(true) {
                stk = new StringTokenizer(br.readLine());
                String s = stk.nextToken();
                int t = Integer.parseInt(stk.nextToken());
                
                if(s.equals("F")) {
                    w += t;
                }
                else if(s.equals("E")) {
                    w -= t;
                    if(w <= 0) {
                        isDead = true;
                    }
                }
                else if(s.equals("#")) {
                    break;
                }
            }
            
            if(isDead) {
                sb.append(scenario).append(" RIP\n");
            } else if(w > o / 2 && o * 2 > w) {
                sb.append(scenario).append(" :-)\n");
            } else {
                sb.append(scenario).append(" :-(\n");
            }
        }
        
        System.out.print(sb);
    }
}
