import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int target = 1;

        for(int i = 0; i < n ; i ++) {
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            if(a == target) {
                target = b;
            }
            else if(b == target) {
                target = a;
            }
        }

        bw.write(String.valueOf(target));
        bw.flush();
        bw.close();
    }
}