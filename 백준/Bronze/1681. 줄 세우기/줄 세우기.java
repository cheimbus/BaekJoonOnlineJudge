import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static final int MAX_VAL = 1000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        String l = stk.nextToken();
        int cnt = n;
        int ans = 0;
        for(int i = 1; cnt > 0; i ++) {
            String label = String.valueOf(i);
            if(!label.contains(l)) {
                cnt --;
                ans = i;
            }
        }

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
    }
}