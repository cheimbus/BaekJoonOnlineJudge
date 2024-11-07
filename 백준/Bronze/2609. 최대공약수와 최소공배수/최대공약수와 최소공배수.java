import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static int euclidean(int a, int b) {
        if(b == 0) {
            return a;
        }
        return euclidean(b, a % b);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        StringBuilder sb = new StringBuilder();
        int euclidean = euclidean(n, m);
        int lcm = (n * m) / euclidean;

        sb.append(euclidean).append("\n").append(lcm);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}