import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static long n, m;
    public static StringBuilder sb = new StringBuilder();

    public static void findN() {
        StringBuilder s = new StringBuilder();
        while(n > 0) {
            long remain = n % m;
            if(remain >= 10) s.append((char) ('A' + (remain - 10)));
            else s.append(remain);
            n /= m;
        }
        sb.append(s.reverse());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        findN();

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}