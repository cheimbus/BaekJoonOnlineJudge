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

        StringBuilder sb = new StringBuilder();
        String line;
        while((line = br.readLine()) != null) {
            StringTokenizer stk = new StringTokenizer(line);
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            int c = Integer.parseInt(stk.nextToken());
            if(a == 0 && b == 0 && c == 0) break;

            else {
                if(a * a + b * b == c * c || c * c + a * a == b * b || c * c + b * b == a * a) sb.append("right").append("\n");
                else sb.append("wrong").append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        br.close();
    }
}