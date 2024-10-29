import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static int a, b, v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        a = Integer.parseInt(stk.nextToken());
        b = Integer.parseInt(stk.nextToken());
        v = Integer.parseInt(stk.nextToken());

        int day = (v - b) / (a - b);
        if((v - b) % (a - b) != 0) day ++;

        bw.write(day + "\n");
        bw.flush();
        bw.close();
    }
}