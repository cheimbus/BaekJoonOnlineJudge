import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        ArrayList<Boolean> sec = new ArrayList<>();
        
        int n = Integer.parseInt(stk.nextToken());
        int l = Integer.parseInt(stk.nextToken());
        int d = Integer.parseInt(stk.nextToken());
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < l; j++) {
                sec.add(false);
            }
            for(int k = 0; k < 5; k++) {
                sec.add(true);
            }
        }
        
        int res = 0;
        while(sec.size() > res) {
            if(sec.get(res)) break;
            res += d;
        }
        System.out.print(res);
    }
}