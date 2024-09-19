import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        
        int[] arr = new int[5];
        for(int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        
        boolean isTrue = true;
        int cnt = 0;
        while(isTrue) {
            cnt ++;
            int mul = 0;
            for(int i = 0; i < 5; i++) {
                if(cnt % arr[i] == 0) mul++;  
            }
            if(mul >= 3) {
                isTrue = false;
            }
        }
        
        System.out.print(cnt);
    }
}