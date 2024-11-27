import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int ans = 0;
        StringBuilder sb = new StringBuilder();
        while(n -- > 0) {
            String s = br.readLine();
            char[] cArr = s.toCharArray();
            int cnt = 1;
            for(char c : cArr) {
                if(c == 'O') {
                    ans += cnt ++;
                } else cnt = 1;
            }
            sb.append(ans).append("\n");
            ans = 0;
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
    }
}