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
        StringBuilder sb = new StringBuilder();

        while(n -- > 0) {
            int num = Integer.parseInt(br.readLine());
            int maxVal = Integer.MIN_VALUE;
            int minVal = Integer.MAX_VALUE;

            StringTokenizer stk = new StringTokenizer(br.readLine());
            while(num -- > 0) {
                int val = Integer.parseInt(stk.nextToken());
                if(maxVal < val) {
                    maxVal = val;
                }
                if(minVal > val) {
                    minVal = val;
                }
            }
            sb.append(minVal).append(" ").append(maxVal).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}