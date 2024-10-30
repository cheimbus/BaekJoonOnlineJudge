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

        StringTokenizer stk;
        String line;
        StringBuilder sb = new StringBuilder();
        while((line = br.readLine()) != null) {
            stk = new StringTokenizer(line);
            int n = Integer.parseInt(stk.nextToken());
            int m = Integer.parseInt(stk.nextToken());

            if(n == 0) break;

            if(m % n == 0) sb.append("factor" + "\n");
            else if(n % m == 0) sb.append("multiple" + "\n");
            else sb.append("neither" + "\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}