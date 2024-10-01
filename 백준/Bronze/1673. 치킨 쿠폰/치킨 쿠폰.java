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
        String line;

        StringBuilder sb = new StringBuilder();
        while((line = br.readLine()) != null) {
            StringTokenizer stk = new StringTokenizer(line);
            int n = Integer.parseInt(stk.nextToken());
            int k = Integer.parseInt(stk.nextToken());
            int eatCnt = 0;

            eatCnt += n;

            while(k <= n) {
                eatCnt += n / k;
                n = n / k + n % k;
            }

            sb.append(eatCnt).append("\n");
        }
        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }
}